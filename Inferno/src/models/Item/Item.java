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
	
//	public static Item readItem(BufferedReader reader)
//	{
//		Item item = new Item();
//		try
//		{
//			String line = reader.readLine();
//			if(line == null)
//				return null;
//			item.setItemID(line);
//			item.setItemName(reader.readLine());
//			item.setItemType(reader.readLine());
//			
//			//reads description
//			line = reader.readLine();
//			ArrayList<String> itemDescList = new ArrayList<String>(); 
//			String[] temp = null;
//			itemDescList.add(line);
//			temp = new String[itemDescList.size()];
//			int i = 0;
//			for(String descLine : itemDescList)
//				temp[i++] = descLine;
//			item.setItemDesc(temp);
//			
//			//reads location(s)
//			String data = reader.readLine();
//			String[] location = data.split("/",-2);
//			ArrayList<String> locationList = new ArrayList<>();
//			for(String a : location)
//				locationList.add(a);
//			item.setItemLocation(locationList);
//			
//			/*------------------------------------------------------------------*/
//			
//			if(item instanceof CombatItem)
//			{
//				//reads usage
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					String usage = line.substring(colon+1).trim();
//					((CombatItem) item).setUsage(usage);
//				}
//			}
//			
//			
//			if(item instanceof GuideItem)
//			{
//				//reads imagePath
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					String imagePath = line.substring(colon+1).trim();
//					((GuideItem) item).setImagePath(imagePath);
//				}
//			}
//			
//			if(item instanceof HealingItem)
//			{
//				//reads strength
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					int strength = Integer.parseInt(line.substring(colon+1).trim());
//					((HealingItem) item).setStrength(strength);
//				}
//			}
//			
//			if(item instanceof InventoryItem)
//			{
//				//reads capacity
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					int capacity = Integer.parseInt(line.substring(colon+1).trim());
//					((InventoryItem) item).setCapacity(capacity);
//				}
//			}
//			
//			if(item instanceof KeyItem)
//			{
//				//reads associated monster
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					String associatedMonster = line.substring(colon+1).trim();
//					((KeyItem) item).setAssociatedMonster(associatedMonster);
//				}
//			}
//			
//			if(item instanceof TradableItem)
//			{
//				//reads NPC's id
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					String npc = line.substring(colon+1).trim();
//					((TradableItem) item).setNPC(npc);
//				}
//			}
//			
//			if(item instanceof WeaponItem)
//			{
//				//reads attack
//				while(true)
//				{
//					
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					int attack = Integer.parseInt(line.substring(colon+1).trim());
//					((WeaponItem) item).setAttack(attack);
//				}
//			}
//		}catch (IOException ex)
//		{
//			ex.getMessage();
//		}catch (NumberFormatException ex)
//		{
//			ex.getMessage();
//		}
//		
//		return item;
//	}
	
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
