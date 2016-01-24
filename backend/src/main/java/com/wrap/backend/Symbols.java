package com.wrap.backend;

public enum Symbols {
	ROCK(0),
	PAPER(1),
	SCISSORS (2),
	SPOCK( 3),
	LIZARD(4);
    private final int value;

    private Symbols(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }	

	
}
