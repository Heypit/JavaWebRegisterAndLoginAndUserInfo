package cn.dz.user.domain;

public class Cost {
	private int food;
	private int transportation;
	private int others;
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getTransportation() {
		return transportation;
	}
	public void setTransportation(int transportation) {
		this.transportation = transportation;
	}
	public int getOthers() {
		return others;
	}
	public void setOthers(int others) {
		this.others = others;
	}
	@Override
	public String toString() {
		return "Cost [food=" + food + ", transportation=" + transportation + ", others=" + others + "]";
	}
	
}
