package com.springmvc.model;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Cards {
    
	private HashMap<String, Integer> cards = new HashMap<String, Integer>();

	public HashMap<String, Integer> getCards() {
		return cards;
	}
	
	 public Cards() {
		this.cards.put("A pik", 11);
		cards.put("1 pik", 1);
		cards.put("2 pik", 2);
		cards.put("3 pik", 3);
		cards.put("4 pik", 4);
		cards.put("5 pik", 5);
		cards.put("6 pik", 6);
		cards.put("7 pik", 7);
		cards.put("8 pik", 8);
		cards.put("9 pik", 9);
		cards.put("10 pik", 10);
		cards.put("J pik", 10);
		cards.put("Q pik", 10);
		cards.put("K pik", 10);
		cards.put("A karo", 11);
		cards.put("1 karo", 1);
		cards.put("2 karo", 2);
		cards.put("3 karo", 3);
		cards.put("4 karo", 4);
		cards.put("5 karo", 5);
		cards.put("6 karo", 6);
		cards.put("7 karo", 7);
		cards.put("8 karo", 8);
		cards.put("9 karo", 9);
		cards.put("10 karo", 10);
		cards.put("J karo", 10);
		cards.put("Q karo", 10);
		cards.put("K karo", 10);
		cards.put("A tref", 11);
		cards.put("1 tref", 1);
		cards.put("2 tref", 2);
		cards.put("3 tref", 3);
		cards.put("4 tref", 4);
		cards.put("5 tref", 5);
		cards.put("6 tref", 6);
		cards.put("7 tref", 7);
		cards.put("8 tref", 8);
		cards.put("9 tref", 9);
		cards.put("10 tref", 10);
		cards.put("J tref", 10);
		cards.put("Q tref", 10);
		cards.put("K tref", 10);
		cards.put("A herc", 11);
		cards.put("1 herc", 1);
		cards.put("2 herc", 2);
		cards.put("3 herc", 3);
		cards.put("4 herc", 4);
		cards.put("5 herc", 5);
		cards.put("6 herc", 6);
		cards.put("7 herc", 7);
		cards.put("8 herc", 8);
		cards.put("9 herc", 9);
		cards.put("10 herc", 10);
		cards.put("J herc", 10);
		cards.put("Q herc", 10);
		cards.put("K herc", 10);
		
		int br = 0;
		for(String i : cards.keySet()) {
			br++;
			System.out.println(br + " " +"KEY: " + i + " Value: " + cards.get(i));	
			
		}
	}

	public void setCards(HashMap<String, Integer> card) {
		this.cards = card;
	}	
	
	
	
	
}
	
	
	
	
	
		
    


