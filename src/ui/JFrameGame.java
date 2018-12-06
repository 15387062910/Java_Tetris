package ui;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class JFrameGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private void initJFrame(){
		this.setTitle("Java Tetris");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-this.getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-this.getHeight())/2 - 36;
		this.setLocation(x, y);
	}
	
	public JFrameGame(JPanelGame panelGame){
		initJFrame();
		this.setVisible(true);
		this.setContentPane(panelGame);
	}
}	
