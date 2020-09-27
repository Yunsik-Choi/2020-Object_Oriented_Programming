package valueObject;

public class VHakgwa {

	private int index;
	private String title;
	private String file;
	
	public VHakgwa(int index,String title, String file) {
		this.index = index;
		this.title = title;
		this.file = file;
	}
	
	public int getIndex(){
		return index;
		}
	
	public String getTitle() {
		return title;
	}
	
	public String getFile() {
		return file;
		
	}
}
