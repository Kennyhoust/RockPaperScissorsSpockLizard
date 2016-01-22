package com.wrap.frontend;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.wrap.backend.constant.Computer;
import com.wrap.backend.constant.Symbols;

public class DisplayPanel extends JPanel implements ActionListener {
	GamePanel GamePanel;
	Symbols you;
	Symbols comp;
	public DisplayPanel(GamePanel GamePanel) {
		this.GamePanel = GamePanel;

	}

	public void showAnt() {
		DisplayPanel.this.repaint();
		Thread thread = new Thread(new Runnable() {

			public void run() {
				short sec = 3;
				while (sec > 0) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					DisplayPanel.this.repaint();
					sec--;
				}
				GamePanel.changeLayout(GamePanel.BUTTONPANEL);
			}
		});
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(you==null?"":you.name(), 90, 90);
		g.drawString(comp==null?"":comp.name(), 180, 90);
	}

	public void actionPerformed(ActionEvent event) {
		SymbolButton SymbolButton = (SymbolButton)event.getSource();
		you=SymbolButton.getSym();
		comp = Computer.getSymbols();
        showAnt();
	}
}
