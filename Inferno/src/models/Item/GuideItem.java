package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class GuideItem extends Item
{
	private String imagePath;
	
	public GuideItem()
	{

	}

	public GuideItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _imagePath)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.imagePath = _imagePath;
	}
	
	public static GuideItem readGuideItem(BufferedReader reader)
	{
		GuideItem guideItem = new GuideItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			guideItem.setItemID(line);
			guideItem.setItemName(reader.readLine());
			guideItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			guideItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			guideItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads image path
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				guideItem.imagePath = line.substring(colon+1).trim();
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		return guideItem;
	}

	//getters
	public String getImagePath()
	{
		return imagePath;
	}

}
