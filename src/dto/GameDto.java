package dto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import entity.GameAct;
import ui.LayData;

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

	// 构造方法
	public GameDto() {
		dtoInit();
	}

	// dto初始化
	public void dtoInit() {
		// 初始化gameMap
		this.gameMap = new boolean[10][18];
		// 初始化所有游戏对象
	}
	
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
	 */
	private int next;
	private int level;
	private int nowPoint;
	private int nowRemoveLine;

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

}
