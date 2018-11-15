package ui;

import java.awt.*;
import javax.swing.JPanel;

public class PanelGame extends JPanel {
	/**
	 * 游戏的Panel类 ->	 
	 */
	private static final long serialVersionUID = 1L;
	
	private Lay[] lays = null;
	
	public PanelGame(){
		lays = new Lay[]{
			// 硬编码	是非常不好的开发习惯 
			// 要尽量将数字或字符串直接定义成常量或写入配置文件
			new LayBackground(0, 0, 0, 0),
			new LayDataBase(40, 32, 334, 279),
			new LayDisk(40, 343, 334, 279),
			new LayGame(414, 32, 334, 590),
			new LayButton(788, 32, 334, 124),
			new LayNext(788, 188, 176, 148),
			new LayLevel(964, 188, 158, 148),
			new LayPoint(788, 368, 334, 148),
			new LayAbout(788, 546, 334, 78)
		};
	}
	
	@Override		// 覆盖父类方法
	public void paintComponent(Graphics g){
		// 循环刷新游戏画面
		for(int i=0; i<lays.length; i++){
			// 刷新层窗口
			lays[i].paint(g);
		}
	}
}
