package global;

import shape.GRectangle;
import shape.GRoundRectangle;
import shape.GEllipse;
import shape.GPolygon;
import shape.GLine;
import shape.GQuarterArc;
import shape.GHalfArc;

import java.awt.Font;

import shape.G3QuarterArc;
import shape.GShape;


public class Constants {
	public enum EFontName {
		SERIF(Font.SERIF),
		SANS_SERIF(Font.SANS_SERIF),
		DIALOG(Font.DIALOG),
		DIALOG_INPUT(Font.DIALOG_INPUT),
		MONOSPACED(Font.MONOSPACED),
		;
		private String type;
		private EFontName (String type) {
			this.type = type;
		}
		public String getType() {
			return this.type;
		}
	}
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
		rectangle1("둥근네모", new GRoundRectangle()),
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
		newItem("새로만들기", "nnew"),
		openItem("열기", "open"),
		saveItem("저장", "save"),
		saveAsItem("다른이름으로", "saveAs"),
		printItem("인쇄하기", "print"),
		closeItem("닫기", "close"),
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
		undo("되돌리기", "undo"),
		redo("다시실행", "redo"),
		cut("잘라내기", "cut"),
		copy("복사하기", "copy"),
		paste("붙여넣기", "paste"),
		group("모으기", "group"),
		ungroup("나누기", "ungroup"),
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
