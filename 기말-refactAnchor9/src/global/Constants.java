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
		rectangle("네모", new GRectangle()),
		roundrectangle("둥근네모", new GRoundRectangle()),
		polygon("폴리곤", new GPolygon()),
		ellipse("원", new GEllipse()),
		line("직선", new GLine()),
		arc("부채꼴", new GQuarterArc()),
		arc2("반원", new GHalfArc()),
		arc3("3/4원", new G3QuarterArc()),
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
		newItem("새로만들기", "nnew",'N', KeyEvent.CTRL_MASK),  //a,n  a,o c,s a,v a,p a,x
		openItem("열기", "open",'O', KeyEvent.CTRL_MASK),
		saveItem("저장", "save",'S', KeyEvent.CTRL_MASK),
		saveAsItem("다른이름으로", "saveAs",'V', KeyEvent.ALT_MASK),
		printItem("인쇄하기", "print",'P', KeyEvent.ALT_MASK),
		closeItem("닫기", "close", 'X', KeyEvent.ALT_MASK),
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
		undo("되돌리기", "undo",'Z', KeyEvent.CTRL_MASK),
		redo("다시실행", "redo",'Z', KeyEvent.ALT_MASK),
		cut("잘라내기", "cut",'X', KeyEvent.CTRL_MASK),
		copy("복사하기", "copy",'C', KeyEvent.CTRL_MASK),
		paste("붙여넣기", "paste",'V', KeyEvent.CTRL_MASK),
		group("모으기", "group",'G', KeyEvent.CTRL_MASK),
		ungroup("나누기", "ungroup",'G', KeyEvent.ALT_MASK),
		;
		private String text;
		private String method;
		private char shortcut;
		private int hotkey;
		private EEditMenu (String text, String method, char shortcut, int hotkey) {
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
		public enum EShapeType {
			nomal("일반", "normaltypee"),
			round("원형", "roundType"),
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
			back("모양선택"),
			roundrectangle("둥근네모"),
			ellipse("원"),
			arc("부채꼴"),
			arc2("반원"),
			arc3("3/4원"),
			;
			private String text;
			private ERound (String text) {
				this.text = text;
			}
			public String getText() {
				return this.text;
			}
	}
		
		public enum ENormal {
			back("모양선택"),
			rectangle("네모"),
			polygon("폴리곤"),
			ellipse("원"),
			line("직선"),
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
