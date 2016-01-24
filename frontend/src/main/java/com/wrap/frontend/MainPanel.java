package com.wrap.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {
	public static boolean RIGHT_TO_LEFT = false;
	public MainPanel(){
		this.setLayout(new BorderLayout());
         
        if (RIGHT_TO_LEFT) {
            setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }
         


        add(new GamePanel(), BorderLayout.CENTER);
    

		add( new ScoreBoard(), BorderLayout.LINE_END );

        
        

        add(StatBar.getInstance(), BorderLayout.PAGE_END);
	}
}
