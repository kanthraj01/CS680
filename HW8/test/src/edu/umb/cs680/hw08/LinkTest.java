package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LinkTest {

	static LocalDateTime dateTime = LocalDateTime.now();

	private String[] fsElement_ToStringArray(FSElement f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), optionalDirectory.isPresent() ? f.getParent().getName() : null };
		return fsElementInfo;
	}

	@SuppressWarnings("unused")
	@BeforeAll
	public static void set_filestructure() {
		Directory root = new Directory(null, "root", 0, dateTime);
		Directory applications = new Directory(root, "applications", 0, dateTime);
		Directory home = new Directory(root, "home", 0, dateTime);
		Directory code = new Directory(home, "code", 0, dateTime);
		File a = new File(applications, "a", 1300, dateTime);
		File b = new File(applications, "b", 1200, dateTime);
		File c = new File(home, "c", 450, dateTime);
		File d = new File(home, "d", 550, dateTime);
		Link x = new Link(home, "x", 200, dateTime, applications);
		File e = new File(code, "e", 650, dateTime);
		File f = new File(code, "f", 220, dateTime);
		Link y = new Link(code, "y", 40, dateTime, b);

		FileSystem.getFileSystem().addRootDir(root);
	}

	@Test
	public void verify_TargetEqualityHome() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", dateTime.toString(), "root" };
		Directory actual = (Directory) fs.getRootDirs().get(0).findLinkByName("x").getTarget();
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}

	@Test
	public void verify_TargetEquality_E() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", dateTime.toString(), "applications" };
		File actual = (File) fs.getRootDirs().get(0).findLinkByName("y").getTarget();
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}
}
