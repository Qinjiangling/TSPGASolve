package com.ga;

public class City {
	private double x;
	private double y;
	private String name;
	
	public City(){
	}
	
	public City(double x, double y, String name){
		this(x,y);
		this.name = name;
	}
	
	public City(double x, double y){
		this.x = x; this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
