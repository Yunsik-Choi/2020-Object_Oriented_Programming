package valueObject;

import java.io.Serializable;

public class VDirectory implements Serializable{
	private String name;
	private String fileName;
	
	public VDirectory(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}
	
	
}
