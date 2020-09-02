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
		FILE("����"),
		EDIT("����");
		
		private String text;
		
		private EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu{
		NEW("����"),
		OPEN("����"),
		SAVE("����"),
		SAVEAS("�ٸ��̸����� ����"),
		PRINT("�μ�"),
		EXIT("����");
		
		private String text;
		
		private EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu{
		COPY("����"),
		CUT("�ڸ���"),
		PASTE("�ٿ��ֱ�"),
		DELETE("�����");
		
		private String text;
		
		private EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EToolButton{
		APPLICATION("������û","images/Application.png"),
		PUT("�̸����","images/Put.png"),
		PERSONALINFO("��������","images/PersonalInfo.png"),
		GRADE("����","images/Grade.png");
		
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