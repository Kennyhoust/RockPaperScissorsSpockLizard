package com.wrap.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.wrap.backend.constant.Symbols;

public class ScoreBoardModel extends AbstractTableModel {
	private String[] columnNames = { "You", "Comp" };
	private Object[][] data = {
			{ "Kathy", "Smith" }
			};
	private List<Symbols> you = new ArrayList<Symbols>();
	private List<Symbols> comp = new ArrayList<Symbols>();
	public static ScoreBoardModel scoreBoardModel;
	public static ScoreBoardModel getInstance(){
		if(scoreBoardModel == null){
			scoreBoardModel = new ScoreBoardModel();
		}
		return scoreBoardModel;
	}
	private ScoreBoardModel(){
		
	}
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return you.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		if(col==0){
			return you.get(row);
		}else{
			return comp.get(row);
		}
	}
	
	public void add(Symbols youSym, Symbols compSym){
		you.add(0,youSym);
		comp.add(0,compSym);
		this.fireTableDataChanged();
	}
	public  List<Symbols> getPlayerHistory(){
		return you;
	}
}