package models;

import java.util.ArrayList;

public class KeyItems extends Item
{
	private String associatedMonster;

	public KeyItems()
	{
		
	}

	public KeyItems(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _associatedMonster)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.associatedMonster = _associatedMonster;
	}

	//getter
	public String getAssociatedMonster()
	{
		return associatedMonster;
	}

}
