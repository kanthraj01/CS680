package edu.umb.cs680.hw15;
import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private ApfsDirectory parent; 
	public abstract boolean isDirectory();
	public abstract boolean isLink();
	public abstract boolean isFile();
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime createdTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = createdTime;
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
	public void setParent(ApfsDirectory parent) {
		this.parent = parent;
	
	}
}
