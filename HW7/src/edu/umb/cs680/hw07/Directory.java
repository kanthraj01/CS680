package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
	private LinkedList<FSElement> child;

	public LinkedList<FSElement> getChildren() {
		return child;
	}

	public int getTotalSize() {
		int totalsize = 0;
		for (FSElement fs : getChildren()) {
			if (fs instanceof Directory)
				totalsize += ((Directory) fs).getTotalSize();
			else
				totalsize += fs.getSize();
		}
		return totalsize;
	}

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if (parent != null)
			parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	public void appendChild(FSElement child) {
		if (this.child == null) {
			this.child = new LinkedList<FSElement>();
		}
		this.child.add(child);
	}

	public int countChildren() {
		return getChildren().size();
	}

	public File findFile(String nameoffile) {
		File filen = null;
		for (File f : getFiles()) {
			if (nameoffile.equals(f.getName()))
				filen = f;
		}
		if (filen == null) {
			for (Directory dir : getSubDirectories()) {
				filen = dir.findFile(nameoffile);
				if (filen != null)
					break;
			}
		}
		return filen;
	}

	public Directory findDir(String dirName) {
		Directory directoryname = null;
		if (dirName.equals(getName()))
			directoryname = this;
		else {
			for (Directory dir : getSubDirectories()) {
				if (directoryname == null) {
					directoryname = dir.findDir(dirName);
					if (dirName.equals(dir.getName())) {
						directoryname = dir;
						break;
					}
				}
			}
		}
		return directoryname;
	}

	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> directorylist = new LinkedList<Directory>();
		for (FSElement s : getChildren()) {
			if (s instanceof Directory)
				directorylist.add((Directory) s);
		}
		return directorylist;
	}

	public LinkedList<File> getFiles() {
		LinkedList<File> filelist = new LinkedList<File>();
		for (FSElement s : getChildren()) {
			if (s instanceof File)
				filelist.add((File) s);
		}
		return filelist;
	}

	public static void main(String[] args) {
		System.out.println("Success.");
	}

}
