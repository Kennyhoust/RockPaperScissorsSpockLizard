package com.wrap.backend.constant;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Computer {
	public static Symbols getSymbols(List<Symbols> list){
		
		
		List<Symbols> symbolsList =Arrays.asList(Symbols.values());
		Random ran = new Random();
		return symbolsList.get(ran.nextInt(5));
	}
}
