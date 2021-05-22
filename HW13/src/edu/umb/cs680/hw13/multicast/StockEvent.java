package edu.umb.cs680.hw13.multicast;

public class StockEvent {
	private String ticker;
	private float quote;

	public String getTicker() {
		return ticker;
	}

	public float getQuote() {
		return quote;
	}

	public StockEvent(String T, float Q) {
		this.ticker = T;
		this.quote = Q;
	}
}
