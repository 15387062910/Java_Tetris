package control;

import java.awt.event.*;

import dto.GameDto;

public class PlayerControl extends KeyAdapter {

	/*
	 * gameControl: 游戏控制器 获取游戏控制器以调用其中的方法
	 * dto: 游戏数据: 获取游戏相关数据
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

		// 重绘页面
		// this.gameControl.test();
		
		// 还没有开始或者游戏结束时不允许按键
		if(!this.dto.isStart()){
			return;
		}
		
		// TODO 改成HashMap结构
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				// 空格键
				this.gameControl.KeySpace();
				break;
			case KeyEvent.VK_UP:
				// 向上
				this.gameControl.KeyUp();
				break;
			case KeyEvent.VK_DOWN:
				// 向下
				this.gameControl.KeyDown();
				break;
			case KeyEvent.VK_LEFT:
				// 向左
				this.gameControl.KeyLeft();
				break;
			case KeyEvent.VK_RIGHT:
				// 向右
				this.gameControl.KeyRight();
				break;
			case KeyEvent.VK_1:
				// 1
				this.gameControl.KeyFunDown();
				break;
			case KeyEvent.VK_V:
				// V
				this.gameControl.KeyShadowSwitch();
				break;
			case KeyEvent.VK_S:
				// S
				this.gameControl.KeyStop();
				break;
			default:
				break;
		}

	}	// end of keyPressed

}
