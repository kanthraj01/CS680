package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;

class AfpsCountingVisitorTest {
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
	public void verifying_VisitorRoot() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.accept(visitor);
		assertEquals(4, visitor.getDirNumber());
		assertEquals(6, visitor.getFileNumber());
		assertEquals(2, visitor.getLinkNumber());
	}

	@Test
	public void verifying_VisitorHome() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		home.accept(visitor);
		assertEquals(2, visitor.getDirNumber());
		assertEquals(4, visitor.getFileNumber());
		assertEquals(2, visitor.getLinkNumber());
	}

	@Test
	public void verifying_VisitorCode() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		code.accept(visitor);
		assertEquals(1, visitor.getDirNumber());
		assertEquals(2, visitor.getFileNumber());
		assertEquals(1, visitor.getLinkNumber());
	}

}
