package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw09.fs.*;

public abstract class ApfsElement extends FSElement {

	private String ownerName;
	private LocalDateTime lastModified;

	public String getOwnerName() {
		return ownerName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}

}
