package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;

class APFSTest {
	private String[] apfs_ElementToArray(ApfsElement e) {
		String[] elementInfo = { Boolean.toString(e.isDirectory()), e.getName(), Integer.toString(e.getSize()),
				e.getOwnerName() };
		return elementInfo;
	}

	@Test
	public void getRootDir_Test() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsFileSystem.initFileSystem("ApfsFile", 500);
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true", "root", "0", "ApfsFile" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}

	@Test
	public void sameAPFS_Test() {
		APFS APFSOne = APFS.getAPFSFileSystem();
		APFS APFSTwo = APFS.getAPFSFileSystem();
		assertSame(APFSOne, APFSTwo);
	}

	@Test
	public void createDefaultRoot_Test() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true", "root", "0", "ApfsFile" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}
}
