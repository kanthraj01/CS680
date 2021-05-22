package edu.umb.cs680.hw09;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.apfs.*;

class ApfsFileTest {
	LocalDateTime dateTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 5, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 20, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 30, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 40, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 15, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 15, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 0, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, dateTime, "ApfsFile", dateTime, b);

	private String[] filetoStringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), f.getParent().getName(),
				Integer.toString(f.getSize()), f.getCreationTime().toString(), f.getOwnerName(),
				f.getLastModified().toString() };
		return fileInfo;
	}

	@Test
	public void verify_Directory() {
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(applications.isDirectory());
		assertTrue(code.isDirectory());
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
		assertFalse(f.isDirectory());
	}

	@Test
	public void verify_Files() {
		assertTrue(a.isFile());
		assertTrue(c.isFile());
		assertTrue(b.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}

	@Test
	public void verifyFiles_ByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}

	@Test
	public void verify_A() {
		String[] expected = { "false", "a", "applications", "5", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = a;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	public void verify_B() {
		String[] expected = { "false", "b", "applications", "20", dateTime.toString(), "ApfsFile",
				dateTime.toString() };
		ApfsFile actual = b;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	public void verify_C() {
		String[] expected = { "false", "c", "home", "30", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = c;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	public void verify_D() {
		String[] expected = { "false", "d", "home", "40", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = d;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	public void verify_E() {
		String[] expected = { "false", "e", "code", "15", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = e;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	public void verify_F() {
		String[] expected = { "false", "f", "code", "15", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = f;
		assertArrayEquals(expected, filetoStringArray(actual));
	}
}
