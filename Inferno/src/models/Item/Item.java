package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
