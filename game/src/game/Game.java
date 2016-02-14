package game;

public class Game {
	
	User A,B;
	Dice firstDice,secondDice;
	int distance;

	public void setting()
	{
		landFactory factory=new landFactory();
		for(char c='A';c<='L';c++)
			factory.makeLand(c);
		
		this.makingMap();
		
		A=new User();
		B=new User();
		A.setMoney(200);
		B.setMoney(200);
		
		firstDice=new Dice();
		secondDice=new Dice();	
	}
	public void playing()
	{
		while(A.getMoney()>0 && B.getMoney()>0) {
			//UserA 중앙에 턴 메세지 출력
			//rolling 버튼 누르면
			
			//더블나왔을경우 do while
			//int count>2 setlocation=2;
			//무인도 0;
			//User A,B의 경우 합쳐서 할 함수 생각
			firstDice.rollDice();
			secondDice.rollDice();
			distance=firstDice.getNumber()+
					secondDice.getNumber();
			A.setLocation(distance);
			Land land_at_A;
			land_at_A=landManager.getInstance().list().get(A.getLocation());
			if(land_at_A.getOwner()==A || land_at_A.getOwner()==null) {
				//무인도나 시작점,우주여행일 경우 break;
				//select();
				//when buying
				if(land_at_A.getbuildingCount()<3) {
					if((A.getMoney()-land_at_A.getCost())>0) {
						land_at_A.setOwner(A);
						A.setMoney(-land_at_A.getCost());
						land_at_A.addbuilingCount();
					}
				}
			}
			if(land_at_A.getOwner()==B) {
				A.setMoney(-land_at_A.getCost());
				B.setMoney(+land_at_A.getCost());
			}
			
			//UserB
			firstDice.rollDice(); 
			secondDice.rollDice();
			distance=firstDice.getNumber()+
					secondDice.getNumber();
			B.setLocation(distance);
			Land land_at_B;
			land_at_B=landManager.getInstance().list().get(B.getLocation());
			if(land_at_B.getOwner()==B || land_at_B.getOwner()==null) {
				//select();
				if(land_at_B.getbuildingCount()<3) {
					if((B.getMoney()-land_at_B.getCost())>0) {
						land_at_A.setOwner(B);
						B.setMoney(-land_at_B.getCost());
						land_at_B.addbuilingCount();
					}
				}
			}
			if(land_at_B.getOwner()==A) {
				B.setMoney(-land_at_A.getCost());
				A.setMoney(+land_at_A.getCost());
			}
		}
		
	}
	
	public void makingMap()
	{
		
	}
}
