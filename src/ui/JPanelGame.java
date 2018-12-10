package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// 子Lay和游戏数据对象
	private Lay[] lays = null;
	private GameDto dto = null;
	
	// 开始按钮和设置按钮
	private JButton btnStart;
	private JButton btnConfig;
	
	// 控制器对象
	private GameControl gameControl = null;
	
	private void initLayer(){
		// 初始化层
		lays = new Lay[]{
				// 前两个变量是layer在整个界面的坐标	后面两个变量是layer的宽和高
				new LayBackground(0, 0, 0, 0),
				new LayDataBase(40, 32, 334, 279),
				new LayDisk(40, 343, 334, 279),
				new LayGame(414, 32, 334, 590),
				new LayButton(788, 32, 334, 124),
				new LayNext(788, 188, 176, 116),
				new LayLevel(964, 188, 158, 116),
				new LayPoint(788, 336, 334, 168),
				new LayAbout(788, 536, 334, 88)
			};
		for(Lay lay:lays){
			// 设置游戏数据对象
			lay.setDto(dto);
		}
	}
	
	// 初始化界面组件
	private void initComponet(){
		// 初始化开始按钮和设置按钮
		this.btnStart = new JButton(Img.IMG_START);
		this.btnConfig = new JButton(Img.IMG_CONFIG);
		// 设置开始按钮和设置按钮的初始化位置
		btnStart.setBounds(812, 65, 130, 55);
		btnConfig.setBounds(976, 65, 130, 55);
		// 添加按钮到面板
		this.add(btnStart);
		this.add(btnConfig);
		this.btnConfig.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gameControl.showUserConfig();
			}
		});
	}
	
	public JPanelGame(GameDto dto){
		// 获得dto对象
		this.dto = dto;
		// 设置布局为自动布局
		this.setLayout(null);
		// 初始化组件
		initComponet();
		// 初始化层
		initLayer();
	}
	
	/*
	 * 安装玩家控制器
	 * */
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	
	@Override		
	public void paintComponent(Graphics g){
		// 调用基类方法
		super.paintComponent(g);
		// 遍历lays绘制游戏界面
		for(int i=0; i<lays.length; i++){
			lays[i].paint(g);
		}
		// 返回焦点
		this.requestFocus();
	}
	
	// 设置Panel的游戏控制器对象
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

}
