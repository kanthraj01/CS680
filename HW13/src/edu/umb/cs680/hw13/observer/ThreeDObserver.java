package edu.umb.cs680.hw13.observer;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ThreeDObserver implements Observer {

	public void update(Observable o, Object obj) {
		if (obj instanceof StockEvent) {
			StockEvent SE = (StockEvent) obj;
			System.out.print("---------------3DChart-------------- ");
			System.out.print("3D of StockEvent: " + SE.getTicker() + " " + SE.getQuote());
		} else if (obj instanceof DJIAEvent) {
			DJIAEvent dE = (DJIAEvent) obj;
			System.out.print("---------------3DChart-------------- ");
			System.out.print("3D of DJIAEvent: " + dE.getDjia());
		}
	}
}
