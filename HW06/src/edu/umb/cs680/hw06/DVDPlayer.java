package edu.umb.cs680.hw06;

public class DVDPlayer {
	private static DVDPlayer instance = null;
	private static State state;

	public DVDPlayer(State s) {
		state = s;
	}

	public static DVDPlayer getInstance() {
		if (instance == null) {
			State s = DrawerClosedNotPlaying.getInstance();
			instance = new DVDPlayer(s);
		}
		return instance;
	}

	public State getCurrentStateOfDVD() {
		return state;
	}

	public void changeState(State s) {
		state = s;
	}

	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}

	public void playButtonPushed() {
		state.playButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void open() {
		System.out.println("Please Wait...Drawer is opening");
	}

	public void close() {
		System.out.println("Please Wait...Drawer is closing");
	}

	public void play() {
		System.out.println("Please Wait...DVD is playing");
	}

	public void stop() {
		System.out.println("Please Wait...DVD stopped playing");
	}

}
