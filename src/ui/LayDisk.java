package ui;

import java.awt.Graphics;

public class LayDisk extends Lay {
	
	public LayDisk(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.IMG_DISK, this.x+PADDING, this.y+PADDING, null);
	}
}
