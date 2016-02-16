package game;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Game game=new Game();
		game.setting();
		mapGUI mapGUI=new mapGUI();
		mapGUI.makingGUI();
		userGUI userGUI=new userGUI();
		guiController.getInstance().setMap(mapGUI);
		guiController.getInstance().setUserGUI(userGUI);
		
		game.playing();
	}

}
