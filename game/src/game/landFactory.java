package game;

public class landFactory {
	
	public Land makeLand(int n)
	{
		Land land = null;
		
		switch(n) {
			case 0:
				land=new startPoint("Start");
				break;
			case 1 :
				land=new CityA("A");
				break;
			case 2 :
				land=new CityB("B");
				break;
			case 3 :
				land=new CityC("C");
				break;
			case 4 :
				land=new Island("Island");
				break;
			case 5 :
				land=new CityD("D");
				break;
			case 6 :
				land=new CityE("E");
				break;
			case 7 :
				land=new CityF("F");
				break;
			case 8 :
				land=new CityG("G");
				break;
			case 9 :
				land=new CityH("H");
				break;
			case 10 :
				land=new CityI("I");
				break;
			case 11 :
				land=new CityJ("J");
				break;
			case 12 :
				land=new spaceTravel("Space");
				break;
			case 13 :
				land=new CityK("K");
				break;
			case 14 :
				land=new CityL("L");
				break;
			case 15 :
				land=new CityM("M");
				break;
		}
		this.addtoList(n,land);
		
		return land;	
	}
	
	public void addtoList(int n,Land land)
	{
		for(int i=0;i<16;i++) 
		{
			if(i==n) {
				landManager.getInstance().add(i, land);
				break;
			}
		}
	}
}
