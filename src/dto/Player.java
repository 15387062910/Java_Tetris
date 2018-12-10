package dto;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1560262108930690698L;
	private String name;
	private int point;
	
	public Player(String name, int point){
		this.setName(name);
		this.setPoint(point);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	@Override
	public int compareTo(Player pla) {
			
		return pla.point - this.point;
	}
}
