package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.awt.*;
import dto.*;
import entity.GameAct;

// 俄罗斯方块游戏逻辑的具体实现
public class GameTetris implements GameService{
	// 游戏数据
	private GameDto dto;

	// 随机数生成器
	private Random random = new Random();

	// 方块种类个数
	private static final int MAX_TYPE = 6;

	// 升级需要的经验数
	private static final int LEVEL_UP = 10;

	// 消除一行得到的经验
	private static final int LINE_EXP = 1;

	// 连续消行分数表
	private static Map<Integer, Integer> PLUS_POINT = null;

	// 初始化连续消行分数表
	static {
		PLUS_POINT = new HashMap<Integer, Integer>();
		PLUS_POINT.put(1, 10);
		PLUS_POINT.put(2, 30);
		PLUS_POINT.put(3, 50);
		PLUS_POINT.put(4, 80);
	}
	
	public GameTetris(GameDto dto) {
		this.dto = dto;
	}

	// 控制器方向键 向上
	@Override
	public boolean KeyUp() {
		// 暂停限制
		if (this.dto.isPause()) {
			return true;
		}
		// 旋转
		synchronized (this.dto) {
			// 独占dto
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		return true;
	}

	// 控制器方向键 向下
	@Override
	public boolean KeyDown() {
		// 暂停限制
		if (this.dto.isPause()) {
			return true;
		}
		synchronized (this.dto){
			// 获得游戏地图对象
			boolean[][] map = this.dto.getGameMap();
			// 成功移动后返回
			if (this.dto.getGameAct().move(0, 1, map)) {
				return true;
			}
			// 获得方块对象
			Point[] act = this.dto.getGameAct().getActPoints();
			// 将方块堆积到地图数组
			for (int i = 0; i < act.length; i++) {
				map[act[i].x][act[i].y] = true;
			}
	
			// 判断消行 并计算经验值
			int plusExp = this.plusExp();
			// 如果发生消行 就加分升级
			if (plusExp > 0) {
				this.plusPoint(plusExp);
			}
	
			// 创建下一个方块
			this.dto.getGameAct().init(this.dto.getNext());
			// 随机生成下一个方块
			this.dto.setNext(random.nextInt(MAX_TYPE));
			
			// 检查游戏是否失败
			if(this.isLose()){
				// 结束游戏
				this.dto.setStart(false);
			}
		}
		
		return false;
	}

	// 控制器方向键 向左
	@Override
	public boolean KeyLeft() {
		// 暂停限制
		if (this.dto.isPause()) {
			return true;
		}
		synchronized (this.dto) {
			this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
		}
		
		return true;
	}

	// 控制器方向键 向右
	@Override
	public boolean KeyRight() {
		// 暂停限制
		if (this.dto.isPause()) {
			return true;
		}
		synchronized (this.dto) {
			this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
		}
		
		return true;
	}
	
	// 开始游戏
	@Override
	public boolean startGame() {
		synchronized (this.dto) {
			// 随机生成下一个方块
			this.dto.setNext(random.nextInt(MAX_TYPE));
			// 随机生成画面方块
			this.dto.setGameAct(new GameAct(random.nextInt(MAX_TYPE)));
			// 把游戏状态设置为开始
			this.dto.setStart(true);
			// dto初始化
			this.dto.dtoInit();
		}
		
		return true;
	}


	// 消行操作 -> 一行就是LINE_EXP点经验值
	private int plusExp() {
		// 获得游戏地图
		boolean[][] map = this.dto.getGameMap();
		// 游戏经验
		int exp = 0;
		// 扫描游戏地图 查看是否有消行
		for (int y = 0; y < GameDto.GAMEZON_H; y++) {
			// 判断是否可消行
			if (isCanRemoveLine(y, map)) {
				// 如果可消行就进行消行操作
				this.removeLine(y, map);
				// 增加经验值
				exp += LINE_EXP;
			}
		}

		return exp;
	}

	// 消行处理
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < GameDto.GAMEZON_W; x++) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y - 1];
			}
			map[x][0] = false;
		}
	}

	// 判断某一行是否可消除
	private boolean isCanRemoveLine(int y, boolean[][] map) {
		// 对单行的所有方块进行扫描
		for (int x = 0; x < GameDto.GAMEZON_W; x++) {
			if (!map[x][y]) {
				// 如果有一个方格为false那么本行不可消除
				return false;
			}
		}

		return true;
	}

	// 加分升级操作
	private void plusPoint(int plusExp) {
		int level = this.dto.getNowLevel(); // 级数
		int rmline = this.dto.getNowRemoveLine(); // 消行数
		int point = this.dto.getNowPoint(); // 分数
		if (rmline % LEVEL_UP + plusExp >= LEVEL_UP) {
			// 升级
			this.dto.setNowLevel(++level);
		}
		// 设置新的消行数和分数
		this.dto.setNowRemoveLine(rmline + plusExp);
		this.dto.setNowPoint(point + PLUS_POINT.get(plusExp));

	}
	
	// 检查游戏是否失败
	private boolean isLose(){
		// 获得现在的活动方块
		Point[] actPoint = this.dto.getGameAct().getActPoints();
		// 获得现在的游戏地图
		boolean[][] map = this.dto.getGameMap();
		for(int i=0; i<actPoint.length; i++){
			if(map[actPoint[i].x][actPoint[i].y]){
				return true;
			}
		}
		
		return false;
	}
	
	// 作弊开挂键
	@Override
	public void kaigua(){
		this.dto.setCheat(true);
		this.plusPoint(3);
	}
	
	// 方块瞬间下落
	@Override
	public boolean KeyFunDown(){
		// 暂停限制
		if (this.dto.isPause()) {
			return true;
		}
		// 不断调用方块下落函数实现方块瞬间下落
		while(this.KeyDown());
		return true;
	}
	
	// 方块下落阴影开关
	@Override
	public boolean KeyShadowSwitch(){
		synchronized (this.dto) {
			this.dto.changeShowShadow();
		}
		
		return true;
	}

	// 暂停游戏
	@Override
	public boolean KeyStop(){
		if(this.dto.isStart()){
			this.dto.changePause();
		}
		
		return true;
	}
	
	// 游戏主行为(方块自动下落)
	@Override
	public void mainAction(){
		this.KeyDown();
		
	}
	
}
