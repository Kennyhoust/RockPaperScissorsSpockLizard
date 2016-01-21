package com.wrap.backend.constant;

public class Deteminer {

	private static int DETERMINER[][] = new int[5][5];
	static {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DETERMINER[i][j] = 0;
			}
			DETERMINER[Symbols.ROCK][Symbols.SCISSORS] = Symbols.crushes;
			DETERMINER[Symbols.ROCK][Symbols.LIZARD] = Symbols.crushes;
			DETERMINER[Symbols.PAPER][Symbols.ROCK] = Symbols.covers;
			DETERMINER[Symbols.PAPER][Symbols.SPOCK] = Symbols.disaproves;
			DETERMINER[Symbols.SCISSORS][Symbols.PAPER] = Symbols.cuts;
			DETERMINER[Symbols.SCISSORS][Symbols.LIZARD] = Symbols.decapitates;
			DETERMINER[Symbols.SPOCK][Symbols.ROCK] = Symbols.vaporizes;
			DETERMINER[Symbols.SPOCK][Symbols.SCISSORS] = Symbols.smashes;
			DETERMINER[Symbols.LIZARD][Symbols.PAPER] = Symbols.eats;
			DETERMINER[Symbols.LIZARD][Symbols.SPOCK] = Symbols.poisons;
		}
	}
	public static int play(int play,int crpty){
		return DETERMINER[play][crpty];
	}


}