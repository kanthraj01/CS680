package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.apfs.*;

class FileSystemTest {
	LocalDateTime dateTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "Apfs", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "Apfs", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 10, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 150, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 30, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 20, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 40, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 50, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 20, dateTime, "ApfsFile", dateTime, b);

	private String[] dir_ToStringArray(ApfsDirectory d) {
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
	public void verify_DirectoryEqualityRoot() {
		String[] expected = { null, "true", "root", "0", dateTime.toString(), "125", "2", "Apfs", "500", "Apfs",
				dateTime.toString() };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verify_DirectoryEqualityHome() {
		String[] expected = { "root", "true", "home", "0", dateTime.toString(), "100", "4", "Apfs", "500", "Apfs",
				dateTime.toString() };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
}
