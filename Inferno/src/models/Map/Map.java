package models.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import models.Item.Item;
import models.Puzzle.Puzzle;
import models.Room.Room;


public class Map
{

	private TreeMap<String,Room> rooms;
	private TreeMap<String,Item> items;
	private TreeMap<String,Puzzle> puzzles;
	
	public Map(String filename)
	{
		initRoom(filename);
	}
	
	public void initRoom(String filename)
	{
		//initRoom
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
		}catch(IOException e)
		{
			e.getMessage();
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
			String filename = "rooms.txt";
			return new Map(filename);
		}
	}

}
