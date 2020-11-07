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
		nameLabel(" ���̵� "),
		sizeNameText("10"),
		passwordLabel("��й�ȣ"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		noAccountInfo("ȸ�������� �������� �ʽ��ϴ�."),
		loginFailed("���̵� ��й�ȣ�� �ٸ��ϴ�.");
		
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
	
	public enum EDirectory{
		campus("ķ�۽�"),
		college("����"),
		hakgwa("�а�");
		
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
