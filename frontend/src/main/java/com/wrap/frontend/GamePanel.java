package com.wrap.frontend;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wrap.backend.constant.Deteminer;
import com.wrap.backend.constant.Symbols;

public class GamePanel extends JPanel implements ActionListener{
    
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
	public GamePanel(){
		this.setLayout(new BorderLayout());
        JPanel cards; //a panel that uses CardLayout
        //Create the "cards".
        JPanel card1 = new JPanel();
        List<Symbols> symbolsList =Arrays.asList(Symbols.values());
        for(Symbols sym:symbolsList){
        	SymbolButton symBtn = new SymbolButton(sym); 
			card1.add(symBtn);
        }
        
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        
        add(new DisplayPanel(), BorderLayout.CENTER);
        add(cards, BorderLayout.PAGE_END);
	}
	public void actionPerformed(ActionEvent event) {
		SymbolButton SymbolButton = (SymbolButton)event.getSource();
		System.out.println(SymbolButton.getSym().getValue());
	}
}
