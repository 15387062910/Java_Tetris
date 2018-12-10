package dao;

import java.util.*;

import dto.Player;

public class DataTest implements Data {

	@Override
	public List<Player> loadData() {
		// TODO Auto-generated method stub
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("xxx", 400));
		players.add(new Player("wyb", 500));
		players.add(new Player("xxx", 600));
		players.add(new Player("wyb", 800));
		return players;
	}

	@Override
	public void saveData(Player players) {
		// TODO Auto-generated method stub
		System.out.println("in DataTest saveData!");
	}
	
}
