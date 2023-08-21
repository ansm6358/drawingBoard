package shape;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import global.Constants.EFontName;

public class GText extends GShape {
	private static final long serialVersionUID = 1L;
	private String fontType;
	private int fontStyle;
	private int fontSize;
	private String text;
	private char first =0x30; //0
	private char last = 0x39; //9
	private GlyphVector glyphVector;
	private FontRenderContext fontRenderContext;
	private Font font;
	
	public GText() {
		super();
		this.shape = new Rectangle();
		this.fontType = Font.SERIF;
		this.fontStyle = Font.PLAIN;
		this.fontSize = 100;
		this.text = "Hello";
	}


	public void setOrigin(int x, int y) {
		this.setText();
		this.font = new Font(this.fontType, this.fontStyle, this.fontSize);
		this.affineTransform = this.font.getTransform();
		this.fontRenderContext = new FontRenderContext(this.affineTransform, false, false);
		this.glyphVector = this.font.createGlyphVector(fontRenderContext, this.text);
		this.px = x;
		this.py = y;
		
	}

	private void setText() {
		boolean num = true;
		int currenVal = 0;
		String size = JOptionPane.showInputDialog("����� �Է����ּ��� (�ڿ����� �Է����ּ���)");
		if(size != null) {
			for(int i =0; i<size.length(); i++) {
				 if(size.charAt(i)>=first && size.charAt(i)<=last) //������ ���
				currenVal = currenVal*10 + (size.charAt(i) & 0x0F); //00001111 and ���Ѽ� �ƽ�Űĳ���ͷ� ���������� ��ȯ			
			
				else { //���ڰ� �ƴѰ��
					num = false;
				}
			}
			if(num) {
			this.fontSize = Integer.parseInt(size);
		}
			} 
		
		
		String text = JOptionPane.showInputDialog("�۾��� �Է����ּ���.");
		if(text != null) {
		this.text = text;
		}
	}

	public void setPoint(int x, int y) {
		this.shape = this.glyphVector.getOutline(x,y);
		this.px = x;
		this.py = y;
	}
	
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GText();
	}
	
}