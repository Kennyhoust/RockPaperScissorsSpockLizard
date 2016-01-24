package com.wrap.backend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Computer {
	private Map<Symbols,Integer> hisgram = new HashMap<Symbols,Integer>();
	private static Computer comp;
	private Symbols highestsymbol;
	private Computer(){
		
	}
	public static Computer getInstance(){
		if(comp==null)
			comp = new Computer();
		return comp;
	}
	public Symbols getSymbols(List<Symbols> list){
		recordHisgram(list);
		Symbols resultSym =null;
		Integer palyerMostTimeChoice = 0;
		for(Symbols sym:hisgram.keySet()){
			
			if(hisgram.get(sym)>palyerMostTimeChoice){
				resultSym = sym;
				palyerMostTimeChoice = hisgram.get(sym);
			}
		}
		if(resultSym!=null)
			highestsymbol = resultSym;
		else
			resultSym=this.getDefaultSym();
		Symbols counterparty = findCounterparty(resultSym);
		System.out.println("==========");
		for(Map.Entry<Symbols, Integer> sym:hisgram.entrySet()){
			System.out.println(sym.getKey()+":"+sym.getValue());
		}
		
		return 	counterparty;
	}
	public Symbols getDefaultSym() {
		List<Symbols> symbolsList =Arrays.asList(Symbols.values());
		Random ran = new Random();

		return symbolsList.get(ran.nextInt(5));
	}
	public void recordHisgram(List<Symbols> list) {
		if(list.size()==0)return;
		Symbols symbols = list.get(0);

		if(hisgram.containsKey(symbols)){
			if(!isHightest(symbols))
			hisgram.put(symbols,hisgram.get(symbols)+1);
		}else{
			hisgram.put(symbols, 1);
		}
	}
	private boolean isHightest(Symbols symbols) {
		// TODO Auto-generated method stub
		return symbols.equals(highestsymbol);
	}
	public Symbols findCounterparty(Symbols resultSym){
		int guess = 0;
		for(int i=0;i<5;i++){
			Action a = Deteminer.DETERMINER[i][resultSym.getValue()];
			if(!a.equals(Action.standoff)){
				guess = i;
				break;
			}
		}

		return Arrays.asList(Symbols.values()).get(guess);
	}
}
