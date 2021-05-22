package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor {
	private LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();

	public void visit(ApfsLink link) {
		return;
	}

	public void visit(ApfsFile file) {
		files.add(file);
	}

	public void visit(ApfsDirectory dir) {
		return;
	}

	public LinkedList<ApfsFile> getFiles() {
		return files;

	}
}
