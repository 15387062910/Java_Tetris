package ui;

import java.awt.*;

import javax.swing.*;

// 图片的声明及定义放这里
public class Img {
	// 将这个类私有化 就是不能创建这个类的对象
	private Img() {
	}

	// 边框图片
	public static final Image IMG = new ImageIcon("graphics/window/Window.png")
			.getImage();

	// 数字图片 -> 260 36
	public static final Image IMG_NUMBER = new ImageIcon(
			"graphics/string/num.png").getImage();

	// 矩形值槽图片
	public static final Image IMG_RECT = new ImageIcon(
			"graphics/window/rect.png").getImage();

	// 背景图片
	public static final Image IMG_GB_TEMP = new ImageIcon(
			"graphics/background/Sea.jpg").getImage();

	// 数据库字样图片
	public static final Image IMG_DB = new ImageIcon("graphics/string/db.png")
			.getImage();

	// 本地记录字样图片
	public static final Image IMG_DISK = new ImageIcon(
			"graphics/string/disk.png").getImage();

	// 下一个方块图片
	public static Image[] NEXT_ACT;

	// 方块的一格
	public static final Image ACT = new ImageIcon("graphics/game/rect.png")
			.getImage();

	// 标题图片
	public static final Image IMG_LEVEL = new ImageIcon(
			"graphics/string/level.png").getImage();
	
	// 窗口标题(分数)
	public static final Image IMG_POINT = new ImageIcon(
			"graphics/string/point.png").getImage();

	// 窗口标题(消行)
	public static final Image IMG_RMLINE = new ImageIcon(
			"graphics/string/rmline.png").getImage();
	
	
	static{
		NEXT_ACT = new Image[7];
		for(int i=0; i<Img.NEXT_ACT.length; i++){
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png")
			.getImage();
		}
	}
}
