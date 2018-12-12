package service;

// 游戏逻辑层的接口
public interface GameService {
	// 控制器方向键 向上
	public boolean KeyUp();

	// 控制器方向键 向下
	public boolean KeyDown();

	// 控制器方向键 向左
	public boolean KeyLeft();

	// 控制器方向键 向右
	public boolean KeyRight();
	
	// 开始游戏
	public boolean startGame();
	
	// 方块快速下落
	public boolean KeyFunDown();
	
	// 方块下落阴影开关
	public boolean KeyShadowSwitch();
	
	// 暂停游戏
	public boolean KeyStop();
	
	// 游戏主要行为
	public void mainAction();

	// 开挂键(直接加分)
	public void kaigua();
}
