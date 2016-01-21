package com.wrap.frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * TableDemo is just like SimpleTableDemo, except that it uses a custom
 * TableModel.
 */
public class ScoreBoard extends JPanel {
	private boolean DEBUG = false;

	public ScoreBoard() {
		super(new GridLayout(1, 0));

		JTable table = new JTable(new MyTableModel());
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				final Component c = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
				return c;
			}
		});
		table.setPreferredScrollableViewportSize(new Dimension(200, 70));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

	class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "You", "Comp", "Win" };
		private Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "John", "Doe", "Rowing" }, 
				{ "Sue", "Black", "Knitting" },
				{ "Jane", "White", "Speed reading" },
				{ "Joe", "Brown", "Pool" } 
				};

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/ editor for
		 * each cell. If we didn't implement this method, then the last column
		 * would contain text ("true"/"false"), rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's editable.
		 */
		public boolean isCellEditable(int row, int col) {
			// Note that the data/cell address is constant,
			// no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's data can
		 * change.
		 */
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col
						+ " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			data[row][col] = value;
			fireTableCellUpdated(row, col);

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}
}