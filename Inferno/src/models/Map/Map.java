package models.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import models.Character.Monster;
import models.Character.NPC;
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
	private TreeMap<String,Item> items = new TreeMap<String, Item>();
	private TreeMap<String,Puzzle> puzzles;
	private TreeMap<String,Monster> monsters;
	private TreeMap<String, NPC> NPCs;
	
	public Map(String filename)
	{
		initRoom(filename);
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
		
		//Add Puzzles into the Room
		initPuzzle(rooms);
		
		//Add Monsters into the Room
		initMonster(rooms);
		
		//Add NPC into the Room
		initNPC(rooms);
		
		//Add Items into the Room
		initWeaponItem(rooms);
		initGuideItem(rooms);
		initHealingItem(rooms);
		initInventoryItem(rooms);
	}
	
	//init Puzzle
	public void initPuzzle(TreeMap<String, Room> rooms)
	{
		puzzles = new TreeMap<String, Puzzle>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("Puzzle.txt"));
			while(true)
			{
				Puzzle puzzle = Puzzle.readPuzzle(reader);
				if(puzzle == null)
					break;
				puzzles.put(puzzle.getPuzzleID(), puzzle);
				rooms.get(puzzle.getLocation()).addPuzzle(puzzle);
			}
			reader.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
		
		//Add Combat & Weapon items to associated Puzzle
		initCombatItem(puzzles);
		//initWeaponItem(puzzles);
		
	}
	
	//init Monster
	public void initMonster(TreeMap<String, Room> rooms)
	{
		monsters = new TreeMap<String, Monster>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("Monster.txt"));
			while(true)
			{
				Monster monster = Monster.readMonster(reader);
				if(monster == null)
					break;
				monsters.put(monster.getId(), monster);
				rooms.get(monster.getMonsterLocation()).addMonster(monster);
			}
			reader.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
		
		//init Tradable item associated to Monster
		initKeyItem(monsters);
	}
	
	//init NPC
	public void initNPC(TreeMap<String, Room> rooms)
	{
		NPCs = new TreeMap<String, NPC>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("NPC.txt"));
			while(true)
			{
				NPC npc = NPC.readNPC(reader);
				if(npc == null)
					break;
				NPCs.put(npc.getId(), npc);
				rooms.get(npc.getNpcLocation()).addNPC(npc);
			}
			reader.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
		
		//init Tradable item associated to NPC
		initTradableItem(NPCs);
	}
	
	//init Combat Item
	public void initCombatItem(TreeMap<String, Puzzle> puzzles)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("CombatItem.txt"));
			while(true)
			{
				CombatItem combatItem = CombatItem.readCombatItem(reader);
				if(combatItem == null)
					break;
				items.put(combatItem.getItemID(), combatItem);
				puzzles.get(combatItem.getAssociatedPuzzle()).addItem(combatItem);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Weapon Item
	public void initWeaponItem(TreeMap<String, Room> rooms)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("WeaponItem.txt"));
			while(true)
			{
				WeaponItem weaponItem = WeaponItem.readWeaponItem(reader);
				if(weaponItem == null)
					break;
				items.put(weaponItem.getItemID(), weaponItem);
				for(String temp : weaponItem.getItemLocation())
					rooms.get(temp).addItem(weaponItem);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	
	//init Guide Item
	public void initGuideItem(TreeMap<String, Room> rooms)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("GuideItem.txt"));
			while(true)
			{
				GuideItem guideItem = GuideItem.readGuideItem(reader);
				if(guideItem == null)
					break;
				items.put(guideItem.getItemID(), guideItem);
				for(String temp : guideItem.getItemLocation())
					rooms.get(temp).addItem(guideItem);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}

	//init Healing Item
	public void initHealingItem(TreeMap<String, Room> rooms)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("HealingItem.txt"));
			while(true)
			{
				HealingItem healingItem = HealingItem.readHealingItem(reader);
				if(healingItem == null)
					break;
				items.put(healingItem.getItemID(), healingItem);
				for(String temp : healingItem.getItemLocation())
					rooms.get(temp).addItem(healingItem);		
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Inventory Item
	public void initInventoryItem(TreeMap<String, Room> rooms)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("InventoryItem.txt"));
			while(true)
			{
				InventoryItem inventoryItem = InventoryItem.readInventoryItem(reader);
				if(inventoryItem == null)
					break;
				items.put(inventoryItem.getItemID(), inventoryItem);
				for(String temp : inventoryItem.getItemLocation())
					rooms.get(temp).addItem(inventoryItem);
			}
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Key Item
	public void initKeyItem(TreeMap<String, Monster> monsters)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("KeyItem.txt"));
			while(true)
			{
				KeyItem keyItem = KeyItem.readKeyItem(reader);
				if(keyItem == null)
					break;
				items.put(keyItem.getItemID(), keyItem);
				monsters.get(keyItem.getAssociatedMonster()).addItem(keyItem);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	//init Tradable Item
	public void initTradableItem(TreeMap<String, NPC> NPCs)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("TradableItem.txt"));
			while(true)
			{
				TradableItem tradableItem = TradableItem.readTradableItem(reader);				
				if(tradableItem == null)
					break;
				items.put(tradableItem.getItemID(), tradableItem);
				NPCs.get(tradableItem.getNPC()).addItem(tradableItem);
			}
			reader.close();
		}catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	
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
