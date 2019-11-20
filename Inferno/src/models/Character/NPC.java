package models.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import models.Item.TradableItem;

public class NPC extends Character
{
	
	private ArrayList<String> desc;
	private String npcLocation;
	private String tradeItem;
	
	//A list of Tradable Items associated with NPC
	private ArrayList<TradableItem> itemList = new ArrayList<>();
	
	public NPC()
	{
	}

	public NPC(String _id, String _name, ArrayList<String> _desc, String _npcLocation, String _tradeItem)
	{
		super(_id, _name);
		this.desc = _desc;
		this.npcLocation = _npcLocation;
		this.tradeItem = _tradeItem;
	}
	
	public static NPC readNPC(BufferedReader reader)
	{
		NPC npc = new NPC();
		
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			npc.setId(line);
			npc.setName(reader.readLine());
			
			//reads description
			npc.desc = new ArrayList<String>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				npc.desc.add(line);
			}
			
			/*-------------------------------------------------------*/
			
			//reads location
			npc.npcLocation = reader.readLine();
			
			//reads trade item
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				npc.tradeItem = line.substring(colon+1).trim();
			}
			
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return npc;
		
	}
	
	/*-----For Tradable Item-----*/
	//Adds an tradable item to the list
	public void addItem(TradableItem tradableItem)
	{
		itemList.add(tradableItem);
	}
	//Removes an tradable item from the list
	public void removeItem(TradableItem tradableItem)
	{
		itemList.remove(tradableItem);
	}
	//Returns an array of all tradable items
	public TradableItem[] getItems()
	{
		TradableItem[] itemArray = new TradableItem[itemList.size()];
		int i = 0;
		for(TradableItem tempItem : itemList)
			itemArray[i++] = tempItem;
		return itemArray;
	}
	
	//getters
	public ArrayList<String> getDesc()
	{
		return desc;
	}

	public String getNpcLocation()
	{
		return npcLocation;
	}

	public String getTradeItem()
	{
		return tradeItem;
	}

}
