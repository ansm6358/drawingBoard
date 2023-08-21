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
import shape.GIsoscelesTrapezoid;
import shape.GTrapezoid;
import shape.GParallelogram;
import shape.GRhombus;
import shape.GStar;
import shape.GDagger;
import shape.GCross;
import shape.GSquare;
import shape.GRegularTriangle;
import shape.GPentagon;
import shape.GHexagon;
import shape.GRegularHexagon;
import shape.GRegularPentagon;
import shape.GStarOfDavid;

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
		rectangle("직사각형", new GRectangle()),
		roundrectangle("둥근네모", new GRoundRectangle()),
		polygon("폴리곤", new GPolygon()),
		ellipse("타원", new GEllipse()),
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
		isoscelesTrapezoid("등변사다리꼴", new GIsoscelesTrapezoid()),	
		trapezoid("사다리꼴", new GTrapezoid()),
		parallelogram("평행사변형", new GParallelogram()),
		rhombus("마름모", new GRhombus()),
		star("별", new GStar()),
		dagger("표창", new GDagger()),
		cross("십자가", new GCross()),
		square("정사각형", new GSquare()),
		regularTriangle("정삼각형", new GRegularTriangle()),
		pentagon("오각형", new GPentagon()),
		hexagon("육각형", new GHexagon()),
		regularHexagon("정육각형", new GRegularHexagon()),
		regularPentagon("정오각형", new GRegularPentagon()),
		starOfDavid("다윗의별", new GStarOfDavid()),
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
		poly("다각형", "polyType"),
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
		roundrectangle("둥근네모", "image//roundrectangle.png"),
		ellipse("타원", "image//ellipse.png"),
		arc("호", "image//arc.png"),
		chord("현", "image//chord.png"),		
		arc1("부채꼴", "image//arc1.png"),
		arc2("반원", "image//arc2.png"),
		arc3("3/4원", "image//arc3.png"),
		;
		private String text;
		private String image;
		private ERound (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	
	public enum ETriangle {
		isoscelesTriangle("이등변삼각형", "image//isoscelesTriangle.png"),
		rightTriangle("직각삼각형", "image//rightTriangle.png"),
		obtuseTriangle("둔각삼각형", "image//obtuseTriangle.png"),
		regularTriangle("정삼각형",  "image//regularTriangle.png"),
		;
		private String text;
		private String image;
		private ETriangle (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	
	public enum ERectangle {
		trapezoid("사다리꼴", "image//trapezoid.png"),
		isoscelesTrapezoid("등변사다리꼴", "image//isoscelesTrapezoid.png"),
		parallelogram("평행사변형", "image//parallelogram.png"),
		rhombus("마름모", "image//rhombus.png"),
		rectangle("직사각형", "image//rectangle.png"),
		square("정사각형", "image//square.png"),
		;
		private String text;
		private String image;
		private ERectangle (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	public enum ENormal {
		select("선택", "image//select.png"),
		line("직선", "image//line.png"),
		;
		private String text;
		private String image;
		private ENormal (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	public enum ESpecial {
		star("별", "image//star.png"),
		dagger("표창", "image//dagger.png"),
		cross("십자가", "image//cross.png"),
		starOfDavid("다윗의별", "image//starOfDavid.png"),
		;
		private String text;
		private String image;
		private ESpecial (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	public enum EArrow {
		leftArrow("왼쪽화살표", "image//leftArrow.png"),
		rightArrow("오른쪽화살표", "image//rightArrow.png"),
		upArrow("위쪽화살표", "image//upArrow.png"),
		downArrow("아래쪽화살표", "image//downArrow.png"),
		;
		private String text;
		private String image;
		private EArrow (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	public enum EPoly {
		pentagon("오각형", "image//pentagon.png"),
		regularPentagon("정오각형", "image//regularPentagon.png"),
		hexagon("육각형", "image//hexagon.png"),
		regularHexagon("정육각형", "image//regularHexagon.png"),
		polygon("폴리곤", "image//polygon.png"),
		;
		private String text;
		private String image;
		private EPoly (String text, String image) {
			this.text = text;
			this.image = image;
		}
		public String getText() {
			return this.text;
		}
		public String getImage() {
			return this.image;
		}
}
	public enum EImage {
		x(30),
		y(30),
		;
		private int size;
		private EImage (int size) {
			this.size = size;
		}
		public int getSize() {
			return this.size;
		}
}
	public enum EImageLocation {
		directory("image//"),
		type(".png"),
		;
		private String text;
		private EImageLocation (String text) {
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
