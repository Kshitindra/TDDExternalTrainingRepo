package com.wf.service;

import com.wf.GameEngine;
import com.wf.GameRepository;

public class GameService {

	private GameEngine gameEngine;
	private GameRepository gameRepository;
	
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
	public GameDTO play(int guess) {
		gameEngine.play(guess);
		GameDTO gameDTO = new GameDTO();
		gameDTO.setAttempts(gameEngine.getAttempts());
		gameDTO.setMessage(gameEngine.getMessage());
		return gameDTO;
	}
	public boolean store(String name) {
		boolean stored = gameRepository.storeResults(name,
				gameEngine.getTarget(),
				gameEngine.getAttempts());
		return stored;
	}

}










