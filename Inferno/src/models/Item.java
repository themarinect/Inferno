package models;

import java.util.ArrayList;

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
		this.itemID = _itemID;
		this.itemName = _itemName;
		this.itemType = _itemType;
		this.itemDesc = _itemDesc;
		this.itemLocation = _itemLocation;
	}
	/*public static Item readItem(BufferedReader reader)
	{
		Item item = new Item();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			if(line.equals("") || line.length() == 0)
				line = reader.readLine();
			item.itemName = line;
			
			line = reader.readLine();
			item.itemDesc = line;
			
			line = reader.readLine();
			item.itemInitialRoom = Integer.parseInt(line);
		}catch(IOException ex)
		{
			ex.getMessage();
		}
		
		return item;
	}*/
	
	
	//getters
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
}
