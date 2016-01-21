package com.wrap.frontend;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public GamePanel(){
        JLabel label = new JLabel(" (CENTER)");
        label.setPreferredSize(new Dimension(200, 100));
		this.add(label);
	}
}
