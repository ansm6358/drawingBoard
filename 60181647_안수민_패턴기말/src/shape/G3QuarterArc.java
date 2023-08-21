package shape;

import java.awt.geom.Arc2D;

public class G3QuarterArc extends GShape {
	private static final long serialVersionUID = 1L;
	private Arc2D arc; //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	
	public G3QuarterArc() {
		super();
		this.shape = new Arc2D.Double();
		this.arc = (Arc2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		
		this.arc.setFrame(x, y, 0, 0);
		this.arc.setArcType(Arc2D.PIE);
		this.arc.setAngleStart(0);
		this.arc.setAngleExtent(270);
		
	}
	public void setPoint(int x, int y) {
		this.arc.setFrame(this.arc.getX(), this.arc.getY(), x-this.arc.getX(), y-this.arc.getY());

	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new G3QuarterArc();
	}

}