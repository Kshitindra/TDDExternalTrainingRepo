package com.wf;

public class Game {

	private int target = (int)(Math.random() * 100);
	private int attempts;
	private String message;
	private boolean gameOver;
	
	public int getTarget() {
		return target;
	}

	public int getAttempts() {
		return attempts;
	}

	public String getMessage() {
		return message;
	}

	public void play(int guess) {
		checkGameIsOver();
		attempts++;
		checkInput(guess);
		if(guess < target)
			message = "Aim Higher";
		else if(guess > target)
			message = "Aim Lower";
		else if(guess == target){
			message = "You've got it!!!";
			gameOver = true;
		}
			
	}

	private void checkInput(int guess) {
		if(guess <= 0)
			throw new GameException("Invalid Input");
	}

	private void checkGameIsOver() {
		if(gameOver)
			throw new GameOverException();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void reset() {
		attempts = 0;
		message = null;
		gameOver = false;
		target = (int)(Math.random()*100);
	}

}
