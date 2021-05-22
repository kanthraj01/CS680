package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;

class AfpsFileSearchVisitorTest {
	LocalDateTime dateTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, dateTime, "ApfsFile", dateTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, dateTime, "ApfsFile", dateTime);
	ApfsFile a = new ApfsFile(applications, "a", 20, dateTime, "ApfsFile", dateTime);
	ApfsFile b = new ApfsFile(applications, "b", 25, dateTime, "ApfsFile", dateTime);
	ApfsFile c = new ApfsFile(home, "c", 200, dateTime, "ApfsFile", dateTime);
	ApfsFile d = new ApfsFile(home, "d", 70, dateTime, "ApfsFile", dateTime);
	ApfsFile e = new ApfsFile(code, "e", 100, dateTime, "ApfsFile", dateTime);
	ApfsFile f = new ApfsFile(code, "f", 0, dateTime, "ApfsFile", dateTime);
	ApfsLink x = new ApfsLink(home, "x", 600, dateTime, "ApfsFile", dateTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 350, dateTime, "ApfsFile", dateTime, b);

	private String[] file_To_StringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), f.getOwnerName(), f.getLastModified().toString() };
		return fileInfo;
	}

	@Test
	public void verify_File_A() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "a", "100", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("a");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verify_File_B() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "b", "110", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("b");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verify_File_C() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "c", "120", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("c");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verify_File_D() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "d", "130", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("d");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verify_File_E() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "e", "140", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("e");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verify_File_F() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "f", "200", dateTime.toString(), "ApfsFile", dateTime.toString() };
		visitor.setFileName("f");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}
}
