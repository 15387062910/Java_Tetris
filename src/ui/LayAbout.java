package ui;

import java.awt.Color;
import java.awt.Graphics;

public class LayAbout extends Lay {
	public LayAbout(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		g.setColor(Color.BLUE);
		g.setFont(DEF_FONT);
		g.drawString("Producted by WYB", this.x + PADDING, this.y
				+ (this.h >> 1));
	}
}
