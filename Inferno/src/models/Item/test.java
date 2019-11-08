package models.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class test
{

	public static void main(String[] args)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("CombatItem.txt"));
			Item item = new Item();
			if(item instanceof CombatItem)
			{
				CombatItem combatItem = (CombatItem) item;
				System.out.println("ID: " + combatItem.getItemID());
				System.out.println("Name: " + combatItem.getItemName());
				System.out.println("Type: " + combatItem.getItemType());
				for(String desc : combatItem.getItemDesc())
					System.out.println("Desc: " + desc);
				for(String location : combatItem.getItemLocation())
					System.out.println("Location: " + location);
				System.out.println("Usage: " + combatItem.getUsage());
			}
			
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
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
