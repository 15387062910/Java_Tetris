package ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import dto.GameDto;

/*
 * Lay Base
 * 
 * */
abstract public class Lay {
	protected static final int PADDING = 13;
	private static final int SIZE = 7;
	private static final Image IMG = new ImageIcon("graphics/window/Window.png").getImage();
	private static final int IMGW = IMG.getWidth(null);
	private static final int IMGH = IMG.getHeight(null);
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected GameDto dto = null;
	
	public Lay(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	abstract public void paint(Graphics g);
	
	protected void createWindow(Graphics g){
		g.drawImage(IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		g.drawImage(IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, IMGW-SIZE, SIZE, null);
		g.drawImage(IMG, x+w-SIZE, y, x+w, y+SIZE, IMGW-SIZE, 0, IMGW, SIZE, null);
		g.drawImage(IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, IMGH-SIZE, null);
		g.drawImage(IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, IMGW-SIZE, IMGH-SIZE, null);
		g.drawImage(IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, IMGW-SIZE, SIZE, IMGW, IMGH-SIZE, null);
		g.drawImage(IMG, x, y+h-SIZE, x+SIZE, y+h, 0, IMGH-SIZE, SIZE,IMGH, null);
		g.drawImage(IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, IMGH-SIZE, IMGW-SIZE, IMGH, null);
		g.drawImage(IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, IMGW-SIZE,IMGH-SIZE, IMGW, IMGH, null);
	}
	
	protected void setDto(GameDto dto){
		this.dto = dto;
	}
}
