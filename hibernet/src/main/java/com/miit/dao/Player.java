package com.miit.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player_crud")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerId;
	@Column(nullable=false,name="name")
	private String playerName;
	private String teamName;
	private int age;

	public Player() {
		super();
	}
	
	public Player(String playerName, String teamName, int age) {
		super();
		this.playerName = playerName;
		this.teamName = teamName;
		this.age = age;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", teamName=" + teamName + ", age=" + age + "]";
	}
}
