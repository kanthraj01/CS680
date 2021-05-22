package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class FileSystemTest {

	private String[] stringarray_directory(Directory dir) {
		String[] stringelement = { null, dir.getName(), Integer.toString(dir.getSize()),
				dir.getCreationTime().toString() };
		return stringelement;
	}

	@Test
	void testinginstances_created() {
		FileSystem Instance_1 = FileSystem.getFileSystem();
		FileSystem Instance_2 = FileSystem.getFileSystem();
		assertSame(Instance_1, Instance_2);
	}

	@Test
	void testtheroot_dir() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Directory root = new Directory(null, "root", 0, localDateTime);
		String[] expected = { null, "root", "0", localDateTime.toString() };
		FileSystem.getFileSystem().addRootDir(root);
		Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
		assertArrayEquals(expected, stringarray_directory(actual));
	}
}
