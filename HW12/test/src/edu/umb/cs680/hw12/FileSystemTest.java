package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileSystemTest {

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

	private String[] apfsDirToStringArray(ApfsDirectory d) {
		String parentName = null;
		ApfsDirectory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = { parentName, Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()),
				ApfsFileSystem.getFileSystemName(), Integer.toString(ApfsFileSystem.getCapacity()), d.getOwnerName(),
				d.getLastModified().toString() };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEquality_Root() {
		String[] expected = { null, "true", "root", "0", dateTime.toString(), "165", "2", "Apfs", "500", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, apfsDirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEquality_Home() {
		String[] expected = { "root", "true", "home", "0", dateTime.toString(), "140", "4", "Apfs", "500", "ApfsFile",
				dateTime.toString() };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, apfsDirToStringArray(actual));
	}

}
