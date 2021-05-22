package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {
	public void accept(ApfsFSVisitor visitor) {
		visitor.visit(this);
	}

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime createdTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, createdTime, ownerName, lastModified);
		parent.appendChild(this);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
	}
}
