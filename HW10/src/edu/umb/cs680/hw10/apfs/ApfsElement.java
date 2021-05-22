package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw10.fs.*;

public abstract class ApfsElement extends FSElement {
	private String ownerName;
	private LocalDateTime lastModified;

	public abstract void accept(ApfsFSVisitor visitor);

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public String getOwnerName() {
		return ownerName;
	}

}
