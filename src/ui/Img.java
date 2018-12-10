package ui;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.io.File;

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

	// 数据库字样图片
	public static final Image IMG_DB = new ImageIcon("graphics/string/db.png")
			.getImage();

	// 本地记录字样图片
	public static final Image IMG_DISK = new ImageIcon(
			"graphics/string/disk.png").getImage();

	// 下一个方块图片
	public static Image[] NEXT_ACT;

	// 下一个背景图片数组
	public static List<Image> BG_LIST;

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

	// 阴影图片
	public static final Image IMG_SHADOW = new ImageIcon(
			"graphics/game/shodow.png").getImage();

	// 开始按钮图片
	public static final ImageIcon IMG_START = new ImageIcon(
			"graphics/string/start.png");

	// 设置按钮图片
	public static final ImageIcon IMG_CONFIG = new ImageIcon(
			"graphics/string/config.png");

	static {
		// 下一个方块图片
		NEXT_ACT = new Image[7];
		for (int i = 0; i < Img.NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png")
					.getImage();
		}
		// 背景图片数组
		// 初始化背景图片数组用来实现升级自动换背景 => 不是必要需求暂时不做
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<Image>();
		for (File file : files) {
			// 将所有背景图片添加到BG_LIST中
			if (!file.isDirectory()) {
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}
		}
	}
}
