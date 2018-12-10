package utils;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

// Frame的一些工具方法
public class FrameUtil {
	private FrameUtil(){}
	
	// 设置界面居中
	public static void setFrameCenter(JFrame jf){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (int)(screen.getWidth()-jf.getWidth())/2;
		int y = (int)(screen.getHeight()-jf.getHeight())/2 - 36;
		jf.setLocation(x, y);
	}
}
