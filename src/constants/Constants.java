package constants;

public class Constants {
	
	public enum ELoginDialog{
		width("300"),
		height("200"),
		nameLabel(" 아이디 "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum EMainFrame{
		WIDTH(1000),
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
		FILE("파일"),
		EDIT("편집");
		
		private String text;
		
		private EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu{
		NEW("생성"),
		OPEN("열기"),
		SAVE("저장"),
		SAVEAS("다른이름으로 저장"),
		PRINT("인쇄"),
		EXIT("종료");
		
		private String text;
		
		private EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEDITMenu{
		COPY("복사"),
		CUT("자르기"),
		PASTE("붙여넣기"),
		DELETE("지우기");
		
		private String text;
		
		private EEDITMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

}
