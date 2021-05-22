package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class ElementComparatorTest {

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

	@Test
	public void verify_getChildrenTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsElement> actual = dir.getChildren(new ElementComparator());
		ApfsElement[] expected = { code, c, d, x };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void verify_getChildrenT_estRoot() {
		ApfsDirectory dir = root;
		LinkedList<ApfsDirectory> actual = dir.getSubDirectories(new ElementComparator());
		ApfsDirectory[] expected = { applications, home };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void GetFile_Testcode() {
		ApfsDirectory dir = code;
		LinkedList<ApfsFile> actual = dir.getFiles(new ElementComparator());
		ApfsFile[] expected = { e, f };
		assertArrayEquals(expected, actual.toArray());
	}

}
