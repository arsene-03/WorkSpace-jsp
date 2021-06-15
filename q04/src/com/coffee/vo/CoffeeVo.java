package com.coffee.vo;

public class CoffeeVo {
	
	private String coffeeName;
	private String coffeeType;
	private int coffeePrice;
	private int coffeeCount;
	
	
	
	
	public CoffeeVo(String coffeeName, String coffeeType, int coffeePrice, int coffeeCount) {
		this.coffeeName = coffeeName;
		this.coffeeType = coffeeType;
		this.coffeePrice = coffeePrice;
		this.coffeeCount = coffeeCount;
	}
	public int getCoffeeCount() {
		return coffeeCount;
	}
	public void setCoffeeCount(int coffeeCount) {
		this.coffeeCount = coffeeCount;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getCoffeeType() {
		return coffeeType;
	}
	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}
	public int getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	
	
}
