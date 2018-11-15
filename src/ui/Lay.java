package ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * 绘制窗口基类
 * 
 * */
abstract public class Lay {
	// 常量
	protected static final int PADDING = 13;
	private static final int SIZE = 7;
	private static final Image IMG = new ImageIcon("graphics/window/Window.png").getImage();
	private static final int IMGW = IMG.getWidth(null);
	private static final int IMGH = IMG.getHeight(null);
	// x和y: 窗口左上角坐标 	w和h: 窗口宽度和高度
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public Lay(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	// 刷新游戏具体内容
	abstract public void paint(Graphics g);
	
	// 绘制窗口
	protected void createWindow(Graphics g){
		// 画左上
		g.drawImage(IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		// 画中上
		g.drawImage(IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, IMGW-SIZE, SIZE, null);
		// 画右上
		g.drawImage(IMG, x+w-SIZE, y, x+w, y+SIZE, IMGW-SIZE, 0, IMGW, SIZE, null);
		// 左中
		g.drawImage(IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, IMGH-SIZE, null);
		// 中
		g.drawImage(IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, IMGW-SIZE, IMGH-SIZE, null);
		// 右中
		g.drawImage(IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, IMGW-SIZE, SIZE, IMGW, IMGH-SIZE, null);
		// 左下
		g.drawImage(IMG, x, y+h-SIZE, x+SIZE, y+h, 0, IMGH-SIZE, SIZE,IMGH, null);
		// 中下
		g.drawImage(IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, IMGH-SIZE, IMGW-SIZE, IMGH, null);
		// 右下
		g.drawImage(IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, IMGW-SIZE,IMGH-SIZE, IMGW, IMGH, null);
	}
}
