package global;

import shape.GRectangle;
import shape.GPolygon;
import shape.GShape;

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
		rectangle("�׸�", new GRectangle()),
		rectangle1("�׸�", new GRectangle()),
		polygon("������", new GPolygon()),
		;
		private String text;
		private GShape shape;
		private EToolBar (String text, GShape shape) {
			this.text = text;
			this.shape = shape;
		}
		public String getText() {
			return this.text;
		}
		public GShape getShape() {
			return this.shape;
		}
	}
	public enum EMenu {
		filemenu("����"),
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
		newItem("���θ����", "nnew"),
		openItem("����", "open"),
		saveItem("����", "save"),
		saveAsItem("�ٸ��̸�����", "saveAs"),
		printItem("�μ��ϱ�", "print"),
		closeItem("�ݱ�", "close"),
		;
		private String text;
		private String method;
		private EFileMenu (String text, String method) {
			this.text = text;
			this.method = method;
		}
		public String getText() {
			return this.text;
		}
		public String getMethod() {
			return this.method;
		}
	}
	
	public enum EEditMenu {
		undo("�ǵ�����", "undo"),
		redo("�ٽý���", "redo"),
		cut("�߶󳻱�", "cut"),
		copy("�����ϱ�", "copy"),
		paste("�ٿ��ֱ�", "paste"),
		group("������", "group"),
		ungroup("������", "ungroup"),
		;
		private String text;
		private String method;
		private EEditMenu (String text, String method) {
			this.text = text;
			this.method = method;
		}
		public String getText() {
			return this.text;
		}
		public String getMethod() {
			return this.method;
		}
	}

}
