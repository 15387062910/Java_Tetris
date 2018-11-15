package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * ���Ʊ��ؼ�¼��
 * 
 * */
public class LayDisk extends Lay {
	// ���ؼ�¼������ͼƬ
	private static Image IMG_DISK = new ImageIcon("graphics/string/disk.png").getImage();
	
	public LayDisk(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_DISK, this.x+PADDING, this.y+PADDING, null);
	}
}
