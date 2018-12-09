package ui;

import java.awt.*;

public class LayLevel extends Lay {
	
	// 标题图片的宽度
	private static final int IMG_LV_W = Img.IMG_LEVEL.getWidth(null);
	
	public LayLevel(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		// 窗口标题
		int centerX = this.w - IMG_LV_W >> 1;
		g.drawImage(Img.IMG_LEVEL, this.x + centerX, this.y+PADDING, null);
		// 显示等级
		this.drawNumber(centerX, 56, this.dto.getLevel(), g);
	}

}
