package models.Item;

import java.util.ArrayList;

public class HealingItems extends Item
{

	private int strength;
	
	public HealingItems()
	{
		
	}

	public HealingItems(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, int _strength)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.strength = _strength;
	}

	//getters
	public int getStrength()
	{
		return strength;
	}

}
