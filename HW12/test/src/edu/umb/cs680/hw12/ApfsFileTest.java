package edu.umb.cs680.hw12;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ApfsFileTest {

	LocalDateTime dateTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 600);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 50, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 330, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 300, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 200, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 35, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 250, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 600, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 20, dateTime, "ApfsFile", dateTime, b);

	private String[] apfsFiletoStringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), f.getParent().getName(),
				Integer.toString(f.getSize()), f.getCreationTime().toString(), f.getOwnerName(),
				f.getLastModified().toString() };
		return fileInfo;
	}

	@Test
	public void verifyFiles() {
		assertTrue(a.isFile());
		assertTrue(c.isFile());
		assertTrue(b.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}

	@Test
	public void verifyFilesByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}

	@Test
	public void verifyA() {
		String[] expected = { "false", "a", "applications", "5", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = a;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verifyB() {
		String[] expected = { "false", "b", "applications", "20", dateTime.toString(), "ApfsFile",
				dateTime.toString() };
		ApfsFile actual = b;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verifyC() {
		String[] expected = { "false", "c", "home", "30", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = c;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verifyD() {
		String[] expected = { "false", "d", "home", "40", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = d;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verifyE() {
		String[] expected = { "false", "e", "code", "15", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = e;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

	@Test
	public void verifyF() {
		String[] expected = { "false", "f", "code", "15", dateTime.toString(), "ApfsFile", dateTime.toString() };
		ApfsFile actual = f;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}

}
