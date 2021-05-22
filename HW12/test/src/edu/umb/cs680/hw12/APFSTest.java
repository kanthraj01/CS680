package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class APFSTest {

	private String[] apfsElement_ToArray(ApfsElement e) {
		String[] elementInfo = { Boolean.toString(e.isDirectory()), e.getName(), Integer.toString(e.getSize()),
				e.getOwnerName() };
		return elementInfo;
	}

	@Test
	public void getRootDir() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsFileSystem.initFileSystem("ApfsFile", 500);
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true", "root", "0", "ApfsFile" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}

	@Test
	public void createDefaultRoot() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true", "root", "0", "ApfsFile" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}
}