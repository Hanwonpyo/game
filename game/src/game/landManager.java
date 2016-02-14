package game;

import java.util.HashMap;
import java.util.Map;

public class landManager {
	
	private static landManager manager=new landManager();
	private Map<Integer, Land> landList;
	
	landManager(){
		landList = new HashMap<Integer,Land>();
	}
	public static landManager getInstance()
	{
		return manager;
	}
	
	public void add(int number, Land land) 
	{
		this.landList.put(number, land);
	}
	public void remove(int number) 
	{
		this.landList.remove(number);
	}
	public Map<Integer,Land> list()
	{
		return landList;
	}
}
