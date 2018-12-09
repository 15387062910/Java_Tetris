package ui;

import java.awt.*;

public class LayNext extends Lay {
	
	public LayNext(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		this.drawImageAtCenter(Img.NEXT_ACT[this.dto.getNext()], g);
	}
	
}
