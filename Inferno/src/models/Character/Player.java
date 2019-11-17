package models.Character;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Item.Item;
import models.Map.Map;
import models.Room.Room;



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

	public SimpleStringProperty weaponProperty()
	{
		return weapon;
	}
	
	public String getWeapon()
	{
		return weapon.get();
	}

	public void setWeapon(SimpleStringProperty weapon)
	{
		this.weapon = weapon;
	}
	
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
}
