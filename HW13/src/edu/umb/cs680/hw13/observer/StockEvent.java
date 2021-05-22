package edu.umb.cs680.hw13.observer;

public class StockEvent {
	private String ticker;
	private float quote;
	
	public StockEvent(String T, float Q) {
		this.ticker = T;
		this.quote = Q;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public float getQuote() {
		return quote;
	}
}
