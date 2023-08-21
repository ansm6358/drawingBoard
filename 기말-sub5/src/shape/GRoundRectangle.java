package shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class GRoundRectangle extends GShape {
	private static final long serialVersionUID = 1L;
	private RoundRectangle2D roundRectangle; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	
	public GRoundRectangle() {
		super();
		this.shape = new RoundRectangle2D.Double();
		this.roundRectangle = (RoundRectangle2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.roundRectangle.setRoundRect(x, y, 0, 0,10,10);
	
	}
	public void setPoint(int x, int y) {
		this.roundRectangle.setFrame(this.roundRectangle.getX(), this.roundRectangle.getY(), x-this.roundRectangle.getX(), y-this.roundRectangle.getY());

	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GRoundRectangle();
	}

}