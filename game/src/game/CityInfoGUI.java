package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CityInfoGUI extends JFrame{
	
	private JTextArea infoArea=new JTextArea();
	CityInfoGUI(Land land)
	{
		infoArea.setEnabled(false);
		infoArea.setDisabledTextColor(Color.BLACK);
		infoArea.append("Land Name : "+land.getName()+"\n");
		infoArea.append("Land Cost : "+String.valueOf(land.getCost())+"\n");
		infoArea.append("Owner : "+(land.getOwner()).getName()+"\n");
		infoArea.append("Building Number : "+String.valueOf(land.getbuildingCount())+"\n");
		this.add(infoArea);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(50, 100, 200, 180);
		setVisible(true);
	}
}
