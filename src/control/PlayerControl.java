package control;

import java.awt.event.*;

import dto.GameDto;

public class PlayerControl extends KeyAdapter {

	/*
	 * gameControl: 游戏控制器 获取游戏控制器以调用其中的方法 dto: 游戏数据: 获取游戏相关数据
	 */
	private GameControl gameControl;
	private GameDto dto;

	public PlayerControl(GameControl gameControl, GameDto dto) {
		this.gameControl = gameControl;
		this.dto = dto;
	}

	/*
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyChar() + " ");
		// System.out.println(e.getKeyCode() + " ");

		// 还没有开始或者游戏结束时不允许按键
		if (!this.dto.isStart()) {
			if(e.getKeyCode() == KeyEvent.VK_K){
				this.gameControl.actionByKeyCode(KeyEvent.VK_K);
			} else{
				return;
			}
		}
		
		// 用反射干掉switch
		this.gameControl.actionByKeyCode(e.getKeyCode());

	} 

}
