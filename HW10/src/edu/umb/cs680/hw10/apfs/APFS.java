package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw10.fs.*;

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
		root = new ApfsDirectory(null, "root", 0, dateTime, "ApfsFile", dateTime);
		return root;
	}

	public ApfsDirectory getRootDir() {
		return root;
	}

}
