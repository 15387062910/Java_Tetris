package ui.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.GameControl;

import utils.FrameUtil;

public class JFrameSavePoint extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 分数
	private JLabel lbPoint;
	
	// 名字输入框
	private JTextField txtName = null;
	
	// 确定按钮和取消按钮
	private JButton btnOk = null;
	private JButton btnCancel = null;
	
	// 错误提示信息
	private JLabel errMsg = null;
	
	// 游戏控制器
	private GameControl gameControl;
	
	// 显示窗口
	public void show(int point){
		this.lbPoint.setText("您的得分: " + point);
		this.setVisible(true);
	}
	
	// 初始化界面
	private void init(){
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.lbPoint = new JLabel();
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		north.add(this.lbPoint); 
		north.add(this.errMsg);
		this.add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.txtName = new JTextField(10);
		// TODO 设置姓名能填入的最大长度
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
	
	// 事件监听
	private void createAction(){
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				if(name.length() > 16 || name == null || "".equals(name)){
					errMsg.setText("名字输入错误");
				} else{
					setVisible(false);
					gameControl.savePoint(name);
				}
			}
		});
		
		this.btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
	
	public JFrameSavePoint(GameControl gameControl){
		this.gameControl = gameControl;
		this.setTitle("保存记录");
		this.setSize(256, 128);
		FrameUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.init();
		this.createAction();
		
	
	}
	
}
