package com.wrap.frontend;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	GamePanel GamePanel;

	public DisplayPanel(GamePanel GamePanel) {
		this.GamePanel = GamePanel;

	}

	public void showAnt() {
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
		g.drawString("asdasd", 90, 90);
		g.drawString("asdasd", 180, 90);
	}
}
