package com.wrap.frontend;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
 * 
 * 
 * @author Kenny
 * Main screen layout
 */
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
