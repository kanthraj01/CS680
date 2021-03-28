package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

	private static DrawerClosedPlaying instance = null;

	public static DrawerClosedPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedPlaying();
		return instance;
	}

	@Override
	public void openCloseButtonPushed() {
		dvdPlayer.stop();
		dvdPlayer.open();
		dvdPlayer.changeState(DrawerOpen.getInstance());

	}

	@Override
	public void playButtonPushed() {
		dvdPlayer.play();

	}

	@Override
	public void stopButtonPushed() {
		dvdPlayer.stop();
		dvdPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

}
