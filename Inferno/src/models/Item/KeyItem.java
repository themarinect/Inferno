package models.Item;

import java.util.ArrayList;

public class KeyItem extends Item
{
	private String associatedMonster;

	public KeyItem()
	{
		
	}

	public KeyItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
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
