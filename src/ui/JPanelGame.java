package ui;

import java.awt.*;
import javax.swing.JPanel;

import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Lay[] lays = null;
	private GameDto dto = null;
	
	private void initLayer(){
		// 初始化层
		lays = new Lay[]{
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
		for(Lay lay:lays){
			// 设置游戏数据对象
			lay.setDto(dto);
		}
	}

	private void initComponet(){
		
	}
	
	public JPanelGame(GameDto dto){
		// 获得dto对象
		this.dto = dto;
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
}
