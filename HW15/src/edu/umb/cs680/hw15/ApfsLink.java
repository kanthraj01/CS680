package edu.umb.cs680.hw15;
import java.time.LocalDateTime;
public class ApfsLink extends ApfsElement{
	private ApfsElement target;

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
			String ownerName, LocalDateTime modifiedDate,ApfsElement target) {
		super(parent, name, size, creationTime, ownerName, modifiedDate);
		this.target = target;
		parent.appendChild(this);
	}

	public boolean isLink() {
		return true;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public int getTargetSize() {
		if (target.isDirectory()) {
			return ((ApfsDirectory) target).getTotalSize();
		} else if (target.isLink()) {
			return 0;
		} else {
			return target.getSize();
		}
	}
	public ApfsElement getTarget() {
		return this.target;
	}
}