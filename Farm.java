package application;

public class Farm {
	private int id;
	private int year;
	private int month;
	private int day;
	private double weight;
	private double totalWeight;
	private double percentWeight;
	
	public Farm(String id, String year, String month, String day, String weight) {
		this.id = Integer.parseInt(id);
		this.year = Integer.parseInt(year);
		this.month = Integer.parseInt(month);
		this.day = Integer.parseInt(day);
		this.weight = Double.parseDouble(weight);
	}
	
	public int getID() {
		return id;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public void setPercentageTotalWeight(double percentWeight) {
		this.percentWeight = percentWeight;
	}
	
	public double getPercentTotalWeight() {
		return percentWeight;
	}
}

