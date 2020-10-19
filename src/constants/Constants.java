package constants;

public class Constants {
	
	public enum ELoginDialog{
		width("300"),
		height("200"),
		nameLabel(" ���̵� "),
		sizeNameText("10"),
		passwordLabel("��й�ȣ"),
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
	
	public enum EEDITMenu{
		COPY("����"),
		CUT("�ڸ���"),
		PASTE("�ٿ��ֱ�"),
		DELETE("�����");
		
		private String text;
		
		private EEDITMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

}
