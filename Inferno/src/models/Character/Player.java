package models.Character;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Item.Item;



public class Player extends Character implements Serializable
{
	private SimpleStringProperty currentRoom;
	private SimpleIntegerProperty HP;
	private Item currentWeapon;
	private SimpleStringProperty weaponName;
	private ArrayList<Item> inventory;
	private boolean inCombat = false;
	
	public Player()
	{
		currentRoom = new SimpleStringProperty("R14");
		HP = new SimpleIntegerProperty(100);
		currentWeapon = new Item();
		weaponName = new SimpleStringProperty();
		inventory = new ArrayList<Item>();
	}
	
	public Player(String _id, String _name, SimpleStringProperty _currentRoom, SimpleIntegerProperty _HP)
	{
		super(_id, _name);
		this.currentRoom = _currentRoom;
		this.HP = _HP;
	}

	//getters & setters
	public SimpleStringProperty CurrentRoomProperty()
	{
		return currentRoom;
	}
	
	public String getCurrentRoom()
	{
		return currentRoom.get();
	}

	public void setCurrentRoom(SimpleStringProperty currentRoom)
	{
		this.currentRoom = currentRoom;
	}
	
	public Item getCurrentWeapon()
	{
		return currentWeapon;
	}

	public void setCurrentWeapon(Item currentWeapon)
	{
		this.currentWeapon = currentWeapon;
	}
	
	public SimpleIntegerProperty HPProperty()
	{
		return HP;
	}
	
	public int getHP()
	{
		return HP.get();
	}

	public void setHP(SimpleIntegerProperty hP)
	{
		HP = hP;
	}

	public SimpleStringProperty weaponNameProperty()
	{
		return weaponName;
	}
	
	public String getWeaponName()
	{
		return weaponName.get();
	}

	public void setWeaponName(SimpleStringProperty weapon)
	{
		this.weaponName = weapon;
	}
	
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public boolean isInCombat()
	{
		return inCombat;
	}

	public void setInCombat(boolean inCombat)
	{
		this.inCombat = inCombat;
	}
}
