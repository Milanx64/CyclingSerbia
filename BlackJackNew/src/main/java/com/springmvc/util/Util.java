package com.springmvc.util;

import java.util.HashMap;
import java.util.Random;

import com.springmvc.model.Cards;
import com.springmvc.model.Game;
import com.springmvc.model.House;
import com.springmvc.model.Player;

public class Util {
	
	/*public static String convertRandomNumberToString(int num) {
		String pom = null;
	     switch(num)
	     {
	        case 1:
	        	pom = "A";
	        case 2:
	        	pom = "2";
	        case 3:
	        	pom = "3";
	        case 4:
	        	pom = "4";
	        case 5:
	        	pom = "5";
	        case 6:
	        	pom = "6";
	        case 7:
	        	pom = "7";
	        case 8:
	        	pom = "8";
	        case 9:
	        	pom = "9";
	        case 10:
	        	pom = "10";
	        case 11:
	        	pom = "J";
	        case 12:
	        	pom = "Q";
	        case 13:
	        	pom = "K";
	        case 14:
	        	pom = "A";
	        case 15:
	        	pom = "2";
	        case 16:
	        	pom = "3";
	        case 17:
	        	pom = "4";
	        case 18:
	        	pom = "5";
	        case 19:
	        	pom = "6";
	        case 20:
	        	pom = "7";
	        case 8:
	        	pom = "8";
	        case 9:
	        	pom = "9";
	        case 10:
	        	pom = "10";
	        case 11:
	        	pom = "J";
	        case 12:
	        	pom = "Q";
	        case 13:
	        	pom = "K";
	        default:
	        	System.out.println("Default: Value is: "+num);
	      }
	     
	     return pom;
	}
	
	public static Game pullCards(Player p, House h, Cards c) {
		Game game = new Game();
		Random rn = new Random();
		HashMap<String, Integer> helpCards = c.getCards();
		Integer num = rn.nextInt(13-1+1) + 1;
		String pom = Util.convertRandomNumberToString(num);
		p.setCurrentScore(calculatePlayerScore(pom, p.getPlayerGameScore(), c));
		c.getCards().remove(pom);
		c.setCards(helpCards);
		
		game.setCards(c);
		game.setHouse(h);
		game.setPlayer(p);
		return game;
		
		
		
	}
	
	public static boolean isPlayerScoreAbove21(Player player) {
		if(player.getCurrentScore() < 21) {
			return true;
		}
		return false;
	}
	
	public static int calculatePlayerScore(String pom, int playerScore, Cards cards) {
		//HashMap<String, Integer> helpCards = cards.getCards();
		if(pom.equals("A") && playerScore >21) {
			playerScore ++;
			return playerScore;
		}
		else if (pom.equals("A") && playerScore <21){
			playerScore = playerScore + 11;
		}
		else {
			playerScore = cards.getCards().get(pom);
			return playerScore;
		}
		return 0;
	}
	
	public static Game housePlay(Player p, House h, Cards c) {
		
		return null;
		
	}
	
	public static boolean comperePlayerAndHouseScore(Player player, House house) {
		return true;
	}*/
}
