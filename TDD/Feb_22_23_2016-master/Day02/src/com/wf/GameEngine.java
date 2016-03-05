package com.wf;

public interface GameEngine {
	void play(int guess);
	int getAttempts();
	String getMessage();
	int getTarget();
}
