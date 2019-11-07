import java.util.ArrayList;

import models.Item.Item;

public class InventoryItems extends Item
{
	private int capacity;
	
	public InventoryItems()
	{

	}

	public InventoryItems(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, int _capacity)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.capacity = _capacity;
	}

	//getters
	public int getCapacity()
	{
		return capacity;
	}

}
