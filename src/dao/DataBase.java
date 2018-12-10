package dao;

import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.Player;

// 远程数据库访问接口
public class DataBase implements Data {

	// 数据库配置系列:
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URI = "jdbc:mysql://localhost:3306/game_test";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "root";

	// SQL语句(MySQL):
	// 查询前五个最高分的用户名和分数
	private static final String LOAD_SQL = "SELECT user_name, point FROM user_point WHERE game_type = 1 ORDER BY point DESC limit 5";
	// 存储用户名和分数
	private static final String SAVE_SQL = "INSERT INTO user_point(user_name, point, game_type) VALUES (?, ?, ?)";
	
	// 静态构造函数 -> 类加载的时候调用
	static {
		try {
			Class.forName(DRIVER); // 加载类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Player> loadData() {
		Connection conn = null;
		ResultSet rs = null;
		List<Player> players = new ArrayList<Player>();
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PWD);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(LOAD_SQL);
			while(rs.next()){
				players.add(new Player(rs.getString(1), rs.getInt(2)));
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(conn!=null){
					conn.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}

		return players;
	}

	@Override
	public void saveData(Player player) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PWD);
			stmt = conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, player.getName());
			stmt.setObject(2, player.getPoint());
			stmt.setObject(3, 1);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}

	}

}
