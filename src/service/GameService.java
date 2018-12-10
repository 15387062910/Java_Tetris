package service;

import java.util.HashMap;
import java.util.Map;
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

	// 升级需要的经验数(消10行)
	private static final int LEVEL_UP = 10;

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

	// 设置数据库记录
	public void setRecodeDataBase(List<Player> players) {
		this.dto.setDbRecode(players);
	}

	// 设置本地记录
	public void setRecodeDisk(List<Player> players) {
		this.dto.setDiskRecode(players);
	}

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
		if (this.dto.getGameAct().move(0, 1, map)) {
			return;
		}
		// 获得方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
		// 将方块堆积到地图数组
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// 判断消行 并计算经验值
		int plusExp = this.plusExp();
		// 如果发生消行  就加分升级
		if(plusExp > 0){
			this.plusPoint(plusExp);
		}
		

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

	// 消行操作 -> 一行就是一点经验值
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
				exp++;
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

	// ==============================
	// TODO test
	public void test() {
		System.out.println("test in GameService ");
		// test 升级槽
		this.dto.setNowPoint(this.dto.getNowPoint() + 10);
		this.dto.setNowRemoveLine(this.dto.getNowRemoveLine() + 1);

	}

}
