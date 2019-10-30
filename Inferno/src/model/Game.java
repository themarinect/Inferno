package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Game
{
	private String title;
	private Map<Integer,Room> rooms;
	private Map<String,Item> items;
	private Map<String,Puzzle> puzzles;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Game(String filename)
	{
		//initRoom
		rooms = new TreeMap<Integer, Room>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			title = reader.readLine();
			while(true)
			{
				Room room = Room.readRoom(reader);
				if(room == null)
					break;
				rooms.put(room.getRoomNumber(), room); //puts a list of Rooms into Map
			}
			reader.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
		
		//initItems
		items = new TreeMap<String, Item>();
		try
		{
			String item_file = "items.txt";
			BufferedReader reader = new BufferedReader(new FileReader(item_file));
			while(true)
			{
				Item item = Item.readItem(reader);
				if(item == null)
					break;
				items.put(item.getItemName(), item);
				rooms.get(item.getItemInitialRoom()).addItem(item);
			}
			reader.close();
		}catch (IOException e)
		{
			e.getMessage();
		}
		
		//initPuzzles
		puzzles = new TreeMap<String, Puzzle>();
		try
		{
			String puzzle_file = "puzzles.txt";
			BufferedReader reader = new BufferedReader(new FileReader(puzzle_file));
			while(true)
			{
				Puzzle puzzle = Puzzle.readPuzzle(reader);
				if(puzzle == null)
					break;
				puzzles.put(puzzle.getPuzzleID(), puzzle);
				rooms.get(puzzle.getRoomNumber()).addPuzzle(puzzle);
			}
			reader.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
	}
	
	public void displayInventory()
	{
		System.out.println("Inventory: ");
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.size() == 0)
				System.out.println("You have nothing in the inventory.\n");
			else
				System.out.println(inventory.get(i).getItemName() + ": " + inventory.get(i).getItemDesc() + "\n");
		}
			
	}
	
	public void pickupItem(Room room)
	{
		for(Item item : room.getItems())
		{
			if(room.containsItem(item))
			{
				room.removeItem(item);
				inventory.add(item);
				System.out.println("The " + item.getItemName() + " has been added to inventory.\n");
			}
			else
				System.out.println("No item here.");
		}
	}
	
	public void dropItem(Room room, String choice)
	{
		choice = choice.substring(5).toUpperCase();
		/*for(Item item : inventory)
		{
			if(choice.equals(item.getItemName()))
			{
				room.addItem(item);
				inventory.remove(item);
				System.out.println("Item dropped.\n");
			}
			else
			{
				System.out.println(choice);
				System.out.println("No such item in the inventory.\n");
			}
				
		}*/
		for(int i = 0; i < inventory.size(); i++)
		{
			if(choice.equals(inventory.get(i).getItemName()))
			{
				room.addItem(inventory.get(i));
				inventory.remove(i);
				System.out.println("Item dropped\n");
			}
			else
			{
				System.out.println("No such item in the inventory.\n");
			}
		}
	}
	
	public void lookPuzzle(Room room)
	{
		for(Puzzle puzzle : room.getPuzzles())
		{
			if(room.containsPuzzle(puzzle))
				for(String question : puzzle.getQuestion())
					System.out.println(question);
			else
				System.out.println("No puzzle in this room");
		}
	}
	
	public void solvePuzzle(Room room, String answer) //logic not good. Needs to change
	{
		Scanner input = new Scanner(System.in);
		
		for(Puzzle puzzle : room.getPuzzles())
		{
			if(answer.equals(puzzle.lookupAnswer("CorrectAnswer")))
			{
				System.out.println("Congratulations!!!");
				System.out.println("The puzzle has been removed from the room.\n");
				room.removePuzzle(puzzle);
			}
			else
			{
				System.out.println("Wrong answer");
				System.out.println("Do you want to try again? You will have 3 attempts");
				String choice = input.nextLine();
				if(choice.equals("yes"))
				{
					int attempt = 3; //3 attempts
					while(attempt != 0)
					{
						System.out.println("Enter your answer: ");
						answer = input.nextLine();
						if(answer.equals(puzzle.lookupAnswer("CorrectAnswer")))
						{
							System.out.println("Congratulations!!!");
							System.out.println("The puzzle has been removed from the room.\n");
							room.removePuzzle(puzzle);
						}
						else
						{
							attempt--;
							System.out.println("Wrong answer. " + "Remaining attempt: " + attempt + "\n");
						}
							
					}
					System.out.println("No more attempt remains.");
					System.out.println("The puzzle will be removed from the room.\n");
					room.removePuzzle(puzzle);
				}
			}
		}
	}
	
	public String getTitle()
	{
		return title;
	}

	public Room getRooms(int roomNumber)
	{
		return rooms.get(roomNumber);
	}
}
