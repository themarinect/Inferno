package models;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Room
{
	//Room attributes
	private String roomID;
	private String roomName;
	private String[] roomDesc;
	private boolean isVisited;
	//stores directions and associated Room number
	private HashMap<String,String> navigationTable;
	
	//A list of Items in the Room
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	//A list of Puzzles in the Room
	private ArrayList<Puzzle> puzzleList = new ArrayList<Puzzle>();
	
	public Room()
	{
		this.isVisited = false;
	}
	
	public static Room readRoom(BufferedReader reader)
	{
		Room room = new Room();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			room.roomID = line; //reads Room ID from txt file
			room.roomName = reader.readLine(); //reads Room name from txt file
			
			ArrayList<String> roomDescList = new ArrayList<String>(); 
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				roomDescList.add(line); //stores Room description to an ArrayList
			}
			room.roomDesc = new String[roomDescList.size()];
			int i = 0;
			for(String descLine : roomDescList) //iterates ArrayList
				room.roomDesc[i++] = descLine; //puts Room description from ArrayList into an array
			
			room.navigationTable = new HashMap<String, String>(); //initializes a HashMap for each Room
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				parseNavigation(room, line); //reads directions and associated Room ID from txt file 
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return room;
	}
	
	//puts directions and associated Room ID from txt file to HashMap
	public static void parseNavigation(Room room, String line)
	{
		line = line.trim(); //deletes spaces
		int colon = line.indexOf(":");
		String direction = line.substring(0,colon).trim(); //gets direction
		String destinationRoom = line.substring(colon+1).trim(); //get associated Room ID
		room.navigationTable.put(direction, destinationRoom);
	}
	
	//looks up directions and associated Room ID based on user's input
	public String lookupNavigation(String choice)
	{
		String value = navigationTable.get(choice); //gets value based on key
		if(value == null) //if no value matches
			return null;
		return value;
	}
	
	//Adds an item to Item list in the Room
	public void addItem(Item item)
	{
		itemList.add(item);
	}
	
	//Removes an item from Item list in the Room
	public void removeItem(Item item)
	{
		itemList.remove(item);
	}
	
	//Checks if an item is in the Room
	public boolean containsItem(Item item)
	{
		return itemList.contains(item);
	}
	
	//Returns an array of all items in the Room
	public Item[] getItems()
	{
		Item[] itemArray = new Item[itemList.size()];
		int i = 0;
		for(Item tempItem : itemList)
			itemArray[i++] = tempItem;
		return itemArray;
	}
	
	//Adds a puzzle to Puzzle list in the Room
	public void addPuzzle(Puzzle puzzle)
	{
		puzzleList.add(puzzle);
	}
	
	//Returns an array of all items in the Room
	public Puzzle[] getPuzzles()
	{
		Puzzle[] puzzleArray = new Puzzle[puzzleList.size()];
		int i = 0;
		for(Puzzle tempPuzzle : puzzleList)
			puzzleArray[i++] = tempPuzzle;
		return puzzleArray;
	}
		
	//Checks if a puzzle is in the Room
	public boolean containsPuzzle(Puzzle puzzle)
	{
		return puzzleList.contains(puzzle);
	}	
	
	//Removes a puzzle from Puzzle list in the Room
	public void removePuzzle(Puzzle puzzle)
	{
		puzzleList.remove(puzzle);
	}
	
	
	//getters and setters
	public String getRoomID()
	{
		return roomID;
	}

	public String getRoomName()
	{
		return roomName;
	}

	public String[] getRoomDesc()
	{
		return roomDesc;
	}

	public boolean isVisited()
	{
		return isVisited;
	}

	public void setVisited(boolean _isVisited)
	{
		this.isVisited = _isVisited;
	}
}
