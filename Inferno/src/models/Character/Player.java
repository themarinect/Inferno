package models.Character;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Item.CombatItem;
import models.Item.GuideItem;
import models.Item.Item;
import models.Item.TradableItem;
import models.Item.WeaponItem;
import models.Map.Map;
import models.Room.Room;



public class Player extends Character implements Serializable
{
	private SimpleStringProperty currentRoom;
	private SimpleIntegerProperty HP;
	private Item currentWeapon;
	private SimpleStringProperty weaponName;
	private ArrayList<Item> inventory;
	
	public Player()
	{
		currentRoom = new SimpleStringProperty("R14");
		HP = new SimpleIntegerProperty(20);
		currentWeapon = new Item();
		weaponName = new SimpleStringProperty(null);
		inventory = new ArrayList<Item>();
	}
	
	public Player(String _id, String _name, SimpleStringProperty _currentRoom, SimpleIntegerProperty _HP)
	{
		super(_id, _name);
		this.currentRoom = _currentRoom;
		this.HP = _HP;
	}
	
//	public void displayInventory()
//	{
//		System.out.println("Inventory: ");
//		for(int i = 0; i < inventory.size(); i++)
//		{
//			if(inventory.size() == 0)
//				System.out.println("You have nothing in the inventory.\n");
//			else
//				System.out.println(inventory.get(i).getItemName() + ": " + inventory.get(i).getItemDesc() + "\n");
//		}
//	}
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
}
