package com.wrap.backend;

public class Deteminer {

	public static Action DETERMINER[][] = new Action[5][5];
	static {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DETERMINER[i][j] = Action.standoff;
			}
			DETERMINER[Symbols.ROCK.getValue()][Symbols.SCISSORS.getValue()] = Action.crushes;
			DETERMINER[Symbols.ROCK.getValue()][Symbols.LIZARD.getValue()] = Action.crushes;
			DETERMINER[Symbols.PAPER.getValue()][Symbols.ROCK.getValue()] = Action.covers;
			DETERMINER[Symbols.PAPER.getValue()][Symbols.SPOCK.getValue()] = Action.disaproves;
			DETERMINER[Symbols.SCISSORS.getValue()][Symbols.PAPER.getValue()] = Action.cuts;
			DETERMINER[Symbols.SCISSORS.getValue()][Symbols.LIZARD.getValue()] = Action.decapitates;
			DETERMINER[Symbols.SPOCK.getValue()][Symbols.ROCK.getValue()] = Action.vaporizes;
			DETERMINER[Symbols.SPOCK.getValue()][Symbols.SCISSORS.getValue()] = Action.smashes;
			DETERMINER[Symbols.LIZARD.getValue()][Symbols.PAPER.getValue()] = Action.eats;
			DETERMINER[Symbols.LIZARD.getValue()][Symbols.SPOCK.getValue()] = Action.poisons;
		}
	}



}