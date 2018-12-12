package ui;

import java.awt.*;
import entity.GameAct;

public class LayGame extends Lay {

	// 方块的左位移
	private static final int SIZE_ROL = 32;

	// 方块移动的限界
	private static final int LEFT_SIDE = 0;
	private static final int RIGHT_SIDE = 9;

	public LayGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// 获得方块数组集合
		GameAct act = this.dto.getGameAct();
		if (act != null) {
			Point[] points = act.getActPoints();
			// 绘制阴影
			this.drawShadow(points, g);
			// 绘制活动方块
			this.drawMainAct(points, g);
		}

		// 绘制游戏地图
		this.drawMap(g);
		
		// 暂停
		if(this.dto.isPause()){
			this.drawImageAtCenter(Img.IMG_PAUSE, g);
		}
	}

	// 绘制活动方块
	private void drawMainAct(Point[] points, Graphics g) {
		// 获得方块类型编号( 0 - 6)
		int typeCode = this.dto.getGameAct().getTypeCode();
		// 绘制方块
		for (int i = 0; i < points.length; i++) {
			this.drawActByPoint(points[i].x, points[i].y, typeCode + 1, g);
		}

	}

	// 绘制游戏地图
	private void drawMap(Graphics g) {
		// 获得地图数组
		boolean[][] map = this.dto.getGameMap();
		// 绘制地图
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y]) {
					drawActByPoint(x, y, 0, g);
				}
			}
		}

	}

	// 绘制阴影
	private void drawShadow(Point[] points, Graphics g) {
		if (!this.dto.getShowShadow()) {
			return;
		}
		int leftX = RIGHT_SIDE;
		int rightX = LEFT_SIDE;
		for (Point p : points) {
			leftX = p.x < leftX ? p.x : leftX;
			rightX = p.x > rightX ? p.x : rightX;
			// System.out.println(leftX + " " + rightX);
		}
		g.drawImage(Img.IMG_SHADOW, this.x + SIZE + (leftX * SIZE_ROL), this.y
				+ SIZE, (rightX - leftX + 1) * SIZE_ROL, this.h - (SIZE * 2),
				null);

	}

	// 绘制中正方形块
	private void drawActByPoint(int x, int y, int imgIndex, Graphics g) {
		imgIndex = this.dto.isStart() ? imgIndex : 0;
		g.drawImage(Img.ACT, this.x + x * SIZE_ROL + 7, this.y + y * SIZE_ROL
				+ 7, this.x + x * SIZE_ROL + SIZE_ROL + 7, this.y + y
				* SIZE_ROL + SIZE_ROL + 7, imgIndex * SIZE_ROL, 0, imgIndex
				* SIZE_ROL + SIZE_ROL, SIZE_ROL, null);
	}

}
