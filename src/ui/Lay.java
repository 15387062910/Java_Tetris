package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import dto.GameDto;

/*
 * Lay Base
 * 
 * */
abstract public class Lay {
	// 内边距
	protected static final int PADDING = 17;
	// 边框宽度
	protected static final int SIZE = 7;

	// 边框的宽和高
	private static final int IMGW = Img.IMG.getWidth(null);
	private static final int IMGH = Img.IMG.getHeight(null);

	// x y w h 分别是layer在整个界面的坐标以及layer的宽和高
	protected int x;
	protected int y;
	protected int w;
	protected int h;

	// 数字切片的宽和高
	protected static final int IMG_NUMBER_W = Img.IMG_NUMBER.getWidth(null) / 10;
	protected static final int IMG_NUMBER_H = Img.IMG_NUMBER.getHeight(null);

	// 矩形值槽图片宽度
	protected static final int IMG_RECT_W = Img.IMG_RECT.getWidth(null);

	// 矩形值槽图片高度
	protected static final int IMG_RECT_H = Img.IMG_RECT.getHeight(null);

	// 经验值槽的宽度
	private final int expW;

	// 字体
	protected static final Font DEF_FONT = new Font("黑体", Font.BOLD, 20);

	// 数据对象
	protected GameDto dto = null;

	public Lay(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.expW = this.w - (PADDING << 1);
	}

	abstract public void paint(Graphics g);

	protected void createWindow(Graphics g) {
		g.drawImage(Img.IMG, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
		g.drawImage(Img.IMG, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, IMGW
				- SIZE, SIZE, null);
		g.drawImage(Img.IMG, x + w - SIZE, y, x + w, y + SIZE, IMGW - SIZE, 0,
				IMGW, SIZE, null);
		g.drawImage(Img.IMG, x, y + SIZE, x + SIZE, y + h - SIZE, 0, SIZE, SIZE,
				IMGH - SIZE, null);
		g.drawImage(Img.IMG, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE,
				SIZE, IMGW - SIZE, IMGH - SIZE, null);
		g.drawImage(Img.IMG, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, IMGW
				- SIZE, SIZE, IMGW, IMGH - SIZE, null);
		g.drawImage(Img.IMG, x, y + h - SIZE, x + SIZE, y + h, 0, IMGH - SIZE,
				SIZE, IMGH, null);
		g.drawImage(Img.IMG, x + SIZE, y + h - SIZE, x + w - SIZE, y + h, SIZE,
				IMGH - SIZE, IMGW - SIZE, IMGH, null);
		g.drawImage(Img.IMG, x + w - SIZE, y + h - SIZE, x + w, y + h, IMGW - SIZE,
				IMGH - SIZE, IMGW, IMGH, null);
	}

	protected void setDto(GameDto dto) {
		this.dto = dto;
	}

	// 显示数字
	// x 左上角x坐标 y 左上角y坐标 num 要显示的数字 g 画笔对象
	protected void drawNumber(int x, int y, int num, Graphics g) {
		// 把数字number中的每一位取出
		String strNum = Integer.toString(num);
		for (int i = 0; i < strNum.length(); i++) {
			int bit = strNum.charAt(i) - '0';
			// System.out.println(bit);
			g.drawImage(Img.IMG_NUMBER, this.x + x + IMG_NUMBER_W * i, this.y + y,
					this.x + x + IMG_NUMBER_W * (i + 1), this.y + y
							+ IMG_NUMBER_H, bit * IMG_NUMBER_W, 0, (bit + 1)
							* IMG_NUMBER_W, IMG_NUMBER_H, null);
		}
	}

	// 绘制值槽
	protected void drawRect(int expY, String title, String number,
			double value, double maxValue, Graphics g) {
		// 各种值的初始化
		int rect_x = this.x + PADDING;
		int rect_y = this.y + expY;
		// 绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, expW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, expW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, expW - 4, IMG_RECT_H);
		// 绘制值槽
		// 求出比值
		double p = value / maxValue;
		// 求出宽度
		int w = (int) ((p * (this.expW - 4)));
		// 求出颜色
		int subIdx = (int) (p * IMG_RECT_W);
		g.drawImage(Img.IMG_RECT, rect_x + 2, rect_y + 2, rect_x + 2 + w, rect_y
				+ 2 + IMG_RECT_H, subIdx, 0, subIdx + 1, IMG_RECT_H, null);
		// 设置下一级的字体颜色和字体种类
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x + 4, rect_y + 22);
		if (number != null) {
			// TODO 绘制数值
			g.drawString(number, rect_x + 230, rect_y + 22);
		}
	}

	// 居中绘图
	protected void drawImageAtCenter(Image img, Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		int imgX = this.x + (this.w - imgW >> 1);
		int imgY = this.y + (this.h - imgH >> 2);
		g.drawImage(img, imgX, imgY, null);
	}

}
