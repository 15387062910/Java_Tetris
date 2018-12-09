package entity;

import java.util.*;
import java.awt.Point;

// 游戏实物
public class GameAct {
	
	// 方块数组
	private Point[] actPoints = null;		// 第一个点为中心点
	
	// 方块类型
	private int typeCode;
	
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	private static final List<Point[]> TYPE_CONFIG;
	
	static{
		// 静态构造函数 
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(3, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(3, 1), new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(4, 1), new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1)});
	}
	
	public GameAct(int typeCode){
		this.init(typeCode);
	}
	
	public void init(int typeCode){
		// 根据actCode的值刷新方块
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for(int i=0; i<points.length; i++){
			actPoints[i] = new Point(points[i].x, points[i].y);
		}
	}
	
	public Point[] getActPoints() {
		return actPoints;
	}
	
	// 方块移动: moveX -> X轴偏移量 	moveY -> Y轴偏移量
	public boolean move(int moveX, int moveY, boolean[][] gameMap){
		// 判断每个点移动后是否越界 如果有点越界就返回false
		for(int i=0; i<actPoints.length; i++){
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverZone(newX, newY, gameMap)){			
				return false;				// 越界不能移动		
			}
		
		}
		
		// 修改每个点移动后的坐标
		for(int i=0; i<actPoints.length; i++){
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		
		return true;
	}
	
	// 方块旋转
	/*
	        顺时针公式:
		  A.x = O.y + O.x - B.y
		  A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] gameMap){
		// 方块是正方形就不用旋转
		if(this.typeCode == 4){
			return;
		}
		// 判断每个点是否越界 如果有点越界就返回
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			if(this.isOverZone(newX, newY, gameMap)){
				return;				// 越界不能旋转
			}
		}
		// 修改每个点旋转后的坐标
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	
	// 判断是否越界
	private boolean isOverZone(int x, int y, boolean[][] gameMap){
		return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];
	}
	
	// 获得方块类型编号
	public int getTypeCode(){
		return typeCode;
	}
	
}
