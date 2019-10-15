package com.springmvc.model;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Game {
	
	private Cards cards;
	private House house;
	private Player player;
	private int numberOfPlayers;
	private final int cardsNumber = 52;
	private String pulled;
	private HashMap<String, Integer> pulledCards;
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public String getPulled() {
		return pulled;
	}
	public void setPulled(String string) {
		this.pulled = string;
	}
	public HashMap<String, Integer> getPulledCards() {
		return pulledCards;
	}
	public void setPulledCards(String s, Integer i) {
		this.pulledCards.put(s, i);
	}
	public int getCardsNumber() {
		return cardsNumber;
	}

	
	public Cards getCards() {
		return cards;
	}
	public void setCards(Cards cards) {
		this.cards = cards;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	/*
	public Game housePlay() {
		Random rn = new Random();
		HashMap<String, Integer> helpCards = this.cards.getCard();
		Integer num = rn.nextInt(13-1+1) + 1;
		String pom = Util.convertRandomNumberToString(num);
		
		if(this.house.getCurrentHouseScore() <16) {
			this.house.setCurrentHouseScore(caclulateHouseScore(pom));
			helpCards.remove(pom);
			this.cards.setCard(helpCards);
		}
		this.player.setPlayerGameScore(this.compereScores());
		
		Game game = new Game();
		game.setCards(this.cards);
		game.setHouse(this.house);
		game.setPlayer(this.player);;
		
		return game;
		
	}
	public int caclulateHouseScore(String pom) {
		if(this.cards.getCard().get(pom).equals("A") && this.house.getCurrentHouseScore() >21) {
			 this.house.setCurrentHouseScore(1+this.house.getCurrentHouseScore());
			 return this.house.getCurrentHouseScore();
		}
		else if (this.cards.getCard().get(pom).equals("A") && this.house.getCurrentHouseScore() <21) {
			this.house.setCurrentHouseScore(11+this.house.getCurrentHouseScore());
			return this.house.getCurrentHouseScore();
		}
		else {
			 this.house.setCurrentHouseScore(this.cards.getCard().get(pom));
			 return this.house.getCurrentHouseScore();
		}
	}
	
	public  int compereScores() {
		Game game = new Game();
		if(this.house.getCurrentHouseScore() < 21) {
			if(this.player.getCurrentScore() < this.house.getCurrentHouseScore()) {
				this.player.setPlayerGameScore(this.player.getPlayerGameScore()-1);
				game.setPlayer(this.player);
			}
			else if(this.player.getCurrentScore() == this.house.getCurrentHouseScore()) {
				this.player.setPlayerGameScore(this.player.getPlayerGameScore()+0);
				game.setPlayer(this.player);
			}
			else if(this.player.getCurrentScore() > this.house.getCurrentHouseScore()) {
				this.player.setPlayerGameScore(this.player.getPlayerGameScore()+1);
				game.setPlayer(this.player);
			}
		}
		return this.player.getPlayerGameScore();
		
	}*/
	
}
