package utils;

// 游戏用到的工具函数
public class GameFunction {
	private GameFunction() {
	}

	public static long getSleepTimeByLevel(int level) {
		long sleep = (-40 * level + 780);
		sleep = sleep < 100 ? 100 : sleep;
		
		return sleep;
	}

}
