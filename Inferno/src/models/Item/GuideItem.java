package models.Item;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class GuideItem extends Item
{
	private Image image;
	
	public GuideItem()
	{

	}

	public GuideItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, Image _image)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.image = _image;
	}

	public Image getImage()
	{
		return image;
	}

}
