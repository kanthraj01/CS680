package edu.umb.cs680.hw06;

public class DrawerOpen implements State {

	private static DrawerOpen instance = null;

	public static DrawerOpen getInstance() {
		if (instance == null)
			instance = new DrawerOpen();
		return instance;
	}

	@Override
	public void openCloseButtonPushed() {
		dvdPlayer.close();
		dvdPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void playButtonPushed() {
		dvdPlayer.close();
		dvdPlayer.play();
		dvdPlayer.changeState(DrawerClosedPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		dvdPlayer.stop();

	}

}
