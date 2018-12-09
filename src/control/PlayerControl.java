package control;

import java.awt.event.*;

public class PlayerControl extends KeyAdapter {

	/*
	 * gameControl: 游戏控制器 获取游戏控制器以调用其中的方法
	 */
	private GameControl gameControl;

	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
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
			
			case KeyEvent.VK_T:
				// t键 用于测试
				this.gameControl.test();
			default:
				break;
		}

	}	// end of keyPressed

}
