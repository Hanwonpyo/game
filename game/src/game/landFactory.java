package game;

public class landFactory {
	
	public Land makeLand(char c)
	{
		Land land = null;
		
		switch(c) {
			case 'A' :
				land=new CityA("A");
				break;
			case 'B' :
				land=new CityB("B");
				break;
			case 'C' :
				land=new CityC("C");
				break;
			case 'D' :
				land=new CityD("D");
				break;
			case 'E' :
				land=new CityE("E");
				break;
			case 'F' :
				land=new CityF("F");
				break;
			case 'G' :
				land=new CityG("G");
				break;
			case 'H' :
				land=new CityH("H");
				break;
			case 'I' :
				land=new CityI("I");
				break;
			case 'J' :
				land=new CityJ("J");
				break;
			case 'K' :
				land=new CityK("K");
				break;
			case 'L' :
				land=new CityL("L");
				break;
		}
		this.addtoList(c,land);
		
		return land;	
	}
	
	public void addtoList(char name,Land land)
	{
		for(char c='A';c<='L';c++) 
		{
			if(c==name) {
				int number=(c-'A');
				landManager.getInstance().add(0, land);
				break;
			}
		}
	}
}
