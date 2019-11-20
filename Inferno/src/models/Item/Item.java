package models.Item;

import java.util.ArrayList;
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
	
//	public static <T extends Item> T readItem(BufferedReader reader)
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
//			/*-------------------------------------------------------*/
//			
//			if(item instanceof CombatItem)
//			{
//				//reads usage
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((CombatItem) item).setUsage(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof GuideItem)
//			{
//				//reads image path
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((GuideItem) item).setImagePath(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof HealingItem)
//			{
//				//reads strength
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((HealingItem)item).setStrength(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof InventoryItem)
//			{
//				//reads capacity
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((InventoryItem)item).setCapacity(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof KeyItem)
//			{
//				//reads associated monster
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((KeyItem)item).setAssociatedMonster(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof TradableItem)
//			{
//				//reads NPC's id
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((TradableItem)item).setNPC(line.substring(colon+1).trim());
//				}
//			}
//			
//			if(item instanceof WeaponItem)
//			{
//				//reads usage
//				while(true)
//				{
//					line = reader.readLine();
//					if(line == null || line.equals(""))
//						break;
//					line = line.trim();
//					int colon = line.indexOf(":");
//					((WeaponItem)item).setAttack(line.substring(colon+1).trim());
//				}
//			}
//			
//		}catch (IOException ex)
//		{
//			ex.getMessage();
//		}catch (NumberFormatException ex)
//		{
//			ex.getMessage();
//		}
//		
//		return (T) item;
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
