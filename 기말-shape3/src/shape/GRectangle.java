package shape;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class GRectangle extends GShape {
	private Rectangle rectangle; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	private GlyphVector v;
	private FontRenderContext frc;
	private Font f;
	
	public GRectangle() {
		super();
		
		this.f = new Font(Font.SERIF,Font.PLAIN,100);
		this.affineTransform = this.f.getTransform();
		this.frc = new FontRenderContext(this.affineTransform, false, false);
		this.v = this.f.createGlyphVector(frc, "asd");
		this.shape = new java.awt.Rectangle();//this.v.getOutline();
		
		//this.rectangle = (Rectangle2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.px = x;
		this.py = y;
		//this.rectangle..setBounds(x,y,0,0);
		//this.shape = this.v.getOutline(x,y);
	}
	public void setPoint(int x, int y) {
		
		this.shape = this.v.getOutline(x,y);
		//this.affineTransform.setToTranslation(x-this.px, y-this.py);
		//this.shape = this.affineTransform.createTransformedShape(this.shape);
		//this.rectangle.setSize(x-this.rectangle.x, y-this.rectangle.y);
		this.px = x;
		this.py = y;
	}
	public void addPoint(int x, int y) {
	}



}