package dto;

import java.util.List;
import entity.GameAct;

public class GameDto {
	/*	
	 * dbRecode: 	数据库记录
	 * diskRecode:	本地记录
	 * gameMap:		游戏地图
	 * gameAct:		下落方块
	 * */
	private List<Player> dbRecode;
	private List<Player> diskRecode;
	private boolean[][] gameMap;
	private GameAct gameAct;
	
	public List<Player> getDbRecode() {
		return dbRecode;
	}
	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}
	public List<Player> getDiskRecode() {
		return diskRecode;
	}
	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
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
	 * next:			
	 * level:			
	 * nowPoint:		
	 * nowRemoveLine:	
	 * */
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
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
