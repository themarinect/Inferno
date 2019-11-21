package models.Puzzle;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import models.Item.Item;
import models.Item.KeyItem;

public class Puzzle
{
	private String puzzleID;
	private String location;
	private String itemDrop;
	private String puzzleName;
	private ArrayList<String> puzzleDesc;
	private String puzzleHint;
	
	private HashMap<String,String> answer;
	
	//A list of key Items associated with Puzzle
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public static Puzzle readPuzzle(BufferedReader reader)
	{
		Puzzle puzzle = new Puzzle();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			puzzle.puzzleID = line;
			puzzle.location = reader.readLine();
			puzzle.itemDrop = reader.readLine();
			puzzle.puzzleName = reader.readLine();
			
			//reads hint
			line = reader.readLine();
			line = line.trim();
			int colon = line.indexOf(":");
			String hint = line.substring(colon+1).trim();
			puzzle.puzzleHint = hint;
			
			//reads description
			puzzle.puzzleDesc = new ArrayList<>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				puzzle.puzzleDesc.add(line);
			}
			
			//reads answer
			puzzle.answer = new HashMap<String, String>();
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				parseAnswer(puzzle, line);
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		return puzzle;
	}
	
	public static void parseAnswer(Puzzle puzzle, String line)
	{
		line = line.trim();
		int colon = line.indexOf(":");
		String label = line.substring(0,colon).trim();
		String correctAnswer = line.substring(colon+1).trim();
		puzzle.getAnswer().put(label, correctAnswer);
	}
	
	public String lookupAnswer(String choice)
	{
		String value = getAnswer().get(choice);
		if(value == null)
			return null;
		return value;
	}

	/*-----For Item-----*/
	//Adds an key item to the list
	public void addItem(Item item)
	{
		itemList.add(item);
	}
	//Removes an key item from the list
	public void removeItem(Item item)
	{
		itemList.remove(item);
	}
	//Returns an array of all key items
	public Item[] getItems()
	{
		Item[] itemArray = new Item[itemList.size()];
		int i = 0;
		for(Item tempItem : itemList)
			itemArray[i++] = tempItem;
		return itemArray;
	}
	
	//getters
	public String getPuzzleID()
	{
		return puzzleID;
	}

	public String getLocation()
	{
		return location;
	}

	public String getItemDrop()
	{
		return itemDrop;
	}

	public String getPuzzleName()
	{
		return puzzleName;
	}

	public ArrayList<String> getPuzzleDesc()
	{
		return puzzleDesc;
	}

	public String getPuzzleHint()
	{
		return puzzleHint;
	}

	private HashMap<String,String> getAnswer()
	{
		return answer;
	}
}
