package models.Item;

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
		this.attack = _attack;
	}

	//getter
	public int getAttack()
	{
		return attack;
	}

}
