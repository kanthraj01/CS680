package edu.umb.cs680.hw12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {

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

	private String[] dirToStringArray(ApfsDirectory d) {
		String parentName = null;
		ApfsDirectory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = { parentName, Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()),
				d.getOwnerName(), d.getLastModified().toString() };
		return dirInfo;
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
	public void verifyFiles() {
		assertTrue(a.isFile());
		assertTrue(c.isFile());
		assertTrue(b.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}

	@Test
	public void verifyFilesInDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}

	@Test
	public void verifySize() {
		assertEquals(125, root.getTotalSize());
		assertEquals(100, home.getTotalSize());
		assertEquals(25, applications.getTotalSize());
		assertEquals(30, code.getTotalSize());
	}

	@Test
	public void verifyGetChildren() {
		assertEquals(applications, root.getChildren().get(0));
		assertEquals(home, root.getChildren().get(1));
		assertEquals(a, applications.getChildren().get(0));
		assertEquals(b, applications.getChildren().get(1));
		assertEquals(code, home.getChildren().get(0));
		assertEquals(c, home.getChildren().get(1));
		assertEquals(d, home.getChildren().get(2));
		assertEquals(e, code.getChildren().get(0));
		assertEquals(f, code.getChildren().get(1));
	}

	@Test
	public void verifySubDirectory() {
		assertSame("applications", root.getSubDirectories().get(0).getName());
		assertSame("home", root.getSubDirectories().get(1).getName());
		assertSame("code", home.getSubDirectories().get(0).getName());
	}

	@Test
	public void verifyCount() {
		assertEquals(2, root.countChildren());
		assertEquals(2, applications.countChildren());
		assertEquals(4, home.countChildren());
		assertEquals(3, code.countChildren());
	}

	@Test
	public void verifyDirectory_Root() {
		String[] expected = { null, "true", "root", "0", dateTime.toString(), "125", "2", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectory_Home() {
		String[] expected = { "root", "true", "home", "0", dateTime.toString(), "100", "4", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectory_Applications() {
		String[] expected = { "root", "true", "applications", "0", dateTime.toString(), "25", "2", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = applications;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectory_Code() {
		String[] expected = { "home", "true", "code", "0", dateTime.toString(), "30", "3", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = code;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

}
