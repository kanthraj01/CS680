package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;

class DirectoryTest {

	static LocalDateTime dateTime = LocalDateTime.now();

	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		Directory root = new Directory(null, "root", 0, dateTime);
		Directory applications = new Directory(root, "applications", 0, dateTime);
		Directory home = new Directory(root, "home", 0, dateTime);
		Directory code = new Directory(home, "code", 0, dateTime);
		File a = new File(applications, "a", 1300, dateTime);
		File b = new File(applications, "b", 550, dateTime);
		File c = new File(home, "c", 400, dateTime);
		File d = new File(home, "d", 700, dateTime);
		File e = new File(code, "e", 250, dateTime);
		File f = new File(code, "f", 100, dateTime);

		FileSystem.getFileSystem().addRootDir(root);

	}

	private String[] dirToStringArray(Directory d) {
		Optional<Directory> oD = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), oD.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()) };
		return directorystring;
	}

	@Test
	void testrootDirectoryandFiles() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("home", fs.getRootDirs().get(0).findDir("home").getName());
		assertSame("root", fs.getRootDirs().get(0).findDir("root").getName());
		assertSame("applications", fs.getRootDirs().get(0).findDir("applications").getName());
		assertSame("code", fs.getRootDirs().get(0).findDir("code").getName());
		assertSame("a", fs.getRootDirs().get(0).findFile("a").getName());
		assertSame("f", fs.getRootDirs().get(0).findFile("f").getName());
	}

	@Test
	void test_Directoryandfiles() {
		FileSystem fs = FileSystem.getFileSystem();
		assertTrue(fs.getRootDirs().get(0).findDir("root").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("code").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("a").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("b").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("c").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("d").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("e").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("f").isDirectory());
	}

	@Test
	public void verify_Directory_Code() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", dateTime.toString(), "home", "200", "2" };
		Directory actual = fs.getRootDirs().get(0).findDir("code");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	void testdirectory_filenumbers() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("a", fs.getRootDirs().get(0).findDir("applications").getFiles().get(0).getName());
		assertSame("b", fs.getRootDirs().get(0).findDir("applications").getFiles().get(1).getName());
		assertSame("c", fs.getRootDirs().get(0).findDir("home").getFiles().get(0).getName());
		assertSame("d", fs.getRootDirs().get(0).findDir("home").getFiles().get(1).getName());
		assertSame("e", fs.getRootDirs().get(0).findDir("code").getFiles().get(0).getName());
		assertSame("f", fs.getRootDirs().get(0).findDir("code").getFiles().get(1).getName());
	}

	@Test
	void testsubdirectories_only() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("applications", fs.getRootDirs().get(0).findDir("root").getSubDirectories().get(0).getName());
		assertSame("home", fs.getRootDirs().get(0).findDir("root").getSubDirectories().get(1).getName());
		assertSame("code", fs.getRootDirs().get(0).findDir("home").getSubDirectories().get(0).getName());
	}

	@Test
	void tesforcode_size() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(300, fs.getRootDirs().get(0).findDir("code").getTotalSize());

	}

	@Test
	public void verifyDirectory_EqualityRoot() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", dateTime.toString(), null, "3050", "2" };
		Directory actual = fs.getRootDirs().get(0).findDir("root");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verify_Directory_Home() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", dateTime.toString(), "root", "1400", "3" };
		Directory actual = fs.getRootDirs().get(0).findDir("home");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	void testsubfiles_foldersnumber() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(4, fs.getRootDirs().get(0).findDir("root").countChildren());
		assertEquals(2, fs.getRootDirs().get(0).findDir("applications").countChildren());
		assertEquals(1, fs.getRootDirs().get(0).findDir("home").countChildren());
		assertEquals(3, fs.getRootDirs().get(0).findDir("code").countChildren());
	}

	@Test
	void testfoldersize() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(4300, fs.getRootDirs().get(0).findDir("root").getTotalSize());
		assertEquals(300, fs.getRootDirs().get(0).findDir("code").getTotalSize());
		assertEquals(5400, fs.getRootDirs().get(0).findDir("applications").getTotalSize());
		assertEquals(1200, fs.getRootDirs().get(0).findDir("home").getTotalSize());

	}

	@Test
	void testsize() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(2000, fs.getRootDirs().get(0).findDir("root").getTotalSize());
	}

	@Test
	public void verifyDirectory_Applications() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", dateTime.toString(), "root", "1650", "2" };
		Directory actual = fs.getRootDirs().get(0).findDir("applications");
		assertArrayEquals(expected, dirToStringArray(actual));
	}

}
