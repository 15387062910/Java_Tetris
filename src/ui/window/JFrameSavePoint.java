package ui.window;

import javax.swing.*;
import utils.FrameUtil;

public class JFrameSavePoint extends JFrame{
	
	// 确定按钮和取消按钮
	private JButton btnOk = null;
	private JButton btnCancel = null;
	
	public JFrameSavePoint(){
		this.setTitle("保存记录");
		this.setSize(256, 128);
		FrameUtil.setFrameCenter(this);
		
		// TODO test
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		new JFrameSavePoint();
	}
	
}
