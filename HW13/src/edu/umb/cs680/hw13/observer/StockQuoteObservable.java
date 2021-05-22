package edu.umb.cs680.hw13.observer;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class StockQuoteObservable extends Observable {

	Map<String, Float> map = new HashMap<String, Float>();

	void changeQuote(String t, float q) {
		map.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t, q));
	}

}
