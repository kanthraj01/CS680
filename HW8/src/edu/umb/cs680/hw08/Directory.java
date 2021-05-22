package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

	private LinkedList<FSElement> child;

	public int getTotalSize() {
		int sizetotal = 0;
		for (FSElement s : getChildren()) {
			if (s instanceof Directory)
				sizetotal += ((Directory) s).getTotalSize();
			else
				sizetotal += s.getSize();
		}
		return sizetotal;
	}

	public LinkedList<FSElement> getChildren() {
		return child;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if (parent != null)
			parent.appendChild(this);
	}

	public int countChildren() {
		return getChildren().size() - getLinks().size();
	}

	public void appendChild(FSElement child) {
		if (this.child == null) {
			this.child = new LinkedList<FSElement>();
		}
		this.child.add(child);
	}

	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> listdir = new LinkedList<Directory>();
		for (FSElement s : getChildren()) {
			if (s instanceof Directory)
				listdir.add((Directory) s);
		}
		return listdir;
	}

	public LinkedList<File> getFiles() {
		LinkedList<File> listfile = new LinkedList<File>();
		for (FSElement s : getChildren()) {
			if (s instanceof File)
				listfile.add((File) s);
		}
		return listfile;
	}

	public LinkedList<Link> getLinks() {
		LinkedList<Link> linkList = new LinkedList<Link>();
		for (FSElement element : getChildren()) {
			if (element instanceof Link)
				linkList.add((Link) element);
		}
		return linkList;
	}

	public Directory findDirByName(String dirName) {
		Directory namedirectory = null;
		if (dirName.equals(getName()))
			namedirectory = this;
		else {
			for (Directory dir : getSubDirectories()) {
				if (namedirectory == null) {
					namedirectory = dir.findDirByName(dirName);
					if (dirName.equals(dir.getName())) {
						namedirectory = dir;
						break;
					}
				}
			}
		}
		return namedirectory;
	}

	public Link findLinkByName(String linkName) {
		Link nameoflink = null;
		for (Link l : getLinks()) {
			if (linkName.equals(l.getName()))
				nameoflink = l;
		}
		if (nameoflink == null) {
			for (Directory dir : getSubDirectories()) {
				nameoflink = dir.findLinkByName(linkName);
				if (nameoflink != null)
					break;
			}
		}
		return nameoflink;
	}

	public File findFileByName(String nameoffile) {
		File namedfile = null;
		for (File f : getFiles()) {
			if (nameoffile.equals(f.getName()))
				namedfile = f;
		}
		if (namedfile == null) {
			for (Directory dir : getSubDirectories()) {
				namedfile = dir.findFileByName(nameoffile);
				if (namedfile != null)
					break;
			}
		}
		return namedfile;
	}

	public static void main(String[] args) {
		System.out.println("Success");
	}
}
