package edu.umb.cs680.hw13.observer;

public class DJIAEvent {
	
	private float eventDjia;

	public float getDjia() {
		return eventDjia;
	}

	public DJIAEvent(float djiaEvent) {
		this.eventDjia = djiaEvent;
	}

	public void setDjia(float djiaEvent) {
		this.eventDjia = djiaEvent;
	}
}
