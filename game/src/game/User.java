package game;

public class User {
	
	private int money;
	private int location;
	
	public User()
	{
		this.money=0;
		this.location=0;
	}
	public void setLocation(int distance)
	{
		this.location+=distance;
		if(location>=16) {
			this.setMoney(200);
			location=(location%16);
		}		
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
