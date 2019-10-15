package com.springmvc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class House {
	
	private int houseScore;
	private int currentHouseScore;
	
	public int getHouseScore() {
		return houseScore;
	}
	public void setHouseScore(int houseScore) {
		this.houseScore = houseScore;
	}
	public int getCurrentHouseScore() {
		return currentHouseScore;
	}
	public void setCurrentHouseScore(int currentHouseScore) {
		this.currentHouseScore = currentHouseScore;
	}
	
	
}
