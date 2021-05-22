package edu.umb.cs680.hw10;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;

class ApfsFileTest {
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

	private String[] apfs_FiletoStringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), f.getParent().getName(),
				Integer.toString(f.getSize()), f.getCreationTime().toString(), f.getOwnerName(),
				f.getLastModified().toString() };
		return fileInfo;
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
		String[] expected = { "false", "a", "applications", "10", dateTime.toString(), "ApfsFile",
				dateTime.toString() };
		ApfsFile actual = a;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verify_B() {
		String[] expected = { "false", "b", "applications", "15", dateTime.toString(), "ApfsFile",
				dateTime.toString() };
		ApfsFile actual = b;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verify_C() {
		String[] expected = { "false", "c", "home", "20", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = c;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verify_D() {
		String[] expected = { "false", "d", "home", "30", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = d;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verify_E() {
		String[] expected = { "false", "e", "code", "40", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = e;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verify_F() {
		String[] expected = { "false", "f", "code", "50", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = f;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
}
