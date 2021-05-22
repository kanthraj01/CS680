package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class FileSystemTest {
	private String[] stringarray_forthedirectory(Directory dir) {
		String[] stringelement = { null, dir.getName(), Integer.toString(dir.getSize()),
				dir.getCreationTime().toString() };
		return stringelement;
	}

	@Test
	void testinginstances() {
		FileSystem firstInstance = FileSystem.getFileSystem();
		FileSystem secondInstance = FileSystem.getFileSystem();
		assertSame(firstInstance, secondInstance);
	}

	@Test
	void testrootdir() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Directory root = new Directory(null, "root", 0, localDateTime);
		String[] expected = { null, "root", "0", localDateTime.toString() };
		FileSystem.getFileSystem().addRootDir(root);
		Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
		assertArrayEquals(expected, stringarray_forthedirectory(actual));
	}
}
