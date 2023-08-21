package global;

public class Constants {

	public enum EMainFrame {
		x(200),
		y(100),
		w(400),
		h(600)
		;
		private int value;
		private EMainFrame (int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	public enum EToolBar {
		select("선택"),
		rectangle("네모"),
		ellipse("동그라미"),
		line("라인"),
		;
		private String text;
		private EToolBar (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EMenu {
		filemenu("파일"),
		editmenu("Edit"),
		;
		private String text;
		private EMenu (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EFileMenu {
		newItem("새로만들기"),
		openItem("open"),
		;
		private String text;
		private EFileMenu (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

}
