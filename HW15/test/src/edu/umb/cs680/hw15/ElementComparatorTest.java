package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class ElementComparatorTest {

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
	public void getChildrenCodeTest() {
		ApfsDirectory dir = code;
		LinkedList<ApfsElement> actual = dir.getChildren(
				(ApfsElement obj1, ApfsElement obj2) -> obj1.getOwnerName().compareTo(obj2.getOwnerName()));
		ApfsElement[] expected = { e, f, y };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void getSubDirectoryRootTest() {
		ApfsDirectory dir = root;
		LinkedList<ApfsDirectory> actual = dir.getSubDirectories(
				(ApfsElement obj1, ApfsElement obj2) -> obj1.getOwnerName().compareTo(obj2.getOwnerName()));
		ApfsDirectory[] expected = { applications, home };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void getFilesHomeTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsFile> actual = dir
				.getFiles((ApfsElement obj1, ApfsElement obj2) -> obj1.getOwnerName().compareTo(obj2.getOwnerName()));
		ApfsFile[] expected = { c, d };
		assertArrayEquals(expected, actual.toArray());
	}

}
