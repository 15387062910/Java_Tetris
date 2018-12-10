package ui;

import java.awt.Graphics;

public class LayDisk extends LayData {
	
	public LayDisk(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		this.showData(Img.IMG_DISK, this.dto.getDiskRecode(), g);
	}
}
