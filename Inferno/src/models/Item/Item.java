package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import models.Character.Player;
import models.Room.Room;

public class Item
{
	private String itemID;
	private String itemName;
	private String itemType;
	private String[] itemDesc;
	private ArrayList<String> itemLocation;
	
	public Item()
	{
		
	}
	
	public Item(String _itemID, String _itemName, String _itemType, String[] _itemDesc, ArrayList<String> _itemLocation)
	{
		this.setItemID(_itemID);
		this.setItemName(_itemName);
		this.setItemType(_itemType);
		this.setItemDesc(_itemDesc);
		this.setItemLocation(_itemLocation);
	}
	
	public void pickup(Room room, Player player, TextArea txtGame)
	{
		for(Item item : room.getItems())
		{
			if(room.containsItem(item))
			{
				room.removeItem(item);
				player.getInventory().add(item);
				txtGame.appendText("\nThe " + item.getItemName().toUpperCase() + " has been added to inventory.\n");
			}
			else
				txtGame.appendText("No item here.");
		}
	}
	
	//getters and setters
	public String getItemID()
	{
		return itemID;
	}
	public String getItemName()
	{
		return itemName;
	}
	public String getItemType()
	{
		return itemType;
	}
	public String[] getItemDesc()
	{
		return itemDesc;
	}
	public ArrayList<String> getItemLocation()
	{
		return itemLocation;
	}

	public void setItemID(String itemID)
	{
		this.itemID = itemID;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}

	public void setItemDesc(String[] itemDesc)
	{
		this.itemDesc = itemDesc;
	}

	public void setItemLocation(ArrayList<String> itemLocation)
	{
		this.itemLocation = itemLocation;
	}
}
