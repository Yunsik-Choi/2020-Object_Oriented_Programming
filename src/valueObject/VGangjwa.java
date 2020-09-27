package valueObject;

public class VGangjwa {

	private String index;
	private String title;
	private String pro;
	private String credit;
	private String time;
	
	public VGangjwa(String temp, String title, String pro, String temp2, String time) {
		this.index = temp;
		this.title = title;
		this.pro = pro;
		this.credit = temp2;
		this.time = time;
	}
	
	public String[] getAll() {
		String[] all = new String[5];
		all[0] = this.index;
		all[1] = this.title;
		all[2] = this.pro;
		all[3] = this.credit;
		all[4] = this.time;
		return all;
	}
	
	public String getIndex() {
		return this.index;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getPro() {
		return this.pro;
	}
	
	public String getCredit(){
		return this.credit;
	}
	
	public String getTime() {
		return this.time;
	}
}
