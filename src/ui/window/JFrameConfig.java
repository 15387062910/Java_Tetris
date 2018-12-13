package ui.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import utils.FrameUtil;

// 用户设置界面
public class JFrameConfig extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1828559664100342180L;
	// 确定按钮和取消按钮
	private JButton jbOk = new JButton("确定");
	private JButton jbCancel = new JButton("取消");
	
	// 目前代替设置面板中的内容
	private static final String sorry = "正在开发中 目前无法使用设置界面!";
	
	// 创建按钮面板
	private JPanel createButtonPanel(){
		// 创建按钮面板  流式布局
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		// TODO 确认按钮和取消按钮对应的事件  以后修改
		this.jbOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		this.jbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		// 向面板中添加按钮
		jp.add(this.jbOk);
		jp.add(this.jbCancel);
		
		return jp;
	}
	
	// 创建主面板
	private JTabbedPane createMainPanel(){
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("设置", new JTextField(sorry));
		
		return jtp;
	}
	
	public JFrameConfig(){
		// 设置布局
		this.setLayout(new BorderLayout());
		// 添加主界面
		this.add(this.createMainPanel(), BorderLayout.CENTER);
		// 添加按钮
		this.add(this.createButtonPanel(), BorderLayout.SOUTH);
		// 设置不能改变大小
		this.setResizable(false);
		// 设置大小
		this.setSize(600, 360);
		// 居中
		FrameUtil.setFrameCenter(this);
	}

}
