package shape;

import java.awt.geom.Ellipse2D;

public class GCircle extends GShape {
	private static final long serialVersionUID = 1L;
	private Ellipse2D ellipse; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	
	public GCircle() {
		super();
		this.shape = new Ellipse2D.Double();
		this.ellipse = (Ellipse2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.ellipse.setFrame(x, y, 0, 0);
		
	}
	public void setPoint(int x, int y) {
		if(x-this.ellipse.getX()>y-this.ellipse.getY()) {
			this.ellipse.setFrame(this.ellipse.getX(), this.ellipse.getY(),y-this.ellipse.getY(), y-this.ellipse.getY());
			} else {
				this.ellipse.setFrame(this.ellipse.getX(), this.ellipse.getY(),x-this.ellipse.getX(), x-this.ellipse.getX());
			}
	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GCircle();
	}

}