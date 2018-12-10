package service;

import java.util.List;
import java.util.Random;
import java.awt.*;

import dto.*;
import entity.GameAct;

// 游戏逻辑层
public class GameService {
	// 游戏数据
	private GameDto dto;
	
	// 随机数生成器
	private Random random = new Random();
	
	// 方块种类个数
	private static final int MAX_TYPE = 6;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}
	
	// 控制器方向键 旋转
	public void KeySpace() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

	// 控制器方向键 向上
	public void KeyUp() {
		this.dto.getGameAct().move(0, -1, this.dto.getGameMap());
	}

	// 控制器方向键 向下
	public void KeyDown() {
		// 获得游戏地图对象
		boolean[][] map = this.dto.getGameMap();
		if(this.dto.getGameAct().move(0, 1, map)){
			return;
		}
		// 获得方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
		// 将方块堆积到地图数组
		for(int i=0; i<act.length; i++){
			map[act[i].x][act[i].y] = true;
		}
		// TODO 判断是否可以消行
		// TODO 消行  
		// TODO 算法  
		// TODO 判断是否升级  
		// TODO 升级  
		// 创建下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
		// 随机生成下一个方块
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}

	// 控制器方向键 向左
	public void KeyLeft() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
	}

	// 控制器方向键 向右
	public void KeyRight() {
		this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
	}
	
	
	// ==============================
	// TODO test
	public void test(){
		System.out.println("test in GameService ");
		// test 升级
		// this.dto.setLevel(this.dto.getLevel()+1);
		// test 升级槽
		this.dto.setNowPoint(this.dto.getNowPoint()+10);
		this.dto.setNowRemoveLine(this.dto.getNowRemoveLine()+1);
		
		
	}
	
	public void setRecodeDataBase(List<Player> players){
		this.dto.setDbRecode(players);
	}
	
	public void setRecodeDisk(List<Player> players){
		this.dto.setDiskRecode(players);
	}
	
}
