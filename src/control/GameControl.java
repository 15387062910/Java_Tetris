package control;

import ui.JPanelGame;
import ui.cfg.FrameConfig;
import service.GameService;
import dao.*;


public class GameControl {
	
	// 数据访问接口 - 数据库接口
	private Data dataFromDataBase;
	// 数据访问接口 - 本地接口
	private Data dataFromDisk;
	
	/*
	 * panelGame:	游戏界面层
	 * gameService: 游戏逻辑层 
	 * */
	private JPanelGame panelGame;
	private GameService gameService;
	
	// 用户设置界面
	private FrameConfig frameConfig;
	
	public GameControl(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
		// 从数据接口A获得数据库记录
		this.dataFromDataBase = new DataBase();
		// 从数据接口B获得本地数据记录
		this.dataFromDisk = new DataDisk();
		
		// 设置数据库记录到游戏
		this.gameService.setRecodeDataBase(dataFromDataBase.loadData());
		// 设置本地数据记录到游戏
		this.gameService.setRecodeDisk(dataFromDisk.loadData());
		
		// 初始化用户设置界面
		this.frameConfig = new FrameConfig();
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
	
	// 显示玩家设置窗口
	public void showUserConfig(){
		// 设置玩家设置窗口可见
		this.frameConfig.setVisible(true);
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
