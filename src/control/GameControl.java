package control;

import ui.JFrameGame;
import ui.JPanelGame;
import ui.window.JFrameConfig;
import ui.window.JFrameSavePoint;
import service.GameService;
import service.GameTetris;
import dao.*;
import dto.GameDto;
import dto.Player;

import java.util.Map;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;

// 游戏控制器
public class GameControl {
	
	// 数据访问接口 - 数据库接口
	// private Data dataFromDataBase = null;
	
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
	
	// 用户设置窗口
	private JFrameConfig frameConfig;
		
	// 保存分数窗口
	private JFrameSavePoint frameSavePoint;
	
	// 游戏行为控制
	private Map<Integer, Method> actionList;
	
	// 游戏线程
	private Thread gameThread = null;

	public GameControl(){
		// 数据源
		this.dto = new GameDto();
		// 创建游戏逻辑块
		this.gameService =  new GameTetris(dto);;
		
		// ===== 数据库相关
		// 创建数据库数据接口对象
		// this.dataFromDataBase = new DataBase();
		// 设置数据库记录到游戏
		// this.dto.setDbRecode(this.dataFromDataBase.loadData());
		
		// ===== 本地数据相关
		// 创建本地数据接口对象
		this.dataFromDisk = new DataDisk();
		// 设置本地记录到游戏
		this.dto.setDiskRecode(this.dataFromDisk.loadData());
		
		// 创建游戏面板
		this.panelGame= new JPanelGame(this, dto);		// 这里的this指把当前GameControl对象传进去
		// 读取用户控制设置
		this.setControlConfig();
		// 初始化用户设置窗口
		this.frameConfig = new JFrameConfig();
		// 初始化保存分数窗口
		this.frameSavePoint = new JFrameSavePoint(this);
		// 创建游戏窗口(安装游戏面板)
		new JFrameGame(panelGame);
	}
	
	public void setControlConfig(){
		// 创建键盘码和方法名的映射数组 -> 使用反射
		this.actionList = new HashMap<Integer, Method>();
		try{
			actionList.put(KeyEvent.VK_SPACE, this.gameService.getClass().getMethod("KeyStop"));
			actionList.put(KeyEvent.VK_UP, this.gameService.getClass().getMethod("KeyUp"));
			actionList.put(KeyEvent.VK_DOWN, this.gameService.getClass().getMethod("KeyDown"));
			actionList.put(KeyEvent.VK_LEFT, this.gameService.getClass().getMethod("KeyLeft"));
			actionList.put(KeyEvent.VK_RIGHT, this.gameService.getClass().getMethod("KeyRight"));
			actionList.put(KeyEvent.VK_1, this.gameService.getClass().getMethod("KeyFunDown"));
			actionList.put(KeyEvent.VK_V, this.gameService.getClass().getMethod("KeyShadowSwitch"));
			actionList.put(KeyEvent.VK_K, this.gameService.getClass().getMethod("kaigua"));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 根据玩家控制(按键)来决定行为
	public void actionByKeyCode(int keyCode){
		try{
			if(this.actionList.containsKey(keyCode)){
				this.actionList.get(keyCode).invoke(this.gameService);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		this.panelGame.repaint();
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
		// 关闭窗口
		this.frameConfig.setVisible(false);
		this.frameSavePoint.setVisible(false);
		// 游戏数据初始化
		this.gameService.startGame();
		// 创建线程对象
		this.gameThread = new MainThread();
		// 启动线程
		this.gameThread.start();
		// 重新刷新页面
		this.panelGame.repaint();		
	}
	
	// 内部类
	private class MainThread extends Thread{
		@Override
		public void run(){
			// 刷新画面
			panelGame.repaint();
			// 主循环
			while(dto.isStart()){
				try {
					// 等待xs
					Thread.sleep(dto.getSleepTime());
					// System.out.println(dto.getSleepTime());
					// 如果暂停那么不执行主行为
					if(dto.isPause()){
						continue;
					}
					// 游戏主行为 -> 方块下落
					gameService.mainAction();
					// 刷新画面
					panelGame.repaint();	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			afterLose();
		}
	}
	
	// 失败之后的处理
	public void afterLose(){
		if(!this.dto.isCheat()){
			// 显示保存得分窗口
			this.frameSavePoint.show(this.dto.getNowPoint());
		}
		// 使按钮可点击
		this.panelGame.buttonSwitch(true);
	}

	// 保存游戏结束之后的分数
	public void savePoint(String name) {
		Player p = new Player(name, this.dto.getNowPoint());
		// 将新记录保存分别保存到硬盘或数据库
		this.dataFromDisk.saveData(p);
		// this.dataFromDataBase.saveData(p);
		// 重新读取数据到游戏
		this.dto.setDiskRecode(dataFromDisk.loadData());
		// this.dto.setDbRecode(dataFromDataBase.loadData());
		// 刷新画面
		this.panelGame.repaint();
	}
	
}
