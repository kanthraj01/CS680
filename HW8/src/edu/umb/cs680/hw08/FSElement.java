package edu.umb.cs680.hw08;
import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private Directory parent; 
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	public abstract boolean isDirectory();
	
	
	public int getSize() {
		return size;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public String getName() {
		return name;
	}
	public Directory getParent() {
		return parent;
	}
	public static void main(String[] args) {
		System.out.println("Success");
	}

	
	
	
}
