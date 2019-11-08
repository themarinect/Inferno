package models.Item;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import models.Item.Item;

public class InventoryItem extends Item
{
	private int capacity;
	
	public InventoryItem()
	{

	}

	public InventoryItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, int _capacity)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.setCapacity(_capacity);
	}
	
	public static InventoryItem readInventoryItem(BufferedReader reader)
	{
		InventoryItem inventoryItem = new InventoryItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			inventoryItem.setItemID(line);
			inventoryItem.setItemName(reader.readLine());
			inventoryItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			inventoryItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			inventoryItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads capacity
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				inventoryItem.setCapacity(Integer.parseInt(line.substring(colon+1).trim()));
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return inventoryItem;
	}

	//getters and setters
	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

}
