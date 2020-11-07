package constants;

public class Constants {
	
	public enum EConfiguration{
		rootFileName("root"),
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S");
		
		private String text;
		private EConfiguration(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ELoginDialog{
		width("300"),
		height("200"),
		nameLabel(" 아이디 "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		noAccountInfo("회원정보가 존재하지 않습니다."),
		loginFailed("아이디나 비밀번호가 다릅니다.");
		
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
		width("1000"),
		height("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
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
	
	public enum EDirectory{
		campus("캠퍼스"),
		college("대학"),
		hakgwa("학과");
		
		private String text;
		private EDirectory(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

}
