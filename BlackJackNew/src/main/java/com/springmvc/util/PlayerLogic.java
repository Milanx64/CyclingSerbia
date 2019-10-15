package com.springmvc.util;

import java.util.HashMap;
import java.util.Random;

import com.springmvc.model.Game;
import com.springmvc.model.Player;

public class PlayerLogic extends Game{
	
	public static Game startGame(Game game) {
		//Generate random number and convert it to string
		game.setPulled(generateRandomChar());
		String key = game.getPulled();
		//pull the card form cards HashMap and add t to player score
		Integer value = pullCardValue(game.getPulled(), game);
		game.getCards().getCards().remove(key);
		Player newPlayer = playerScore(game.getPlayer(), game.getPulled(), value);
		game.setPlayer(newPlayer);
		return game;
		
	}
	
	public static String generateRandomChar() {
		String [] chars = { "A", "K" ,"Q", "J", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		Random rnd = new Random();
		String c = String.valueOf((rnd.nextInt(chars.length)));
		System.out.println("Pulled card: " +c);
		return c;
	}
	
	public static Player playerScore(Player player, String key, int value) {
		int playerScore = player.getCurrentScore();
		int gameScore = player.getPlayerGameScore();
		
		if(player.getCurrentScore() == 21) {
			gameScore =+ 10;
			//pozovi metodu za izvlacenje delioca
		}
		if(player.getCurrentScore() > 21) {
			gameScore =- 3;
		}
		if(player.getCurrentScore()>21 && key.contains("A")) {
			value = 1;
			playerScore += value;
		}
		else if(player.getCurrentScore() <21 && key.contains("A")) {
			playerScore += value;
		}
		else if(player.getCurrentScore() <21) {
			playerScore =+ value;
		}
		Player p = player;
		p.setCurrentScore(playerScore);
		p.setPlayerGameScore(gameScore);
		return p;
		
	}
	
	public static int pullCardValue(String key, Game game) {
		HashMap<String, Integer> helpCards =  game.getCards().getCards();
		for(String i : helpCards.keySet()) {
			if(i.contains(key)) {
				System.out.println(" Pulled cards value is: " + helpCards.get(i));
				return helpCards.get(i);
			}
		}
		System.out.println("Error pulling card value");
		return 0;
		
	}
}
