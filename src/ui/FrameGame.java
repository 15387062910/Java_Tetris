package ui;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrameGame extends JFrame{
	/**
	 * 游戏的Frame类 -> 主要设置游戏界面的基本情况
	 */
	private static final long serialVersionUID = 1L;

	// 构造函数
	public FrameGame(){
		// 设置标题
		this.setTitle("Java俄罗斯方块");
		// 设置默认关闭属性(程序结束)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体大小
		this.setSize(1200, 700);
		// 设置不允许用户改变窗口大小
		this.setResizable(false);
		// 设置居中属性 -> 根据不同用户显示器的分辨率来设置
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-this.getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-this.getHeight())/2 - 36;
		this.setLocation(x, y);
		this.setVisible(true);
		// 设置默认Panel
		this.setContentPane(new PanelGame());

	}
}	
