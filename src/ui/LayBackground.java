package ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LayBackground extends Lay {
	// 背景图片
	private static final Image IMG_GB_TEMP = new ImageIcon(
			"graphics/background/Sea.jpg").getImage();
	
	public LayBackground(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	@Override
	public void paint(Graphics g) {
		// 背景后期可以改成根据等级变化
		g.drawImage(IMG_GB_TEMP, 0, 0, 1200, 700, null);	
	}

}
