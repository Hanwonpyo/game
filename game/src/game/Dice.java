package game;
import java.util.Random;

public class Dice {
	
	private int number;
	
	public void rollDice()
	{
		makerandomNumber();
	}
	public void makerandomNumber()
	{
		Random random=new Random();
		this.number=random.nextInt(6)+1;
	}
	public int getNumber()
	{
		return number;
	}
}
