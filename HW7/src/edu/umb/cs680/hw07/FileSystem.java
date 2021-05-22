package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {

	private LinkedList<Directory> directoryroot;
	private static FileSystem instance = null;

	private FileSystem() {
	};

	public static FileSystem getFileSystem() {
		if (instance == null)
			instance = new FileSystem();
		return instance;
	}

	void addRootDir(Directory Rd) {
		directoryroot = new LinkedList<Directory>();
		directoryroot.add(Rd);
	}

	public LinkedList<Directory> getRootDirs() {
		return this.directoryroot;
	}

	public static void main(String[] args) {
		System.out.println("Success");
	}
}
