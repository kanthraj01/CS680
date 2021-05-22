package edu.umb.cs680.hw13.multicast;
import java.util.ArrayList;
import java.util.List;

public class DJIAQuoteObservable {
	private boolean changed;
	public List<DJIAQuoteObserver> obs = new ArrayList<DJIAQuoteObserver>();
	

	public void addObserver(DJIAQuoteObserver quoteObserver) {
		this.obs.add(quoteObserver);
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
	public void changeQuote(float cq) {
		setChanged();
		notifyObservers(new DJIAEvent(cq));
	}

	public void notifyObservers(DJIAEvent eventDjia) {
		if (hasChanged()) {
			for (DJIAQuoteObserver event: this.obs) {
				event.updateDJIA(eventDjia);
			}
			clearChanged();
		}
	}
}
