package ui;

import javax.swing.JFrame;
import utils.FrameUtil;

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
		FrameUtil.setFrameCenter(this);
	}
	
	public JFrameGame(JPanelGame panelGame){
		initJFrame();
		this.setVisible(true);
		this.setContentPane(panelGame);
	}
}	
