package models;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class GuideItems extends Item
{
	private Image image;
	
	public GuideItems()
	{

	}

	public GuideItems(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
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
