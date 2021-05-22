package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw09.fs.*;

public class APFS extends FileSystem {

	private static APFS instance = null;
	private ApfsDirectory root;

	public static APFS getAPFSFileSystem() {
		if (instance == null)
			instance = new APFS();
		return instance;
	}

	protected FSElement createDefaultRoot() {
		LocalDateTime dateTime = LocalDateTime.now();
		root = new ApfsDirectory(null, "root", 0, dateTime, "Apfs", dateTime);
		return root;
	}

	public ApfsDirectory getRootDir() {
		return root;
	}
}
