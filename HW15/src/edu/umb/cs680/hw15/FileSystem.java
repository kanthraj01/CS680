package edu.umb.cs680.hw15;

public abstract class FileSystem {
	protected String fileSystemName;
	protected  int capacity;
	protected  int id;
	private FSElement rootDirectory;

	
	protected abstract FSElement createDefaultRoot();
	
	public FSElement initFileSystem(String name, int capacity) {
		this.fileSystemName = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if (root.isDirectory() && capacity > root.getSize()) {
			setRootDir(root);
			this.id = root.hashCode();
			return root;
		} else
			return null;
	}

	public String getFileSystemName() {
		return fileSystemName;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getId() {
		return id;
	}
	
	public FSElement getRootDir() {
		return this.rootDirectory;
	}

	private void setRootDir(FSElement rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

}
