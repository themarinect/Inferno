package models.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import models.Item.CombatItem;

public class Monster extends Character
{
	private ArrayList<String> desc;
	private ArrayList<Integer> health;
	private ArrayList<Integer> attack;
	private String location;
	private String itemDrop;

	public Monster()
	{

	}

	public Monster(String _id, String _name, ArrayList<String> _desc, ArrayList<Integer> _health, 
			ArrayList<Integer> _attack, String _location, String _itemDrop)
	{
		super(_id, _name);
		this.desc = _desc;
		this.health = _health;
		this.attack = _attack;
		this.location = _location;
		this.itemDrop = _itemDrop;
	}
	
	public static Monster readMonster(BufferedReader reader)
	{
		Monster monster = new Monster();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			monster.setId(line);
			monster.setName(reader.readLine());
			
			//reads description
			monster.desc = new ArrayList<String>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				monster.desc.add(line);
			} 
			
			/*-------------------------------------------------------*/
			
			//reads health
			monster.health = new ArrayList<Integer>();
			line = reader.readLine();
			line = line.trim();
			int colon1 = line.indexOf(":");
			String[] health = line.substring(colon1+1).trim().split("/",-2);
			for(String a : health)
				monster.health.add(Integer.parseInt(a));
			
			//reads attack
			monster.attack = new ArrayList<Integer>();
			line = reader.readLine();
			line = line.trim();
			int colon2 = line.indexOf(":");
			String[] attack = line.substring(colon2+1).trim().split("/",-2);
			for(String a : attack)
				monster.attack.add(Integer.parseInt(a));
			
			//reads location
			line = reader.readLine();
			line = line.trim();
			int colon3 = line.indexOf(":");
			monster.location = line.substring(colon3+1).trim();
			
			//reads item drops
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				line = line.trim();
				int colon4 = line.indexOf(":");
				monster.itemDrop = line.substring(colon4+1).trim();
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return monster;
	}

	//getters
	public ArrayList<String> getDesc()
	{
		return desc;
	}

	public ArrayList<Integer> getHealth()
	{
		return health;
	}

	public ArrayList<Integer> getAttack()
	{
		return attack;
	}

	public String getLocation()
	{
		return location;
	}

	public String getItemDrop()
	{
		return itemDrop;
	}
}
