package models;
import java.util.Scanner;

public class PlayGame
{

	public static void main(String[] args)
	{
		Game newGame = readTextFile();
		
		System.out.println(newGame.getTitle()); //prints the first line
		System.out.println("Type quit to quit game anytime \n");
		
		int currentRoomNumber = 1; //sets Room number 1 as the first Room of the game
		Scanner input = new Scanner(System.in);
		while(currentRoomNumber != 0)
		{
			Room room = newGame.getRooms(currentRoomNumber); //initializes Room based on Room number
			System.out.println(room.getRoomName()); //prints Room name
			for(String roomDesc : room.getRoomDesc()) //prints Room description
				System.out.println(roomDesc);
			
			for(Item item : room.getItems())
				System.out.println("There is a " + item.getItemName() + " here");
			
			for(Puzzle puzzle : room.getPuzzles())
				System.out.println("There is a puzzle here");
			
			if(room.isVisited())
				System.out.println("You have visited this room.");
			
			String choice = input.nextLine(); //user's choice of command
			//if user enters "inventory" command
			if(choice.equals("inventory"))
				newGame.displayInventory();
			//if user enters "pickup" command
			else if(choice.equals("pickup"))
				newGame.pickupItem(room);
			//if user enters "drop" command
			else if(choice.equals("drop key") || choice.equals("drop potato") || choice.equals("drop lamp") || choice.equals("drop sword") || choice.equals("drop rod"))
				newGame.dropItem(room, choice);
			//if user enters "look puzzle" command
			else if(choice.equals("look puzzle"))
			{
				newGame.lookPuzzle(room);
				System.out.println("Do you want to solve it?");
				choice = input.nextLine();
				if(choice.equals("yes"))
				{
					System.out.println("Enter your answer: ");
					choice = input.nextLine();
					newGame.solvePuzzle(room, choice);
				}
			}
			//if user enters directions command
			else
			{
				int nextRoomNumber = room.lookupNavigation(choice); //looks up associated Room number based on user's direction choice
				if(nextRoomNumber == -1)
					System.out.println("Nothing here \n");
				else
				{
					currentRoomNumber = nextRoomNumber;
					room.setVisited(true);
				}
			}	
		}
		System.out.println("Quit game");
	}
	
	//Creates a new game with txt file
	public static Game readTextFile()
	{
		while(true)
		{
			String filename = "rooms.txt";
			return new Game(filename);
		}
	}
}
