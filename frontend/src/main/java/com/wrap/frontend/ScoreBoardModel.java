package com.wrap.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.wrap.backend.Symbols;
/**
 * 
 * 
 * @author Kenny
 *	Score Board Data store in here
 */
public class ScoreBoardModel extends AbstractTableModel {
	private String[] columnNames = { "You", "Comp", "Win" };
	private List<Symbols> you = new ArrayList<Symbols>();
	private List<Symbols> comp = new ArrayList<Symbols>();
	private List<Integer> resultList = new ArrayList<Integer>();
	public static ScoreBoardModel scoreBoardModel;

	Class[] columns = new Class[] { String.class, String.class, String.class };

	@Override
	public Class getColumnClass(int c) {
		return columns[c];
	}

	public static ScoreBoardModel getInstance() {
		if (scoreBoardModel == null) {
			scoreBoardModel = new ScoreBoardModel();
		}
		return scoreBoardModel;
	}

	private ScoreBoardModel() {

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
		if (col == 0) {
			return you.get(row);
		} else if (col == 1) {
			return comp.get(row);
		} else {
			if (resultList.get(row) == 0)
				return "StandOff";
			else if (resultList.get(row) == 1)
				return "Player";
			else
				return "Computer";
		}
	}

	public void add(Symbols youSym, Symbols compSym, int result) {
		you.add(0, youSym);
		comp.add(0, compSym);
		resultList.add(0, result);
		this.fireTableDataChanged();
	}

	public List<Symbols> getPlayerHistory() {
		return you;
	}
}