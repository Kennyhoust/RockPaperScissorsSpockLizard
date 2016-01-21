package com.wrap.backend.constant;

public class Deteminer {

	private static Action DETERMINER[][] = new Action[5][5];
	static {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DETERMINER[i][j] = Action.standoff;
			}
			DETERMINER[Symbols.ROCK][Symbols.SCISSORS] = Action.crushes;
			DETERMINER[Symbols.ROCK][Symbols.LIZARD] = Action.crushes;
			DETERMINER[Symbols.PAPER][Symbols.ROCK] = Action.covers;
			DETERMINER[Symbols.PAPER][Symbols.SPOCK] = Action.disaproves;
			DETERMINER[Symbols.SCISSORS][Symbols.PAPER] = Action.cuts;
			DETERMINER[Symbols.SCISSORS][Symbols.LIZARD] = Action.decapitates;
			DETERMINER[Symbols.SPOCK][Symbols.ROCK] = Action.vaporizes;
			DETERMINER[Symbols.SPOCK][Symbols.SCISSORS] = Action.smashes;
			DETERMINER[Symbols.LIZARD][Symbols.PAPER] = Action.eats;
			DETERMINER[Symbols.LIZARD][Symbols.SPOCK] = Action.poisons;
		}
	}
	public static Action play(int play,int crpty){
		return DETERMINER[play][crpty];
	}


}