package models.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import models.Character.Monster;
import models.Character.NPC;
import models.Puzzle.Puzzle;
import models.Room.Room;

public class test
{

	public static void main(String[] args)
	{
		try
		{
			/*BufferedReader reader = new BufferedReader(new FileReader("Puzzle.txt"));
			Puzzle puzzle = Puzzle.readPuzzle(reader);
			
				System.out.println("ID: " + puzzle.getPuzzleID());
				System.out.println("Location: " + puzzle.getLocation());
				System.out.println("Item drops: " + puzzle.getItemDrop());
				System.out.println("Name: " + puzzle.getPuzzleName());
				System.out.println("Hint: " + puzzle.getPuzzleHint());
				for(String desc : puzzle.getPuzzleDesc())
					System.out.println(desc);
				String answer = "CorrectAnswer";
				System.out.println("Answer: " + puzzle.lookupAnswer(answer));*/
			

				BufferedReader reader = new BufferedReader(new FileReader("CombatItem.txt"));
				while(true)
				{
					CombatItem combatItem = CombatItem.readCombatItem(reader);
					if(combatItem == null)
						break;
					System.out.println("ID:" + combatItem.getItemID());
					System.out.println("Name:" + combatItem.getItemName());
					System.out.println("Type:" + combatItem.getItemType());
					
					for(String temp : combatItem.getItemDesc())
						System.out.println(temp);
					
					System.out.println("Location: ");
					for(String temp : combatItem.getItemLocation())
						System.out.println(temp);
					
					
					System.out.println(combatItem.getUsage());
				}
				String usage = "050";
				if(usage.matches("\\d+"))
				{
					System.out.println("This is a number");
				}

				
			
//			BufferedReader reader = new BufferedReader(new FileReader("Room.txt"));
//			Room room = Room.readRoom(reader);
//			System.out.println("ID: " + room.getRoomID());
//			System.out.println("Name: " + room.getRoomName());
//			for(String desc : room.getRoomDesc())
//				System.out.println(desc);
			
//			BufferedReader reader = new BufferedReader(new FileReader("Monster.txt"));
//			Monster monster = Monster.readMonster(reader);
//			System.out.println("ID: " + monster.getId());
//			System.out.println("Name: " + monster.getName());
//			for(String desc : monster.getDesc())
//				System.out.println(desc);
//			System.out.println("Location: " + monster.getMonsterLocation());
//			System.out.println("Health: " + monster.getHealth());
//			System.out.println("Attack: " + monster.getAttack());
//			System.out.println("Item drops: " + monster.getItemDrop());
			
//			BufferedReader reader = new BufferedReader(new FileReader("NPC.txt"));
//			NPC npc = NPC.readNPC(reader);
//			System.out.println("ID: " + npc.getId());
//			System.out.println("Name: " + npc.getName());
//			for(String desc : npc.getDesc())
//				System.out.println(desc);
//			System.out.println("Location: " + npc.getNpcLocation());
//			System.out.println("Trade: " + npc.getTradeItem());
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
