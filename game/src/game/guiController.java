package game;

import java.awt.Color;

import javax.swing.JButton;

public class guiController {

	private mapGUI map_gui;
	private userGUI user_gui;
	private boolean check_roll;
	private boolean check_buy;
	private static guiController control=new guiController();
	public static guiController getInstance()
	{		
		if(control==null)
			control = new guiController();
		return control;
	}
	public void setMap(mapGUI gui)
	{
		this.map_gui=gui;
	}
	public void turnOutput(String string)
	{
		map_gui.turnMessage(string);
	}
	public void roll_check(boolean check)
	{
		check_roll=check;
	}
	public boolean is_roll()
	{
		return check_roll;
	}
	public void buy_check(boolean check)
	{
		check_buy=check;
	}
	public boolean is_buying()
	{
		return check_buy;
	}
	public void setALocation(int location)
	{
		map_gui.setButtonColor(location,Color.RED);
	}
	public void setBLocation(int location)
	{
		map_gui.setButtonColor(location,Color.BLUE);
	}
	public void setBothLocation(int location)
	{
		map_gui.setButtonColor(location,Color.CYAN);
	}
	public void setEmptyLocation(int location) {
		map_gui.setButtonColor(location,Color.WHITE);
	}
	
	public void setUserGUI(userGUI gui)
	{
		this.user_gui=gui;
	}
	public void User_info_updateA(User user)
	{
		user_gui.updateInfoA(user);
	}
	public void User_info_updateB(User user)
	{
		user_gui.updateInfoB(user);
	}
	
	public void Land_info(Land land)
	{
		CityInfoGUI infoGUI=new CityInfoGUI(land);
	}
	
}
