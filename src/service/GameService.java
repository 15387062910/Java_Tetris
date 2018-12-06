package service;

import dto.GameDto;

// 游戏逻辑层
public class GameService {
	// 游戏数据
	private GameDto dto;
	
	public GameService(GameDto dto){
		this.dto = dto;
	}

	public void gameTest() {
		int temp = dto.getNowPoint();
		dto.setNowPoint(temp+1);
	}
}
