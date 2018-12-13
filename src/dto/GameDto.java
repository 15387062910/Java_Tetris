package dto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import entity.GameAct;
import ui.LayData;
import utils.GameFunction;

public class GameDto {
	
	// 游戏宽度和高度
	public static final int GAMEZON_W = 10;
	public static final int GAMEZON_H = 18;
	
	/*
	 * dbRecode: 数据库记录 diskRecode: 本地记录 gameMap: 游戏地图 gameAct: 下落方块
	 */
	private List<Player> dbRecode;
	private List<Player> diskRecode;
	private boolean[][] gameMap;
	private GameAct gameAct;
	
	// set记录之前的处理
	private List<Player> setFillRecode(List<Player> players){
		// 如果进来的是空就添加
		if (players == null) {
			players = new ArrayList<Player>();

		}
		// 如果记录数少于5就添加到5条为止
		while (players.size() < LayData.MAX_ROW) {
			players.add(new Player("No Data", 0));
		}
		// 在set的同时按分数进行排序 由大到小
		Collections.sort(players);
		
		return players;
	}
	
	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = setFillRecode(dbRecode);
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = setFillRecode(diskRecode);
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	/*
	 * next: level: nowPoint: nowRemoveLine:
	 * sleepTime: 线程调用间隔时间
	 */
	private int next;
	private int level;
	private int nowPoint;
	private int nowRemoveLine;
	private long sleepTime;

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowLevel() {
		return level;
	}

	public void setNowLevel(int level) {
		this.level = level;
		// 计算线程等待时间
		this.sleepTime = GameFunction.getSleepTimeByLevel(this.level);
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
	
	public long getSleepTime(){
		return sleepTime;
	}

	// 是否开始游戏
	private boolean start;
	// 是否暂停游戏
	private boolean pause;
	// 是否显示阴影
	private boolean showShadow;
	// 是否使用作弊
	private boolean isCheat;
	
	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isStart() {
		return start;
	}

	public boolean getShowShadow() {
		return showShadow;
	}

	public void changeShowShadow() {
		this.showShadow = !this.showShadow;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	public boolean isPause(){
		return this.pause;
	}

	public void changePause() {
		this.pause = !this.pause;
	}
	
	public void setCheat(boolean isCheat) {
		this.isCheat = isCheat;
	}

	public boolean isCheat() {
		return isCheat;
	}
	
	// 构造方法
	public GameDto() {
		dtoInit();
	}

	// dto初始化
	public void dtoInit() {
		// 初始化gameMap
		this.gameMap = new boolean[10][18];
		// 初始化所有游戏对象
		this.level = 0;
		this.nowPoint = 0;
		this.nowRemoveLine = 0;
		this.pause = false;
		this.setCheat(false);
		this.sleepTime = GameFunction.getSleepTimeByLevel(this.level);
	}

}
