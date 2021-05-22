package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTest {
	private String[] stringarray_tocompare(File f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optionalDirectory.isPresent() ? f.getParent().getName() : null };
		return fileInfo;
	}

	static LocalDateTime dateTime = LocalDateTime.now();

	@SuppressWarnings("unused")
	@BeforeAll
	public static void set_filestructure() {
		Directory root = new Directory(null, "root", 0, dateTime);
		Directory applications = new Directory(root, "applications", 0, dateTime);
		Directory home = new Directory(root, "home", 0, dateTime);
		Directory code = new Directory(home, "code", 0, dateTime);
		File a = new File(applications, "a", 1300, dateTime);
		File b = new File(applications, "b", 350, dateTime);
		File c = new File(home, "c", 500, dateTime);
		File d = new File(home, "d", 700, dateTime);
		Link x = new Link(home, "x", 0, dateTime, applications);
		File e = new File(code, "e", 70, dateTime);
		File f = new File(code, "f", 130, dateTime);
		Link y = new Link(code, "y", 0, dateTime, b);
		// creating files and addding the root directory
		FileSystem.getFileSystem().addRootDir(root);
	}

	@Test
	public void verify_A() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "a", "1300", dateTime.toString(), "applications" };
		File actual = fs.getRootDirs().get(0).findFileByName("a");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_B() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", dateTime.toString(), "applications" };
		File actual = fs.getRootDirs().get(0).findFileByName("b");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_C() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "c", "500", dateTime.toString(), "home" };
		File actual = fs.getRootDirs().get(0).findFileByName("c");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	public void verify_F() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "f", "130", dateTime.toString(), "code" };
		File actual = fs.getRootDirs().get(0).findFileByName("f");
		assertArrayEquals(expected, stringarraytocompare(actual));
	}

	@Test
	void Testfor_Directory() {
		FileSystem fs = FileSystem.getFileSystem();
		assertTrue(fs.getRootDirs().get(0).findDirByName("root").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("applications").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("code").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("a").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("b").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("c").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("d").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("e").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("f").isDirectory());
	}

}
