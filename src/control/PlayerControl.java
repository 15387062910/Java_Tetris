package control;

import java.awt.event.*;

public class PlayerControl extends KeyAdapter{
	
	/*
	 * gameControl: 游戏控制器   	获取游戏控制器以调用其中的方法
	 * */
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	/*
	 * 键盘按下事件
	 * */
	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyChar() + " ");
		// System.out.println(e.getKeyCode() + " ");
	
		this.gameControl.test();
		
	}
	
}
