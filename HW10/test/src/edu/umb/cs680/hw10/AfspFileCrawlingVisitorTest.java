package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;

class AfspFileCrawlingVisitorTest {
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

	@Test
	public void file_Crawling_Code() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		code.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = { e, f };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void file_Crawling_Home() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		home.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = { e, f, c, d };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void file_Crawling_Root() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = { a, b, e, f, c, d };
		assertArrayEquals(expected, actual.toArray());
	}
}
