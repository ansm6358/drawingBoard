package shape;

import java.awt.Graphics2D;

public class GRectangle extends GShape {
	private java.awt.Rectangle rectangle; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	
	public GRectangle() {
		super();
		this.shape = new java.awt.Rectangle();
		this.rectangle = (java.awt.Rectangle)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.rectangle.setBounds(x,y,0,0);
		
	}
	public void setPoint(int x, int y) {
		this.rectangle.setSize(x-this.rectangle.x, y-this.rectangle.y);

	}
	public void addPoint(int x, int y) {
	}



}