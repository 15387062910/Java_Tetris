package ui.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import utils.FrameUtil;

public class JFrameSavePoint extends JFrame{
	
	//
	private JLabel lbPoint;
	
	// 名字输入框
	private JTextField txtName = null;
	
	// 确定按钮和取消按钮
	private JButton btnOk = null;
	private JButton btnCancel = null;
	
	// 初始化界面
	private void init(){
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.lbPoint = new JLabel("您的得分: 128");
		north.add(lbPoint);
		this.add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.txtName = new JTextField();
		// TODO 设置最大长度
		center.add(new JLabel("请输入您的姓名: "));
		center.add(this.txtName);
		this.add(center, BorderLayout.CENTER);
		
		this.btnOk = new JButton("确定");
		this.btnCancel = new JButton("取消");
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south.add(btnOk);
		south.add(btnCancel);
		this.add(south, BorderLayout.SOUTH);
	}
	
	public JFrameSavePoint(){
		this.setTitle("保存记录");
		this.setSize(256, 128);
		FrameUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.init();
		
		// TODO test
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		new JFrameSavePoint();
	}
	
}
