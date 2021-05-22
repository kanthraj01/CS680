package edu.umb.cs680.hw07;
import java.time.LocalDateTime;
public class File extends FSElement {
@Override
	public boolean isDirectory() {
		return false;
	}
	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		parent.appendChild(this);
	}
	public static void main(String[] args) {
		System.out.println("Success");
	}
}
