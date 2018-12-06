package ui;

import java.awt.Font;
import java.awt.Graphics;

public class LayGame extends Lay {
	public LayGame(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.setFont(new Font("黑体", Font.BOLD, 64));
		String nowPoint = Integer.toString(this.dto.getNowPoint());
		g.drawString(nowPoint, this.x + PADDING, this.y + PADDING + 50);
	}
}
