package game;

import java.util.Random;

public class Game {
	
	User A,B;
	Dice firstDice,secondDice;
	int distance;

	public void setting()
	{
		landFactory factory=new landFactory();
		for(int i=0;i<16;i++)
			factory.makeLand(i);
		
		A=new User("playerA");
		B=new User("playerB");
		A.setMoney(200);
		B.setMoney(200);
		
		firstDice=new Dice();
		secondDice=new Dice();	
	}
	public void playing() throws InterruptedException
	{
		guiController.getInstance().User_info_updateA(A);
		guiController.getInstance().User_info_updateB(B);
		while(A.getMoney()>0 && B.getMoney()>0) {
			guiController.getInstance().turnOutput("player A\n");
			turn(A);
			guiController.getInstance().User_info_updateA(A);
			guiController.getInstance().turnOutput("player B\n");
			turn(B);
			guiController.getInstance().User_info_updateB(B);
		}
		//승패 출력
		if(A.getMoney()>0) System.out.println("A is WIN!");
		else 
			System.out.println("B is WIN!");
	}
	
	public void turn(User user) throws InterruptedException
	{
		//무인도 체크
		if(user.getIslandCount()==3) user.setIslandCount(0);
		if(user.getIslandCount()!=0) {
			user.setIslandCount(user.getIslandCount()+1);
			return;
		}
		
		while(true) {
			Thread.sleep(1000);
			if(guiController.getInstance().is_roll()==true) {
				break;
			}
		}
		roll(user);
		guiController.getInstance().roll_check(false);
	}
	public void roll(User user) throws InterruptedException // 다음엔 user에 넣어서
	{
		int a,b;
		int double_count=0;
		do {
			firstDice.rollDice();
			secondDice.rollDice();
			a=firstDice.getNumber();
			b=secondDice.getNumber();
			distance=a+b;
			guiController.getInstance().turnOutput(String.valueOf(a) +
					" " + String.valueOf(b));
			double_count++;
			if(double_count<3)
				this.moving(user);
			else {
				user.setLocation(4); // 무인도 들어갔을 때 턴 count 추가해줘야함
				user.setIslandCount(1);
				break;
			}
		}while(a==b);
	}
	public void moving(User user) throws InterruptedException
	{
		setBeforeLocation(user);
		user.setLocation(distance);
		setAfterLocation(user);
		
		Land land_at_user;
		land_at_user=landManager.getInstance().list().get(user.getLocation());
		
		if(land_at_user==landManager.getInstance().list().get(4)) return;// 무인도
		else if(land_at_user==landManager.getInstance().list().get(0)) return;//시작점
		else if(land_at_user==landManager.getInstance().list().get(12)) //우주여행
		{
			Thread.sleep(1000);
			guiController.getInstance().setEmptyLocation(user.getLocation());
			
			while(true) {
				Random random=new Random();
				int location=random.nextInt(16);
				if(location==12)
					continue;
				else {
					user.setLocation(user.getLocation()+location);
					break;
				}
			}
			setAfterLocation(user);
		}	
		else // 일반도시
		{
			if(land_at_user.getOwner()==user ||
					land_at_user.getOwner().getName()=="NONE") {
				Thread.sleep(1500);
				if(guiController.getInstance().is_buying()==true) {
					//buying
					buying(user,land_at_user);
				}
			}
			else {
				//적의 땅을 밟았을 때
				user.setMoney(-land_at_user.getCost());
				land_at_user.getOwner().setMoney(+land_at_user.getCost());
			}
		}
	}
	public void buying(User user,Land land_at_user)
	{
		if(land_at_user.getbuildingCount()<3) {
			if((user.getMoney()-land_at_user.getCost())>0) {
				land_at_user.setOwner(user);
				land_at_user.setCost(5);
				user.setMoney(-land_at_user.getCost());
				land_at_user.addbuilingCount();
			}
		}
	}
	public void setBeforeLocation(User user)
	{
		if(A.getLocation()!=B.getLocation())
			guiController.getInstance().setEmptyLocation(user.getLocation());
		else {
			if(user==A)
				guiController.getInstance().setBLocation(B.getLocation());
			else
				guiController.getInstance().setALocation(A.getLocation());
		}
	}
	public void setAfterLocation(User user)
	{
		if(A.getLocation()==B.getLocation())
			guiController.getInstance().setBothLocation(user.getLocation());
		else if(user==A)
			guiController.getInstance().setALocation(user.getLocation());
		else if(user==B)
			guiController.getInstance().setBLocation(user.getLocation());
	}
}
