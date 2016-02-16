package game;

public class User {
	
	private String name;
	private int money;
	private int location;
	private int island_count;
	
	public User(String name)
	{
		this.name=name;
		this.money=0;
		this.location=0;
		this.island_count=0;
	}
	public void setLocation(int distance)
	{
		this.location+=distance;
		if(location>=16) {
			this.setMoney(50);
			location=(location%16);
		}		
	}
	public void setIslandCount(int count)
	{
		this.island_count=count;
	}
	public int getIslandCount()
	{
		return island_count;
	}
	public String getName()
	{
		return name;
	}
	public int getLocation()
	{
		return location;
	}
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int money)
	{
		this.money+=money;
	}	
}
