package com.wrap.frontend;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.wrap.backend.Action;
import com.wrap.backend.Computer;
import com.wrap.backend.Deteminer;
import com.wrap.backend.Symbols;

public class DisplayPanel extends JPanel implements ActionListener {
	GamePanel GamePanel;
	Symbols you;
	Symbols comp;
	int result = -2;
	String resultStr = "";
	private BufferedImage[] image = new BufferedImage[5];

	public DisplayPanel(GamePanel GamePanel) {
		this.GamePanel = GamePanel;
		loadImage();

	}

	public void loadImage() {
		try {
			for (int i = 0; i < 5; i++) {
				URL resource = getClass().getClassLoader().getResource(
						i+".png");
				image[i]= ImageIO.read(resource);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
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

		if(comp!=null&&you!=null){
			// Show Image
			g.drawImage(image[comp.getValue()].getScaledInstance(250, 200, Image.SCALE_DEFAULT),3,100,this);
			g.drawImage(image[you.getValue()].getScaledInstance(250, 200, Image.SCALE_DEFAULT),300,100,this);
		}
		if (result == -1) {
			DoWhenCompWin(g);
		} else if (result == 1) {
			DoWhenPlayerWin(g);
		} else if (result == 0) {
			DoWhenStandOff(g);
		}
	}

	public void DoWhenStandOff(Graphics g) {
		g.drawString(you == null ? "" : you.name(), 90, 20);
		g.drawString(comp == null ? "" : comp.name(), 450, 20);

		g.drawString("Standoff", 250, 90);
	}

	public void DoWhenPlayerWin(Graphics g) {
		g.drawString(you == null ? "" : you.name(), 90, 20);
		g.drawString(resultStr, 270, 20);
		g.drawString(comp == null ? "" : comp.name(), 450, 20);

		g.drawString("Player wins", 250, 90);
	}

	public void DoWhenCompWin(Graphics g) {
		g.drawString(comp == null ? "" : comp.name(), 90, 20);
		g.drawString(resultStr, 270, 20);
		g.drawString(you == null ? "" : you.name(), 450, 20);


		g.drawString("Computer wins", 250, 90);
	}

	/**
	 * it is called when clicking Symbols Btn
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		SymbolButton SymbolButton = (SymbolButton) event.getSource();
		you = SymbolButton.getSym();
		comp = Computer.getInstance().getSymbols(
				ScoreBoardModel.getInstance().getPlayerHistory());
		StatBar.getInstance().refeshValue();
		if (you == comp) {
			result = 0;
			StatBar.getInstance().addSO();
		} else {
			if (Deteminer.DETERMINER[you.getValue()][comp.getValue()] == Action.standoff) {
				resultStr = Deteminer.DETERMINER[comp.getValue()][you
						.getValue()].name();
				result = -1;
				StatBar.getInstance().addLose();
			} else {
				resultStr = Deteminer.DETERMINER[you.getValue()][comp
						.getValue()].name();
				result = 1;
				StatBar.getInstance().addWin();
			}
		}
		ScoreBoardModel.getInstance().add(you, comp, result);
		showAnt();
	}
}
