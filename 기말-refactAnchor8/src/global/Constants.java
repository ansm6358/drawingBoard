package global;

import shape.GRectangle;
import shape.GRoundRectangle;
import shape.GEllipse;
import shape.GPolygon;
import shape.GLine;
import shape.GQuarterArc;
import shape.GHalfArc;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import shape.G3QuarterArc;
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
		roundrectangle("�ձٳ׸�", new GRoundRectangle()),
		polygon("������", new GPolygon()),
		ellipse("��", new GEllipse()),
		line("����", new GLine()),
		arc("��ä��", new GQuarterArc()),
		arc2("�ݿ�", new GHalfArc()),
		arc3("3/4��", new G3QuarterArc()),
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
		newItem("���θ����", "nnew",'N', KeyEvent.CTRL_MASK),  //a,n  a,o c,s a,v a,p a,x
		openItem("����", "open",'O', KeyEvent.CTRL_MASK),
		saveItem("����", "save",'S', KeyEvent.CTRL_MASK),
		saveAsItem("�ٸ��̸�����", "saveAs",'V', KeyEvent.ALT_MASK),
		printItem("�μ��ϱ�", "print",'P', KeyEvent.ALT_MASK),
		closeItem("�ݱ�", "close", 'X', KeyEvent.ALT_MASK),
		;
		private String text;
		private String method;
		private char shortcut;
		private int hotkey;
		private EFileMenu (String text, String method, char shortcut, int hotkey) {
			this.text = text;
			this.method = method;
			this.shortcut = shortcut;
			this.hotkey = hotkey;
		}
		public String getText() {
			return this.text;
		}
		public String getMethod() {
			return this.method;
		}
		public char getShortcut() {
			return this.shortcut;
		}
		public int getHotkey() {
			return this.hotkey;
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
		public enum EShapeType {
			nomal("�Ϲ�", "normaltypee"),
			round("����", "roundType"),
			;
			private String text;
			private String method;
			private EShapeType (String text, String method) {
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
		public enum ERound {
			roundrectangle("�ձٳ׸�", new GRoundRectangle()),
			ellipse("��", new GEllipse()),
			arc("��ä��", new GQuarterArc()),
			arc2("�ݿ�", new GHalfArc()),
			arc3("3/4��", new G3QuarterArc()),
			;
			private String text;
			private GShape shape;
			private ERound (String text, GShape shape) {
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
		
		public enum ENormal {
			rectangle("�׸�"),
			polygon("������"),
			ellipse("��"),
			line("����"),
			;
			private String text;
			private ENormal (String text) {
				this.text = text;
			}
			public String getText() {
				return this.text;
			}

	}
}
