package models.Item;
import java.io.BufferedReader;
import java.util.ArrayList;

public class CombatItem extends Item
{
	private String usage;
	
	public CombatItem()
	{

	}

	public CombatItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
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
