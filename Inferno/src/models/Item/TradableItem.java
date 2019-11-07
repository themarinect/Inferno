package models.Item;

import java.util.ArrayList;

public class TradableItem extends Item
{
	private String NPC;
	
	public TradableItem()
	{
		
	}

	public TradableItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _NPC)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.NPC = _NPC;
	}

	//getter
	public String getNPC()
	{
		return NPC;
	}

}
