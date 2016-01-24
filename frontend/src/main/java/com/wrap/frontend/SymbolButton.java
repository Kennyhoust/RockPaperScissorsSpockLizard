package com.wrap.frontend;

import javax.swing.JButton;

import com.wrap.backend.Symbols;

public class SymbolButton extends JButton{
	private Symbols sym;
	public SymbolButton(Symbols _sym){
		super(_sym.name());
		this.setSym(_sym);
	}
	public Symbols getSym() {
		return sym;
	}
	public void setSym(Symbols sym) {
		this.sym = sym;
	}
}
