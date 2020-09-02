import javax.swing.ImageIcon;
import javax.swing.JButton;

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
	
	public enum EEditMenu{
		COPY("복사"),
		CUT("자르기"),
		PASTE("붙여넣기"),
		DELETE("지우기");
		
		private String text;
		
		private EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EToolButton{
		APPLICATION("수강신청","images/Application.png"),
		PUT("미리담기","images/Put.png"),
		PERSONALINFO("개인정보","images/PersonalInfo.png"),
		GRADE("성적","images/Grade.png");
		
		private String title;
		private String src;
		
		private EToolButton(String title,String src) {
			this.title = title;
			this.src = src;
		}
		
		public String getTitle() {
			return this.title;
		}
		
		public String getSrc() {
			return this.src;
		}
	}

}
