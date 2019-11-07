package models;

import java.util.ArrayList;

public class CombatItems extends Item
{
	private String usage;
	
	public CombatItems()
	{

	}

	public CombatItems(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _usage)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.usage = _usage;
	}

	//getter
	public String getUsage()
	{
		return usage;
	}

}
