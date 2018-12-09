package ui;

import java.awt.*;

public class LayPoint extends Lay {

	// 分数和消行的数据对应的x坐标
	private final int comX;
	// 分数y坐标
	private final int pointY;
	// 消行y坐标
	private final int rmlineY;
	// 初始化经验值显示的y坐标
	private final int expY;
	
	// 每到LEVEL_UP矩形值槽满
	private static final int LEVEL_UP = 13;

	public LayPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// 下面初始化都是相对值
		this.comX = PADDING + this.w / 3;
		this.pointY = PADDING;
		this.rmlineY = Img.IMG_RMLINE.getHeight(null) + (PADDING << 1);
		this.expY = this.rmlineY + Img.IMG_RMLINE.getHeight(null) + PADDING;
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// 窗口标题(分数)
		g.drawImage(Img.IMG_POINT, this.x + PADDING, this.y + pointY, null);
		// 绘制分数
		this.drawNumber(comX, pointY, this.dto.getNowPoint(), g);

		// 窗口标题(消行)
		g.drawImage(Img.IMG_RMLINE, this.x + PADDING, this.y + rmlineY, null);
		// 绘制消行
		this.drawNumber(comX, rmlineY, this.dto.getNowRemoveLine(), g);
		
		// 绘制值槽
		// value是当前槽值 maxValue是最大槽值
		double value = (double) (this.dto.getNowRemoveLine() % LEVEL_UP);
		double maxValue = (double) LEVEL_UP;
		this.drawRect(expY, "下一级", null, value, maxValue, g);
	}

}
