package edu.umb.cs680.hw13.multicast;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MulticastTest {

	DJIAQuoteObservable djiaQuoteObservable = new DJIAQuoteObservable();
	PieChartObserver	 pieChartObserver = new PieChartObserver();
	StockQuoteObservable stockQuoteObservable = new StockQuoteObservable();
	TableObserver TableObserver = new TableObserver();
	ThreeDObserver ThreeDObserver = new ThreeDObserver();
	
	@Test
	void verify_dijaQuoteObservable() {
		djiaQuoteObservable.addObserver(pieChartObserver);
		djiaQuoteObservable.addObserver(TableObserver);
		djiaQuoteObservable.addObserver(ThreeDObserver);
        djiaQuoteObservable.changeQuote((float) 70.3);
		djiaQuoteObservable.changeQuote(38);
	}
	
	@Test
	void verify_stockQuoteObservable() {
		stockQuoteObservable.addObserver(pieChartObserver);
		stockQuoteObservable.addObserver(TableObserver);
		stockQuoteObservable.addObserver(ThreeDObserver);
		stockQuoteObservable.changeQuote("Design", 101);
		stockQuoteObservable.changeQuote("programming", 234);
	}
	

}
