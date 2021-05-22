package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;

class FileTest {

	private String[] stringarray_tocompare(File f) {
		Optional<Directory> oD = Optional.ofNullable(f.getParent());
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), oD.isPresent() ? f.getParent().getName() : null };
		return fileInfo;
	}

	static LocalDateTime dateTime = LocalDateTime.now();

	@SuppressWarnings("unused")
	@BeforeAll
	public static void directory_filecreation() {
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

	@Test
	public void verify_A() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "a", "1300", dateTime.toString(), "applications" };
		File actual = fs.getRootDirs().get(0).findFile("a");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_B() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", dateTime.toString(), "applications" };
		File actual = fs.getRootDirs().get(0).findFile("b");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_C() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "c", "500", dateTime.toString(), "home" };
		File actual = fs.getRootDirs().get(0).findFile("c");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_E() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "e", "70", dateTime.toString(), "code" };
		File actual = fs.getRootDirs().get(0).findFile("e");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	void Test_for_Directory() {
		FileSystem fs = FileSystem.getFileSystem();
		assertTrue(fs.getRootDirs().get(0).findDir("root").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("applications").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDir("code").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("a").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("b").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("c").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("d").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("e").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFile("f").isDirectory());
	}

	@Test
	void TestforDirectoryroot() {
		FileSystem fs = FileSystem.getFileSystem();
		assertTrue(fs.getRootDirs().get(0).findDir("root").isDirectory());
	}

}
