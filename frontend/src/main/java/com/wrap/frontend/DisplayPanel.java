package com.wrap.frontend;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
public class DisplayPanel extends JPanel {

	public DisplayPanel(){
		this.setLayout(new BorderLayout());
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { "1", "2" };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        add(cb);
        
        
	}
}
