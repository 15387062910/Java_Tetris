package ui;

import java.awt.Graphics;

public class LayBackground extends Lay {
	
	public LayBackground(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(Img.IMG_GB_TEMP, 0, 0, 1200, 700, null);	
	}

}
