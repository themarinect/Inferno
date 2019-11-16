package models.Character;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.Item.Item;



public class Player extends Character
{
	
	private SimpleStringProperty currentRoom;
	private SimpleIntegerProperty HP;
	private SimpleStringProperty weapon;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Player()
	{
		currentRoom = new SimpleStringProperty("R14");
		HP = new SimpleIntegerProperty(100);
		weapon = new SimpleStringProperty("Sword");
	}
	
	public Player(String _id, String _name, SimpleStringProperty _currentRoom, SimpleIntegerProperty _HP)
	{
		super(_id, _name);
		this.setCurrentRoom(_currentRoom);
		this.HP = _HP;
	}

	public StringProperty currentRoomProperty()
	{
		return currentRoom;
	}
	
	public IntegerProperty HPProperty()
	{
		return HP;
	}
	
	public StringProperty weaponProperty()
	{
		return weapon;
	}
	
	public void displayInventory()
	{
		System.out.println("Inventory: ");
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.size() == 0)
				System.out.println("You have nothing in the inventory.\n");
			else
				System.out.println(inventory.get(i).getItemName() + ": " + inventory.get(i).getItemDesc() + "\n");
		}
	}
	
	//getters & setters

	public SimpleStringProperty getCurrentRoom()
	{
		return currentRoom;
	}

	public void setCurrentRoom(SimpleStringProperty currentRoom)
	{
		this.currentRoom = currentRoom;
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	public SimpleIntegerProperty getHP()
	{
		return HP;
	}

	public void setHP(SimpleIntegerProperty hP)
	{
		HP = hP;
	}

	public SimpleStringProperty getWeapon()
	{
		return weapon;
	}

	public void setWeapon(SimpleStringProperty weapon)
	{
		this.weapon = weapon;
	}
}
