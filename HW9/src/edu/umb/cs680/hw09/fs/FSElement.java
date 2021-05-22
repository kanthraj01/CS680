package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.apfs.*;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime createdTime;
	private ApfsDirectory parent;

	public abstract boolean isDirectory();

	public abstract boolean isLink();

	public abstract boolean isFile();

	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime createdTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.createdTime = createdTime;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreationTime() {
		return createdTime;
	}

	public ApfsDirectory getParent() {
		return parent;
	}

	public int getSize() {
		return size;
	}

	public void setParent(ApfsDirectory parent) {
		this.parent = parent;

	}
}
