package shape;

public class Rectangle extends Shape {
	private java.awt.Rectangle rectangle; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	
	public Rectangle() {
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

	public void keepMoving(int x, int y) {
		int dw = x - this.px;
		int dh = y - this.py;
		this.mx = dw;
		this.my = dh;
		
		this.rectangle.setLocation(this.rectangle.x+dw, this.rectangle.y+dh);
		
		this.px = x;
		this.py = y;
	}
	public void finishMoving(int x, int y) {
		
	}
	public void findCenter() {
		this.lx = this.rectangle.width/2;
		this.ly = this.rectangle.height/2;
		this.bx = this.rectangle.x + this.lx;
		this.by = this.rectangle.y + this.ly;
	}
}