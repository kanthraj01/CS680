package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.apfs.*;
import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private ApfsDirectory parent;

	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime createdTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = createdTime;
	}

	public abstract boolean isDirectory();

	public abstract boolean isFile();

	public abstract boolean isLink();

	public void setParent(ApfsDirectory parent) {
		this.parent = parent;

	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public ApfsDirectory getParent() {
		return parent;
	}
}
