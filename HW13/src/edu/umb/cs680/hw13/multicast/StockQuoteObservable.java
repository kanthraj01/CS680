package edu.umb.cs680.hw13.multicast;

import java.util.ArrayList;
import java.util.List;

public class StockQuoteObservable {
	private boolean changed;
	public List<StockQuoteObserver> obs = new ArrayList<StockQuoteObserver>();

	public void addObserver(StockQuoteObserver observer) {

		this.obs.add(observer);

	}

	public void changeQuote(String T, float Q) {
		setChanged();
		notifyObservers(new StockEvent(T, Q));
	}

	public void notifyObservers(StockEvent eventStock) {
		if (hasChanged()) {
			for (StockQuoteObserver observerQuote : this.obs) {
				observerQuote.updateStock(eventStock);
			}
			clearChanged();
		}
	}

	public void setChanged() {

		this.changed = true;

	}

	public boolean hasChanged() {

		return this.changed;

	}

	public void clearChanged() {

		this.changed = false;

	}

}
