package ui;

import java.awt.Graphics;

public class LayDataBase extends LayData {

	public LayDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// this.dto.getDbRecode()表示使用数据库
		// this.showData(Img.IMG_DB, this.dto.getDbRecode(), g);
		
		// null表示不用数据库
		this.showData(Img.IMG_DB, null, g);
	}
}
