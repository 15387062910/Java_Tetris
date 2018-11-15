package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;;

public class LayBackground extends Lay {
	// ¡Ÿ ±±≥æ∞
	private static Image IMG_GB_TEMP = new ImageIcon("graphics/background/1.jpg").getImage();
	
	public LayBackground(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG_GB_TEMP, 0, 0, 1200, 700, null);	
	}

}
