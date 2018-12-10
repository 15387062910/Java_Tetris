package ui;

import dto.Player;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

// 继承Lay 供LayDataBase和LayDisk继承  使得LayDataBase和LayDisk公用某些方法
public abstract class LayData extends Lay {

	// 记录行数
	public static final int MAX_ROW = 5;

	// 起始y坐标
	private static int START_Y = 0;

	// 槽的外径
	private static final int RECT_H = IMG_RECT_H + 4;

	// 间距
	private static int SPA = 0;

	public LayData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - RECT_H * 5 - (PADDING << 1) - Img.IMG_DB
				.getHeight(null)) / MAX_ROW;
		START_Y = PADDING + Img.IMG_DB.getHeight(null) + SPA;
	}

	// 绘制所有值槽
	public void showData(Image title, List<Player> players, Graphics g) {
		// 绘制标题
		g.drawImage(title, this.x + PADDING, this.y + PADDING, null);
		for (int i = 0; i < MAX_ROW; i++) {
			Player p = players.get(i);
			int recodePoint = p.getPoint();
			String strPoint = recodePoint == 0 ? null : Integer
					.toString(recodePoint);
			this.drawRect(START_Y + i * (RECT_H + SPA), p.getName(), strPoint,
					0, 1000, g);
		}
	}

}
