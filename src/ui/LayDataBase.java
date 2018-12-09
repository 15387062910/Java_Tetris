package ui;

import java.awt.Graphics;

public class LayDataBase extends Lay {
	
	public LayDataBase(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.IMG_DB, this.x+PADDING, this.y+PADDING, null);
	}
}
