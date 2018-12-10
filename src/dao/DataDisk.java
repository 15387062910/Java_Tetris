package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;
import java.io.*;

// 本地磁盘数据访问接口
public class DataDisk implements Data {

	// 本地数据存放的路径
	private static String FILE_PATH = "data/recode.dat";
	
	// 读取文件字符串并返回
	@SuppressWarnings("deprecation")
	private static String readFile(){
		String res = "";
		try {
			FileInputStream fs_in = new FileInputStream(FILE_PATH);
			DataInputStream in = new DataInputStream(fs_in);
			res = in.readLine();
		} catch (FileNotFoundException fe) {
			System.err.println(fe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		
		return res;
	}
	
	private static List<Player> handleData(String str) {
		// 对读取的数据进行相应处理
		if (str == null) {
			return null;
		}
		List<Player> players = new ArrayList<Player>();
		// System.out.println(str);
		String[] res = str.split("&");
		for (int i = 0; i < res.length; i++) {
			String[] temp = res[i].split("-");
			players.add(new Player(temp[0], Integer.parseInt(temp[1])));
		}

		return players;
	}

	@Override
	public List<Player> loadData() {
		List<Player> players = null;
		try {
			FileInputStream fs_in = new FileInputStream(FILE_PATH);
			DataInputStream in = new DataInputStream(fs_in);
			@SuppressWarnings("deprecation")
			String res = in.readLine();
			players = handleData(res);

		} catch (FileNotFoundException fe) {
			System.err.println(fe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}

		return players;
	}

	@Override
	public void saveData(Player pla) {
		String res = "";
		try {
			// 读取之前存的数据
			String content = readFile();
			System.out.println(content);
			// 把之前存的数据和这次的数据一起存进去
			FileOutputStream fs_out = new FileOutputStream(FILE_PATH);
			DataOutputStream out = new DataOutputStream(fs_out);
			res += (content+"&");
			res += (pla.getName() + "-" + pla.getPoint());
			out.writeBytes(res);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
