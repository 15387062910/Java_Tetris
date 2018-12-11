package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import service.GameTetris;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args) {
		// main function
		// 数据源
		GameDto dto = new GameDto();
		// 创建游戏面板
		JPanelGame panelGame = new JPanelGame(dto);
		// 创建游戏逻辑块(连接游戏数据源)
		GameService service = new GameTetris(dto);
		// 创建游戏控制器(连接游戏面板和游戏逻辑块)
		GameControl gameControl = new GameControl(panelGame, service);
		// 设置游戏面板的游戏控制器对象
		panelGame.setGameControl(gameControl);
		// 创建玩家控制器(连接游戏控制器)
		PlayerControl control = new PlayerControl(gameControl, dto);
		// 安装玩家控制器
		panelGame.setGameControl(control);
		// 创建游戏窗口 安装游戏面板
		JFrameGame jf = new JFrameGame(panelGame);
	}
}
