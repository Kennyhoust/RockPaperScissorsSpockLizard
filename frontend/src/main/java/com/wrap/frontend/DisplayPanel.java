package com.wrap.frontend;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
public class DisplayPanel extends JPanel {
	GamePanel GamePanel;
	public DisplayPanel(GamePanel GamePanel){
		this.GamePanel = GamePanel;
		this.setLayout(new BorderLayout());
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { "1", "2" };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        add(cb);
        
        
	}
	public void showAnt() {
		Thread thread =new Thread(new Runnable(){

			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				GamePanel.changeLayout(GamePanel.BUTTONPANEL);
			}
		});
		thread.start();
	}
}
