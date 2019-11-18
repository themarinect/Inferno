package models.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class NPC extends Character
{
	
	private ArrayList<String> desc;
	private String npcLocation;
	private String tradeItem;

	public NPC()
	{
	}

	public NPC(String _id, String _name, ArrayList<String> _desc, String _npcLocation, String _tradeItem)
	{
		super(_id, _name);
		this.desc = _desc;
		this.npcLocation = _npcLocation;
		this.tradeItem = _tradeItem;
	}
	
	public static NPC readNPC(BufferedReader reader)
	{
		NPC npc = new NPC();
		
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			npc.setId(line);
			npc.setName(reader.readLine());
			
			//reads description
			npc.desc = new ArrayList<String>();
			while(true)
			{
				line = reader.readLine();
				if(line.equals("-----"))
					break;
				npc.desc.add(line);
			}
			
			/*-------------------------------------------------------*/
			
			//reads location
			npc.npcLocation = reader.readLine();
			
			//reads trade item
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.length() == 0)
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				npc.tradeItem = line.substring(colon+1).trim();
			}
			
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return npc;
		
	}
	
	//getters
	public ArrayList<String> getDesc()
	{
		return desc;
	}

	public String getNpcLocation()
	{
		return npcLocation;
	}

	public String getTradeItem()
	{
		return tradeItem;
	}

}
