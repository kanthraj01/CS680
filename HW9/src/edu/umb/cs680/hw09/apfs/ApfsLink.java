package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
	private ApfsElement target;

	public boolean isLink() {
		return true;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public ApfsElement getTarget() {
		return this.target;
	}

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime modifiedDate, ApfsElement target) {
		super(parent, name, size, creationTime, ownerName, modifiedDate);
		this.target = target;
		parent.appendChild(this);
	}

}
