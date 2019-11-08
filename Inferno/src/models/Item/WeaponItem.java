package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class WeaponItem extends Item
{
	private int attack;

	public WeaponItem()
	{

	}

	public WeaponItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, int _attack)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.setAttack(_attack);
	}

	public static WeaponItem readWeaponItem(BufferedReader reader)
	{
		WeaponItem weaponItem = new WeaponItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			weaponItem.setItemID(line);
			weaponItem.setItemName(reader.readLine());
			weaponItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			weaponItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			weaponItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads usage
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				weaponItem.setAttack(Integer.parseInt(line.substring(colon+1).trim()));
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return weaponItem;
	}
	
	//getter and setter
	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

}