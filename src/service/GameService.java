package service;

import dto.*;
import java.util.List;

// 游戏逻辑层的接口
public interface GameService {

	// 设置数据库记录
	public boolean setRecodeDataBase(List<Player> players);

	// 设置本地记录
	public boolean setRecodeDisk(List<Player> players);


	// 控制器方向键 旋转
	public boolean KeySpace();

	// 控制器方向键 向上
	public boolean KeyUp();

	// 控制器方向键 向下
	public boolean KeyDown();

	// 控制器方向键 向左
	public boolean KeyLeft();

	// 控制器方向键 向右
	public boolean KeyRight();
	
	// 启动主线程 开始游戏
	public boolean startMainThread();
	
	// 方块快速下落
	public boolean KeyFunDown();
	
	// 方块下落阴影开关
	public boolean KeyShadowSwitch();
	
	// 暂停游戏
	public boolean KeyStop();




}
