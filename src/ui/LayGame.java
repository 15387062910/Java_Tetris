package ui;

import java.awt.*;

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
		Point[] points = this.dto.getGameAct().getActPoints();
		// 绘制阴影
		// TODO 阴影关闭
		this.drawShadow(points, true, g);
		// 获得方块类型编号( 0 - 6)
		int typeCode = this.dto.getGameAct().getTypeCode();
		// 绘制方块
		for (int i = 0; i < points.length; i++) {
			drawActByPoint(points[i].x, points[i].y, typeCode + 1, g);
		}

		// 绘制地图
		boolean[][] map = this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y]) {
					drawActByPoint(x, y, 0, g);
				}
			}
		}
	}

	// 绘制阴影
	private void drawShadow(Point[] points, boolean isShowShadow, Graphics g) {
		if (!isShowShadow) {
			return;
		}
		int leftX = RIGHT_SIDE;
		int rightX = LEFT_SIDE;
		for (Point p : points) {
			leftX = p.x < leftX ? p.x : leftX;
			rightX = p.x > rightX ? p.x : rightX;
			// System.out.println(leftX + " " + rightX);
		}
		g.drawImage(Img.IMG_SHADOW, 
				this.x + SIZE + (leftX * SIZE_ROL), 
				this.y + SIZE, 
				(rightX - leftX + 1) * SIZE_ROL, 
				this.h - (SIZE * 2),
				null);

	}

	// 绘制中正方形块
	private void drawActByPoint(int x, int y, int imgIndex, Graphics g) {
		g.drawImage(Img.ACT, this.x + x * SIZE_ROL + 7, this.y + y * SIZE_ROL
				+ 7, this.x + x * SIZE_ROL + SIZE_ROL + 7, this.y + y
				* SIZE_ROL + SIZE_ROL + 7, imgIndex * SIZE_ROL, 0, imgIndex
				* SIZE_ROL + SIZE_ROL, SIZE_ROL, null);
	}

}
