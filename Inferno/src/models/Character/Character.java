package models.Character;

public class Character
{

	private String id;
	private String name;
	
	public Character()
	{
		
	}
	
	public Character(String _id, String _name)
	{
		this.id = _id;
		this.name = _name;
	}

	//getters and setters
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
