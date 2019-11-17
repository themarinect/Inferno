package models.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import models.Character.Monster;
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
			
			/*BufferedReader reader = new BufferedReader(new FileReader("GuideItem.txt"));
			GuideItem guideItem = GuideItem.readGuideItem(reader);
			System.out.println("ID: " + guideItem.getItemID());
			System.out.println("Name: " + guideItem.getItemName());
			System.out.println("Type: " + guideItem.getItemType());
			for(String desc : guideItem.getItemDesc())
				System.out.println("Desc: " + desc);
			for(String location : guideItem.getItemLocation())
				System.out.println("Location: " + location);
			System.out.println("Usage: " + guideItem.getImagePath());*/
			
			/*BufferedReader reader = new BufferedReader(new FileReader("Room.txt"));
			Room room = Room.readRoom(reader);
			System.out.println("ID: " + room.getRoomID());
			System.out.println("Name: " + room.getRoomName());
			for(String desc : room.getRoomDesc())
				System.out.println(desc);*/
			
			BufferedReader reader = new BufferedReader(new FileReader("Monster.txt"));
			Monster monster = Monster.readMonster(reader);
			System.out.println("ID: " + monster.getId());
			System.out.println("Name: " + monster.getName());
			for(String desc : monster.getDesc())
				System.out.println(desc);
			System.out.println("Health");
			for(int health : monster.getHealth())
				System.out.print(health + " ");
			System.out.println("Attack");
			for(int attack : monster.getAttack())
				System.out.print(attack + " ");
			System.out.println("Location: " + monster.getLocation());
			System.out.println("Item drops: " + monster.getItemDrop());
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
