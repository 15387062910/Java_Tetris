package control;

import ui.JFrameGame;
import ui.JPanelGame;
import ui.cfg.FrameConfig;
import service.GameService;
import service.GameTetris;
import dao.*;
import dto.GameDto;


// 游戏控制器
public class GameControl {
	
	// 数据访问接口 - 数据库接口
	private Data dataFromDataBase = null;
	// 数据访问接口 - 本地接口
	private Data dataFromDisk = null;
	
	/*
	 * panelGame:	游戏界面层
	 * gameService: 游戏逻辑层 
	 * dto:			游戏数据源
	 * */
	private JPanelGame panelGame = null;
	private GameService gameService = null;
	private GameDto dto = null;
	
	// 用户设置界面
	private FrameConfig frameConfig;
	
	// 游戏线程
	private Thread gameThread = null;

	public GameControl(){
		// 数据源
		this.dto = new GameDto();
		// 创建游戏逻辑块
		this.gameService =  new GameTetris(dto);;
		// 创建数据库数据接口对象
		this.dataFromDataBase = new DataBase();
		// 设置数据库记录到游戏
		this.dto.setDbRecode(this.dataFromDataBase.loadData());
		// 创建本地数据接口对象
		this.dataFromDisk = new DataDisk();
		// 设置本地记录到游戏
		this.dto.setDiskRecode(this.dataFromDisk.loadData());
		// 创建游戏面板
		this.panelGame= new JPanelGame(this, dto);		// 这里的this指把当前GameControl对象传进去
		// 初始化用户设置界面
		this.frameConfig = new FrameConfig();
		// 创建游戏窗口(安装游戏面板)
		new JFrameGame(panelGame);
	}
	
	// 控制器方向键 空格
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
	
	// 开始按钮事件
	public void start() {
		// 按钮设置为不可点击
		this.panelGame.buttonSwitch(false);
		// 游戏数据初始化
		this.gameService.startGame();
		// 创建线程对象
		this.gameThread = new Thread(){
			@Override
			public void run(){
				// 刷新画面
				panelGame.repaint();
				// 主循环
				while(true){
					try {
						// 等待0.5s
						Thread.sleep(500);
						// 游戏主行为 -> 方块下落
						gameService.mainAction();
						// 刷新画面
						panelGame.repaint();	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// 启动线程
		this.gameThread.start();
		// 重新刷新页面
		this.panelGame.repaint();		
	}

	// 瞬间下落
	public void KeyFunDown(){
		this.gameService.KeyFunDown();
		this.panelGame.repaint();		// 重绘页面
	}
	
	// 阴影开关
	public void KeyShadowSwitch(){
		this.gameService.KeyShadowSwitch();
		this.panelGame.repaint();		// 重绘页面
	}
	
	// 暂停游戏
	public void KeyStop(){
		this.gameService.KeyStop();
		this.panelGame.repaint();		// 重绘页面
	}
	
	// 作弊开挂
	public void kaigua(){
		this.gameService.kaigua();
		this.panelGame.repaint();		// 重绘页面
	}
	
}
