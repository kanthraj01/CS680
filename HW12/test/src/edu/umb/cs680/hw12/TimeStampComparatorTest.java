package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class TimeStampComparatorTest {
	LocalDateTime localTime = LocalDateTime.now();
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
	public void GetChildrenRoot_Test() {
		ApfsDirectory dir = root;
		LinkedList<ApfsElement> actual = dir.getChildren(new TimeStampComparator());
		ApfsElement[] expected = { applications, home };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void getSubDirectoriesHome_Test() {
		ApfsDirectory dir = home;
		LinkedList<ApfsDirectory> actual = dir.getSubDirectories(new TimeStampComparator());
		ApfsDirectory[] expected = { code };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void getFilesHome_Test() {
		ApfsDirectory dir = home;
		LinkedList<ApfsFile> actual = dir.getFiles(new TimeStampComparator());
		ApfsFile[] expected = { c, d };
		assertArrayEquals(expected, actual.toArray());
	}

}
