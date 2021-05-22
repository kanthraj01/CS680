package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {

	LocalDateTime dateTime = LocalDateTime.now();

	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 760, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 120, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 300, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 400, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 150, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 250, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 340, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 760, dateTime, "ApfsFile", dateTime, b);

	@Test
	public void verifygetSubDirectoriesTest() {
		ApfsDirectory dir = root;
		LinkedList<ApfsDirectory> actual = dir
				.getSubDirectories((ApfsElement o1, ApfsElement o2) -> o2.getName().compareTo(o1.getName()));
		ApfsDirectory[] expected = { home, applications };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void verifygetFilesTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsFile> actual = dir
				.getFiles((ApfsElement o1, ApfsElement o2) -> o2.getName().compareTo(o1.getName()));
		ApfsFile[] expected = { d, c };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void verifyGetChildrenTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsElement> actual = dir
				.getChildren((ApfsElement o1, ApfsElement o2) -> o2.getName().compareTo(o1.getName()));
		ApfsElement[] expected = { x, d, code, c };
		assertArrayEquals(expected, actual.toArray());
	}

}
