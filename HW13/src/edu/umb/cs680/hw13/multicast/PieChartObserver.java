package edu.umb.cs680.hw13.multicast;

public class PieChartObserver implements DJIAQuoteObserver, StockQuoteObserver {
	@Override
	public void updateDJIA(DJIAEvent eventDjia) {

		DJIAEvent de = (DJIAEvent) eventDjia;
		System.out.print("---------------PieChart-------------- ");
		System.out.print("DJIAEvent: " + de.getDjia());
	}

	@Override
	public void updateStock(StockEvent eventStock) {

		StockEvent se = (StockEvent) eventStock;
		System.out.print("---------------PieChart-------------- ");
		System.out.print("StockEvent: " + se.getTicker() + " " + se.getQuote());

	}

}
