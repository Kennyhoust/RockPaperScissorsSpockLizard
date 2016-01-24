package com.wrap.frontend;

import javax.swing.JLabel;
/**
 * 
 * 
 * @author Kenny
 *	statBar
 */
public class StatBar extends JLabel{
	int win;
	int lose;
	int so;
	private static StatBar StatBar;
	private StatBar(){
		refeshValue();
	}
	public static StatBar getInstance(){
		if(StatBar==null)
			StatBar = new StatBar();
		return StatBar;
	}
	public void addWin(){
		win++;
		refeshValue();
	}
	public void addLose(){
		lose++;
		refeshValue();
	}
	public void addSO(){
		so++;
		refeshValue();
	}
	public void refeshValue(){
		super.setText("win:"+ win + "  lose:"+lose+"   standoff:"+so);
	}
}
