package models;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle
{
	private String puzzleID;
	private int roomNumber;
	private ArrayList<String> question;
	
	private HashMap<String,String> answer;
	
	public static Puzzle readPuzzle(BufferedReader reader)
	{
		Puzzle puzzle = new Puzzle();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			puzzle.puzzleID = line;
			puzzle.roomNumber = Integer.parseInt(reader.readLine());
			
			puzzle.question = new ArrayList<String>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				puzzle.question.add(line);
			}
			
			puzzle.answer = new HashMap<String, String>();
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				parseAnswer(puzzle, line);
			}
		}catch(IOException e)
		{
			e.getMessage();
		}
		return puzzle;
	}
	
	public static void parseAnswer(Puzzle puzzle, String line)
	{
		line = line.trim();
		int colon = line.indexOf(":");
		String label = line.substring(0,colon).trim();
		String correctAnswer = line.substring(colon+1).trim();
		puzzle.answer.put(label, correctAnswer);
	}
	
	public String lookupAnswer(String choice)
	{
		String value = answer.get(choice);
		if(value == null)
			return null;
		return value;
	}
	
	//getters
	public String getPuzzleID()
	{
		return puzzleID;
	}
	public int getRoomNumber()
	{
		return roomNumber;
	}
	public ArrayList<String> getQuestion()
	{
		return question;
	}
	public HashMap<String,String> getAnswer()
	{
		return answer;
	}
}
