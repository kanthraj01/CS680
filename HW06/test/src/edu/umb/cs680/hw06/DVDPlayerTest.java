package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {

	DVDPlayer dvd = DVDPlayer.getInstance();

	@Test

	public void DrawerClosedNotPlaying_playButtonPushed() {
		dvd.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvd.getCurrentStateOfDVD());
	}

	@Test
	public void DrawerClosedPlayingPlayButtonPushed_DrawerClosedPlaying() {

		dvd.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvd.getCurrentStateOfDVD());

	}

	@Test
	public void DrawerClosedPlayingOpenCloseButtonPushed_DrawerOpen() {

		dvd.stopButtonPushed();
		dvd.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), dvd.getCurrentStateOfDVD());

	}

	@Test
	public void DrawerOpenPlayButtonPushed_DrawerClosedPlaying() {
		dvd.openCloseButtonPushed();
		dvd.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvd.getCurrentStateOfDVD());
	}

	@Test
	public void DrawerClosedPlayingPlayButtonPushed_PlayButtonPushed() {
		dvd.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvd.getCurrentStateOfDVD());
	}

}
