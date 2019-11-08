package models.Character;

import java.util.ArrayList;

import models.Item.Item;



public class Player extends Character
{
	
	private String currentRoom;
	private int healthPoints;
	//private String weapon = "";
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Player()
	{
		currentRoom = "R14";
		healthPoints = 100;
	}
	
	public Player(String _id, String _name, String _currentRoom, int _healthPoints)
	{
		super(_id, _name);
		this.currentRoom = _currentRoom;
		this.healthPoints = _healthPoints;
	}

	public String getCurrentRoom()
	{
		return currentRoom;
	}

	public int getHealthPoints()
	{
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints)
	{
		this.healthPoints = healthPoints;
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

}
