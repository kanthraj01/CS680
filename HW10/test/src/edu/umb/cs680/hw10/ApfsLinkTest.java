package edu.umb.cs680.hw10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import edu.umb.cs680.hw10.apfs.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ApfsLinkTest {

	LocalDateTime dateTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 20, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 25, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 200, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 70, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 100, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 0, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 600, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 350, dateTime, "ApfsFile", dateTime, b);

	@Test
	public void verify_Link() {
		assertTrue(x.isLink());
		assertTrue(y.isLink());
	}

	@Test
	public void verify_Size() {
		assertEquals(0, x.getSize());
		assertEquals(0, y.getSize());
	}

	@Test
	public void verify_LinksIn_Directory() {
		assertSame("x", home.getLinks().get(0).getName());
		assertSame("y", code.getLinks().get(0).getName());

	}

	@Test
	public void verify_X() {
		ApfsDirectory expected = applications;
		ApfsElement actual = x.getTarget();
		assertSame(expected, actual);
	}

	@Test
	public void verify_Y() {
		ApfsFile expected = b;
		ApfsElement actual = y.getTarget();
		assertSame(expected, actual);
	}
}
