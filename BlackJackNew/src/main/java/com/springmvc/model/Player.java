package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "player")
@Component
@Scope("session")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "score", nullable= false)
	private int score;
	
	private int currentScore = 0;
	
	private int playerGameScore;
	
	private boolean pull = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore += currentScore;
	}

	public boolean isPull() {
		return pull;
	}

	public void setPull(boolean pull) {
		this.pull = pull;
	}

	public int getPlayerGameScore() {
		return playerGameScore;
	}

	public void setPlayerGameScore(int playerGameScore) {
		this.playerGameScore = playerGameScore;
	}
	
	
}
