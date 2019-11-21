package models.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import models.Item.KeyItem;
import models.Item.TradableItem;

public class Monster extends Character
{
	private ArrayList<String> desc;
	private String monsterLocation;
	private int health;
	private int attack;
	private String itemDrop;

	//A list of key Items associated with Monster
	private ArrayList<KeyItem> itemList = new ArrayList<>();
	
	public Monster()
	{

	}
	
	public static Monster readMonster(BufferedReader reader)
	{
		Monster monster = new Monster();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			monster.setId(line);
			monster.setName(reader.readLine());
			
			//reads description
			monster.desc = new ArrayList<String>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				monster.desc.add(line);
			}
			
			/*-------------------------------------------------------*/
			
			//reads location
			monster.monsterLocation = reader.readLine();
			
			//reads health
			line = reader.readLine();
			line = line.trim();
			int colonHP = line.indexOf(":");
			int hp = Integer.parseInt(line.substring(colonHP+1).trim());
			monster.health = hp;
			
			//reads attack
			line = reader.readLine();
			line = line.trim();
			int colonAtt = line.indexOf(":");
			monster.attack = Integer.parseInt(line.substring(colonAtt+1).trim());
			
			
			//reads item drops
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				line = line.trim();
				int colonItem = line.indexOf(":");
				monster.itemDrop = line.substring(colonItem+1).trim();
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return monster;
	}

	/*-----For Key Item-----*/
	//Adds an key item to the list
	public void addItem(KeyItem keyItem)
	{
		getItemList().add(keyItem);
	}
	//Removes an key item from the list
	public void removeItem(KeyItem keyItem)
	{
		getItemList().remove(keyItem);
	}
	//Returns an array of all key items
	public KeyItem[] getItems()
	{
		KeyItem[] itemArray = new KeyItem[getItemList().size()];
		int i = 0;
		for(KeyItem tempItem : getItemList())
			itemArray[i++] = tempItem;
		return itemArray;
	}
	
	//getters
	public ArrayList<String> getDesc()
	{
		return desc;
	}

	public String getMonsterLocation()
	{
		return monsterLocation;
	}

	public void setMonsterLocation(String monsterLocation)
	{
		this.monsterLocation = monsterLocation;
	}
	
	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public String getItemDrop()
	{
		return itemDrop;
	}

	public ArrayList<KeyItem> getItemList()
	{
		return itemList;
	}
}
