package com.wf;

import java.util.Scanner;

public class GameUser {

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Enter a number between 1 and 100");
		Scanner sc = new Scanner(System.in);
		while(!game.isGameOver()){
			int guess = sc.nextInt();
			game.play(guess);
			System.out.println(game.getMessage());
		}
		System.out.println("Attempts: " + game.getAttempts());
	}

}
