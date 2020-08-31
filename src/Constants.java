
public class Constants {
	public enum EMainFrame{
		WIDTH(400),
		HEIGHT(600);
		
		private int size;
		
		private EMainFrame(int size) {
			this.size = size;
		}
		public int getSize() {
			return this.size;
		}
	}
	
	public enum EMenuBar{
		FILE("File"),
		EDIT("Edit");
		
		private String text;
		
		private EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu{
		NEW("New"),
		OPEN("Open"),
		SAVE("Save"),
		SAVEAS("Save-As"),
		PRINT("Print"),
		EXIT("Exit");
		
		private String text;
		
		private EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

}
