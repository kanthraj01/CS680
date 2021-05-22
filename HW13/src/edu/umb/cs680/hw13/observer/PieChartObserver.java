package edu.umb.cs680.hw13.observer;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class PieChartObserver implements Observer {

	public void update(Observable observable, Object object) {
		if (object instanceof StockEvent) {

			StockEvent se = (StockEvent) object;
			System.out.print("---------------PieChart-------------- ");
			System.out.print("StockEvent:" + se.getTicker() + " " + se.getQuote());

		} else if (object instanceof DJIAEvent) {

			DJIAEvent de = (DJIAEvent) object;
			System.out.print("---------------PieChart-------------- ");
			System.out.print("DJIAEvent: " + de.getDjia());
		}
	}

}
