package control;

import ui.JPanelGame;
import service.GameService;

public class GameControl {
	/*
	 * panelGame:	游戏界面层
	 * gameService: 游戏逻辑层 
	 * */
	private JPanelGame panelGame;
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
	}

	public void test() {
		this.gameService.gameTest();
		// 重绘页面
		this.panelGame.repaint();
	}
}
