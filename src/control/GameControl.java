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
	
	// 控制器方向键 旋转
	public void KeySpace() {
		this.gameService.KeySpace();
		this.panelGame.repaint();		// 重绘页面
	}

	// 控制器方向键  向上
	public void KeyUp() {
		this.gameService.KeyUp();
		this.panelGame.repaint();		// 重绘页面
	}

	// 控制器方向键  向下
	public void KeyDown() {
		this.gameService.KeyDown();
		this.panelGame.repaint();		// 重绘页面
	}

	// 控制器方向键  向左
	public void KeyLeft() {
		this.gameService.KeyLeft();
		this.panelGame.repaint();		// 重绘页面
	}

	// 控制器方向键  向右
	public void KeyRight() {
		this.gameService.KeyRight();
		this.panelGame.repaint();		// 重绘页面
	}
	
	// =============================================
	// TODO 测试方法
	public void test(){
		System.out.println("test in GameControl");
		// test
		 this.gameService.test();
		 this.panelGame.repaint();		// 重绘页面
	}
	
}
