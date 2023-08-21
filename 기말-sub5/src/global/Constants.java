package global;

import shape.GRectangle;
import shape.GRoundRectangle;
import shape.GEllipse;
import shape.GGroup;
import shape.GPolygon;
import shape.GLine;
import shape.GQuarterArc;
import shape.GHalfArc;
import shape.GArc;
import java.awt.event.KeyEvent;
import shape.GChord;
import shape.G3QuarterArc;
import shape.GShape;
import shape.GIsoscelesTriangle;
import shape.GRightTriangle;
import shape.GObtuseTriangle;
import shape.GLeftArrow;
import shape.GRightArrow;
import shape.GUpArrow;
import shape.GDownArrow;

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
		select("선택", new GGroup()),
		rectangle("네모", new GRectangle()),
		roundrectangle("둥근네모", new GRoundRectangle()),
		polygon("폴리곤", new GPolygon()),
		ellipse("원", new GEllipse()),
		line("직선", new GLine()),
		arc("호", new GArc()),
		arc1("부채꼴", new GQuarterArc()),
		arc2("반원", new GHalfArc()),
		arc3("3/4원", new G3QuarterArc()),
		chord("현", new GChord()),
		isoscelesTriangle("이등변삼각형", new GIsoscelesTriangle()),
		rightTriangle("직각삼각형", new GRightTriangle()),
		obtuseTriangle("둔각삼각형", new GObtuseTriangle()),
		leftArrow("왼쪽화살표", new GLeftArrow()),
		rightArrow("오른쪽화살표", new GRightArrow()),
		upArrow("위쪽화살표", new GUpArrow()),
		downArrow("아래쪽화살표", new GDownArrow()),
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
	public enum ESelect {
		back("모양선택"),
		;
		private String text;
		private ESelect (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	public enum EShapeType {
		nomal("일반", "normaltypee"),
		round("원형", "roundType"),
		triangle("삼각형","triangleType"),
		rectangle("사각형","rectType"),
		arrow("화살표", "arrowType"),
		special("특수","specialType"),
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
		roundrectangle("둥근네모"),
		ellipse("원"),
		arc("호"),
		arc1("부채꼴"),
		arc2("반원"),
		arc3("3/4원"),
		chord("현"),
		;
		private String text;
		private ERound (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	
	public enum ETriangle {
		isoscelesTriangle("이등변삼각형"),
		rightTriangle("직각삼각형"),
		obtuseTriangle("둔각삼각형"),
		;
		private String text;
		private ETriangle (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	
	public enum ERectangle {
		rectangle("직사각형"),
		;
		private String text;
		private ERectangle (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	public enum ENormal {
		select("선택"),
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
	public enum ESpecial {
		isoscelesTriangle("이등변삼각형"),
		rightTriangle("직각삼각형"),
		obtuseTriangle("둔각삼각형"),
		;
		private String text;
		private ESpecial (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	public enum EArrow {
		leftArrow("왼쪽화살표"),
		rightArrow("오른쪽화살표"),
		upArrow("위쪽화살표"),
		downArrow("아래쪽화살표"),
		;
		private String text;
		private EArrow (String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
}
	public enum EMenu {
		filemenu("파일"),
		editmenu("Edit"),
		selectMenu("선택"),
		colormenu("색 설정");
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
	public enum ESelectMenu {
		selectAll("전체선택", "selectAll",'A', KeyEvent.CTRL_MASK),
		selectClear("선택해제", "selectClear",'A', KeyEvent.ALT_MASK),
		;
		private String text;
		private String method;
		private char shortcut;
		private int hotkey;
		private ESelectMenu (String text, String method, char shortcut, int hotkey) {
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

		public enum EColorMenu {
			eLine("색", "line",'I',KeyEvent.CTRL_MASK), 
			eFill("채우기 색", "fill",'U',KeyEvent.CTRL_MASK);

			private String text;
			private String method;
			private char shortcut;
			private int hotkey;
			private EColorMenu (String text, String method, char shortcut, int hotkey) {
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

}
