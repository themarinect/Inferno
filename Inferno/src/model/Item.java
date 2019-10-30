package model;
import java.io.BufferedReader;
import java.io.IOException;

public class Item
{
	private String itemName;
	private String itemDesc;
	private int itemInitialRoom;
	
	public static Item readItem(BufferedReader reader)
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
	}
	
	
	//getters
	public String getItemName()
	{
		return itemName;
	}
	public String getItemDesc()
	{
		return itemDesc;
	}
	public int getItemInitialRoom()
	{
		return itemInitialRoom;
	}
}
