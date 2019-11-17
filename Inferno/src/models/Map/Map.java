package models.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import models.Character.Monster;
import models.Item.CombatItem;
import models.Item.GuideItem;
import models.Item.HealingItem;
import models.Item.InventoryItem;
import models.Item.Item;
import models.Item.KeyItem;
import models.Item.TradableItem;
import models.Item.WeaponItem;
import models.Puzzle.Puzzle;
import models.Room.Room;


public class Map
{

	private TreeMap<String,Room> rooms;
	private TreeMap<String,Item> items = new TreeMap<>();
	private TreeMap<String,Puzzle> puzzles;
	private TreeMap<String,Monster> monsters;
	
	public Map(String filename)
	{
		initRoom(filename);
		//initPuzzle();
		//initMonster();
		
		initCombatItem();
		initGuideItem();
		//initHealingItem();
		//initInventoryItem();
		initKeyItem();
		initTradableItem();
		//initWeaponItem();
	}
	
	//init Room
	public void initRoom(String filename)
	{
		rooms = new TreeMap<String, Room>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true)
			{
				Room room = Room.readRoom(reader);
				if(room == null)
					break;
				rooms.put(room.getRoomID(), room); //puts a list of Rooms into Map
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	
	//init Puzzle
//	public void initPuzzle()
//	{
//		puzzles = new TreeMap<String, Puzzle>();
//		try
//		{
//			String filename = "Puzzle.txt";
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			while(true)
//			{
//				Puzzle puzzle = Puzzle.readPuzzle(reader);
//				if(puzzle == null)
//					break;
//				puzzles.put(puzzle.getPuzzleID(), puzzle);
//				rooms.get(puzzle.getPuzzleID()).addPuzzle(puzzle);
//			}
//			reader.close();
//		}catch(IOException e)
//		{
//			e.getMessage();
//		}
//	}
	
	//init Monster
//	public void initMonster()
//	{
//		monsters = new TreeMap<String, Monster>();
//		try
//		{
//			String filename = "Monster.txt";
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			while(true)
//			{
//				Monster monster = Monster.readMonster(reader);
//				if(monster == null)
//					break;
//				monsters.put(monster.getId(), monster);
//				rooms.get(monster.getId()).addMonster(monster);
//			}
//			reader.close();
//		}catch(IOException e)
//		{
//			e.getMessage();
//		}
//	}
	
	//init Combat Item
	public void initCombatItem()
	{
		try
		{
			String filename = "CombatItem.txt";
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true)
			{
				Item combatItem = CombatItem.readCombatItem(reader);
				if(combatItem == null)
					break;
				items.put(combatItem.getItemID(), combatItem);
				for(String temp : combatItem.getItemLocation())
					rooms.get(temp).addItem(combatItem);
			}
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Guide Item
	public void initGuideItem()
	{
		try
		{
			String filename = "GuideItem.txt";
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true)
			{
				Item guideItem = GuideItem.readGuideItem(reader);
				if(guideItem == null)
					break;
				items.put(guideItem.getItemID(), guideItem);
				for(String temp : guideItem.getItemLocation())
					rooms.get(temp).addItem(guideItem);
			}
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Healing Item
//	public void initHealingItem()
//	{
//		try
//		{
//			String filename = "HealingItem.txt";
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			while(true)
//			{
//				Item healingItem = HealingItem.readHealingItem(reader);
//				if(healingItem == null)
//					break;
//				items.put(healingItem.getItemID(), healingItem);
//				for(String temp : healingItem.getItemLocation())
//					rooms.get(temp).addItem(healingItem);
//			}
//		}catch(IOException ex)
//		{
//			ex.getMessage();
//		}
//	}
	//init Inventory Item
//	public void initInventoryItem()
//	{
//		try
//		{
//			String filename = "InventoryItem.txt";
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			while(true)
//			{
//				Item inventoryItem = InventoryItem.readInventoryItem(reader);
//				if(inventoryItem == null)
//					break;
//				items.put(inventoryItem.getItemID(), inventoryItem);
//				for(String temp : inventoryItem.getItemLocation())
//					rooms.get(temp).addItem(inventoryItem);
//			}
//		}catch(IOException ex)
//		{
//			ex.getMessage();
//		}
//	}
	//init Key Item
	public void initKeyItem()
	{
		try
		{
			String filename = "KeyItem.txt";
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true)
			{
				Item keyItem = KeyItem.readKeyItem(reader);
				if(keyItem == null)
					break;
				items.put(keyItem.getItemID(), keyItem);
				for(String temp : keyItem.getItemLocation())
					rooms.get(temp).addItem(keyItem);
			}
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Tradable Item
	public void initTradableItem()
	{
		try
		{
			String filename = "TradableItem.txt";
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true)
			{
				Item tradableItem =  TradableItem.readTradableItem(reader);
				if(tradableItem == null)
					break;
				items.put(tradableItem.getItemID(), tradableItem);
				for(String temp : tradableItem.getItemLocation())
					rooms.get(temp).addItem(tradableItem);
			}
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Tradable Item
//	public void initWeaponItem()
//	{
//		try
//		{
//			String filename = "WeaponItem.txt";
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			while(true)
//			{
//				Item weaponItem =  WeaponItem.readWeaponItem(reader);
//				if(weaponItem == null)
//					break;
//				items.put(weaponItem.getItemID(), weaponItem);
//				for(String temp : weaponItem.getItemLocation())
//					rooms.get(temp).addItem(weaponItem);
//			}
//		}catch(IOException ex)
//		{
//			ex.getMessage();
//		}
//	}
	
	
	public Room getRooms(String roomID)
	{
		return rooms.get(roomID);
	}
	
	public static Map readTextFile()
	{
		while(true)
		{
			String filename = "Room.txt";
			return new Map(filename);
		}
	}
}
