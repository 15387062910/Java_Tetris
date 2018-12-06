package dto;

public class Player {
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
}
