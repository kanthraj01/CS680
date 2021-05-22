package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
	static LocalDateTime dateTime = LocalDateTime.now();

	@SuppressWarnings("unused")
	@BeforeAll
	public static void set_file_structure() {
		Directory root = new Directory(null, "root", 0, dateTime);
		Directory applications = new Directory(root, "applications", 0, dateTime);
		Directory home = new Directory(root, "home", 0, dateTime);
		Directory code = new Directory(home, "code", 0, dateTime);
		File a = new File(applications, "a", 1300, dateTime);
		File b = new File(applications, "b", 550, dateTime);
		File c = new File(home, "c", 500, dateTime);
		File d = new File(home, "d", 700, dateTime);
		Link x = new Link(home, "x", 250, dateTime, applications);
		File e = new File(code, "e", 100, dateTime);
		File f = new File(code, "f", 0, dateTime);
		Link y = new Link(code, "y", 150, dateTime, b);

		FileSystem.getFileSystem().addRootDir(root);

	}

	private String[] fsElement_ToStringArray(Directory d) {
		Optional<Directory> oD = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), oD.isPresent() ? d.getParent().getName() : null,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()) };
		return directorystring;
	}

	@Test
	void testforDirectoryandfiles() {
		FileSystem fs = FileSystem.getFileSystem();
		assertTrue(fs.getRootDirs().get(0).findDirByName("root").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fs.getRootDirs().get(0).findDirByName("code").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("a").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("b").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("c").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("d").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("e").isDirectory());
		assertFalse(fs.getRootDirs().get(0).findFileByName("f").isDirectory());
	}

	@Test
	public void verificationof_Directory_Code() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", dateTime.toString(), "home", "200", "2" };
		Directory actual = fs.getRootDirs().get(0).findDirByName("code");
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}

	@Test
	void testdirectory_fileno() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("a", fs.getRootDirs().get(0).findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", fs.getRootDirs().get(0).findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", fs.getRootDirs().get(0).findDirByName("home").getFiles().get(0).getName());
		assertSame("d", fs.getRootDirs().get(0).findDirByName("home").getFiles().get(1).getName());
		assertSame("e", fs.getRootDirs().get(0).findDirByName("code").getFiles().get(0).getName());
		assertSame("f", fs.getRootDirs().get(0).findDirByName("code").getFiles().get(1).getName());
	}

	@Test
	void test_codesize() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(200, fs.getRootDirs().get(0).findDirByName("code").getTotalSize());

	}

	@Test
	void test_dir_only() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("applications", fs.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", fs.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(1).getName());
		assertSame("code", fs.getRootDirs().get(0).findDirByName("home").getSubDirectories().get(0).getName());
	}

	@Test
	void test_subfiles_folders() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(2, fs.getRootDirs().get(0).findDirByName("root").countChildren());
		assertEquals(2, fs.getRootDirs().get(0).findDirByName("applications").countChildren());
		assertEquals(3, fs.getRootDirs().get(0).findDirByName("home").countChildren());
		assertEquals(2, fs.getRootDirs().get(0).findDirByName("code").countChildren());
	}

	@Test
	public void verify_Directory_Root() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", dateTime.toString(), null, "2000", "2" };
		Directory actual = fs.getRootDirs().get(0).findDirByName("root");
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}

	@Test
	void test_for_rootsize() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(3050, fs.getRootDirs().get(0).findDirByName("root").getTotalSize());
	}

	@Test
	public void verify_Directory_Home() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", dateTime.toString(), "root", "1500", "3" };
		Directory actual = fs.getRootDirs().get(0).findDirByName("home");
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}

	@Test
	void testDirectoryandFile() {
		FileSystem fs = FileSystem.getFileSystem();
		assertSame("home", fs.getRootDirs().get(0).findDirByName("home").getName());
		assertSame("root", fs.getRootDirs().get(0).findDirByName("root").getName());
		assertSame("applications", fs.getRootDirs().get(0).findDirByName("applications").getName());
		assertSame("code", fs.getRootDirs().get(0).findDirByName("code").getName());
		assertSame("a", fs.getRootDirs().get(0).findFileByName("a").getName());
		assertSame("f", fs.getRootDirs().get(0).findFileByName("f").getName());
	}

	@Test
	void testfolder_sizes() {
		FileSystem fs = FileSystem.getFileSystem();
		assertEquals(2000, fs.getRootDirs().get(0).findDirByName("root").getTotalSize());
		assertEquals(100, fs.getRootDirs().get(0).findDirByName("code").getTotalSize());
		assertEquals(1500, fs.getRootDirs().get(0).findDirByName("applications").getTotalSize());
		assertEquals(1700, fs.getRootDirs().get(0).findDirByName("home").getTotalSize());

	}

	@Test
	public void verification_Applications() {
		FileSystem fs = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", dateTime.toString(), "root", "1650", "2" };
		Directory actual = fs.getRootDirs().get(0).findDirByName("applications");
		assertArrayEquals(expected, fsElementToStringArray(actual));
	}

}
