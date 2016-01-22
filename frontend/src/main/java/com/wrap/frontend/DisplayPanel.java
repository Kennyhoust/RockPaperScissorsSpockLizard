package com.wrap.frontend;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.wrap.backend.constant.Action;
import com.wrap.backend.constant.Computer;
import com.wrap.backend.constant.Deteminer;
import com.wrap.backend.constant.Symbols;

public class DisplayPanel extends JPanel implements ActionListener {
	GamePanel GamePanel;
	Symbols you;
	Symbols comp;
	short result = -2;
	String resultStr = "";
	public DisplayPanel(GamePanel GamePanel) {
		this.GamePanel = GamePanel;

	}

	public void showAnt() {
		DisplayPanel.this.repaint();
		Thread thread = new Thread(new Runnable() {

			public void run() {
				DisplayPanel.this.repaint();
				GamePanel.changeLayout(GamePanel.BUTTONPANEL);
			}
		});
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(result ==-1){
			g.drawString(comp==null?"":comp.name(), 90, 90);
			g.drawString(resultStr, 270, 90);
			g.drawString(you==null?"":you.name(), 450, 90);
			
			g.drawString("Computer wins", 270, 130);
		}else if(result ==1){
			g.drawString(you==null?"":you.name(), 90, 90);
			g.drawString(resultStr, 270, 90);
			g.drawString(comp==null?"":comp.name(), 450, 90);
			
			g.drawString("Player wins", 270, 130);			
		}else if(result ==0){
			g.drawString(you==null?"":you.name(), 90, 90);
			g.drawString(comp==null?"":comp.name(), 450, 90);
			
			g.drawString("Standoff", 270, 130);	
		}
	}

	public void actionPerformed(ActionEvent event) {
		SymbolButton SymbolButton = (SymbolButton)event.getSource();
		you=SymbolButton.getSym();
		comp = Computer.getSymbols(ScoreBoardModel.getInstance().getPlayerHistory());
		ScoreBoardModel.getInstance().add(you, comp);
		
		if (you == comp) {
			result = 0;
		} else {
			if(Deteminer.DETERMINER[you.getValue()][comp.getValue()]==Action.standoff){
				resultStr = Deteminer.DETERMINER[comp.getValue()][you.getValue()].name();
				result =-1;
			}else{
				resultStr = Deteminer.DETERMINER[you.getValue()][comp.getValue()].name();
				result =1;
			}
		}
		
        showAnt();
	}
}
