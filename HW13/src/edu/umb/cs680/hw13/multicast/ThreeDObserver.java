package edu.umb.cs680.hw13.multicast;

public class ThreeDObserver implements DJIAQuoteObserver, StockQuoteObserver {

	@Override
	public void updateDJIA(DJIAEvent eventDjia) {
		DJIAEvent event = (DJIAEvent) eventDjia;
		System.out.print("----------------ThreeD-Observer-------------");
		System.out.print("DJIAEvent: " + event.getDjia());
	}

	@Override
	public void updateStock(StockEvent eventStock) {
		StockEvent event = (StockEvent) eventStock;
		System.out.print("----------------Three-Observer-------------");
		System.out.print("StockEvent: " + event.getTicker() + " " + event.getQuote());

	}

}
