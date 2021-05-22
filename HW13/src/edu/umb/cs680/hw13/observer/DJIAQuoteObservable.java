package edu.umb.cs680.hw13.observer;

import java.util.Observable;
@SuppressWarnings("deprecation")
public class DJIAQuoteObservable extends Observable{
    private float quoteObs;

    public void changeQuote(float q) {
        this.quoteObs = q;
        setChanged();
        notifyObservers(new DJIAEvent(quoteObs));
    }

}
