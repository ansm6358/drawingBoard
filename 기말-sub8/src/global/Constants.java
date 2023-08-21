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
		select("����", new GGroup()),
		rectangle("���簢��", new GRectangle()),
		roundrectangle("�ձٳ׸�", new GRoundRectangle()),
		polygon("������", new GPolygon()),
		ellipse("Ÿ��", new GEllipse()),
		line("����", new GLine()),
		arc("ȣ", new GArc()),
		arc1("��ä��", new GQuarterArc()),
		arc2("�ݿ�", new GHalfArc()),
		arc3("3/4��", new G3QuarterArc()),
		chord("��", new GChord()),
		isoscelesTriangle("�̵�ﰢ��", new GIsoscelesTriangle()),
		rightTriangle("�����ﰢ��", new GRightTriangle()),
		obtuseTriangle("�а��ﰢ��", new GObtuseTriangle()),
		leftArrow("����ȭ��ǥ", new GLeftArrow()),
		rightArrow("������ȭ��ǥ", new GRightArrow()),
		upArrow("����ȭ��ǥ", new GUpArrow()),
		downArrow("�Ʒ���ȭ��ǥ", new GDownArrow()),
		isoscelesTrapezoid("���ٸ���", new GIsoscelesTrapezoid()),	
		trapezoid("��ٸ���", new GTrapezoid()),
		parallelogram("����纯��", new GParallelogram()),
		rhombus("������", new GRhombus()),
		star("��", new GStar()),
		dagger("ǥâ", new GDagger()),
		cross("���ڰ�", new GCross()),
		square("���簢��", new GSquare()),
		regularTriangle("���ﰢ��", new GRegularTriangle()),
		pentagon("������", new GPentagon()),
		hexagon("������", new GHexagon()),
		regularHexagon("��������", new GRegularHexagon()),
		regularPentagon("��������", new GRegularPentagon()),
		starOfDavid("�����Ǻ�", new GStarOfDavid()),
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
		back("��缱��"),
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
		nomal("�Ϲ�", "normaltypee"),
		round("����", "roundType"),
		triangle("�ﰢ��","triangleType"),
		rectangle("�簢��","rectType"),
		poly("�ٰ���", "polyType"),
		arrow("ȭ��ǥ", "arrowType"),
		special("Ư��","specialType"),
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
		roundrectangle("�ձٳ׸�", "image//roundrectangle.png"),
		ellipse("Ÿ��", "image//ellipse.png"),
		arc("ȣ", "image//arc.png"),
		chord("��", "image//chord.png"),		
		arc1("��ä��", "image//arc1.png"),
		arc2("�ݿ�", "image//arc2.png"),
		arc3("3/4��", "image//arc3.png"),
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
		isoscelesTriangle("�̵�ﰢ��", "image//isoscelesTriangle.png"),
		rightTriangle("�����ﰢ��", "image//rightTriangle.png"),
		obtuseTriangle("�а��ﰢ��", "image//obtuseTriangle.png"),
		regularTriangle("���ﰢ��",  "image//regularTriangle.png"),
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
		trapezoid("��ٸ���", "image//trapezoid.png"),
		isoscelesTrapezoid("���ٸ���", "image//isoscelesTrapezoid.png"),
		parallelogram("����纯��", "image//parallelogram.png"),
		rhombus("������", "image//rhombus.png"),
		rectangle("���簢��", "image//rectangle.png"),
		square("���簢��", "image//square.png"),
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
		select("����", "image//select.png"),
		line("����", "image//line.png"),
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
		star("��", "image//star.png"),
		dagger("ǥâ", "image//dagger.png"),
		cross("���ڰ�", "image//cross.png"),
		starOfDavid("�����Ǻ�", "image//starOfDavid.png"),
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
		leftArrow("����ȭ��ǥ", "image//leftArrow.png"),
		rightArrow("������ȭ��ǥ", "image//rightArrow.png"),
		upArrow("����ȭ��ǥ", "image//upArrow.png"),
		downArrow("�Ʒ���ȭ��ǥ", "image//downArrow.png"),
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
		pentagon("������", "image//pentagon.png"),
		regularPentagon("��������", "image//regularPentagon.png"),
		hexagon("������", "image//hexagon.png"),
		regularHexagon("��������", "image//regularHexagon.png"),
		polygon("������", "image//polygon.png"),
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
		filemenu("����"),
		editmenu("Edit"),
		selectMenu("����"),
		colormenu("�� ����");
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
		undo("�ǵ�����", "undo",'Z', KeyEvent.CTRL_MASK),
		redo("�ٽý���", "redo",'Z', KeyEvent.ALT_MASK),
		cut("�߶󳻱�", "cut",'X', KeyEvent.CTRL_MASK),
		copy("�����ϱ�", "copy",'C', KeyEvent.CTRL_MASK),
		paste("�ٿ��ֱ�", "paste",'V', KeyEvent.CTRL_MASK),
		group("������", "group",'G', KeyEvent.CTRL_MASK),
		ungroup("������", "ungroup",'G', KeyEvent.ALT_MASK),
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
		selectAll("��ü����", "selectAll",'A', KeyEvent.CTRL_MASK),
		selectClear("��������", "selectClear",'A', KeyEvent.ALT_MASK),
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
			eLine("��", "line",'I',KeyEvent.CTRL_MASK), 
			eFill("ä��� ��", "fill",'U',KeyEvent.CTRL_MASK);

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
