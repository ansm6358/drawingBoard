package shape;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class GHalfArc extends GShape {
	private static final long serialVersionUID = 1L;
	private Arc2D arc; //������ ������ ���� ������ ���ٱ��� �ּҸ� ������� �Ѵ�.
	
	public GHalfArc() {
		super();
		this.shape = new Arc2D.Double();
		this.arc = (Arc2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		
		this.arc.setFrame(x, y, 0, 0);
		this.arc.setArcType(Arc2D.PIE);
		this.arc.setAngleStart(0);
		this.arc.setAngleExtent(180);
		
	}
	public void setPoint(int x, int y) {
		this.arc.setFrame(this.arc.getX(), this.arc.getY(), x-this.arc.getX(), (y-this.arc.getY())*2);

	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GHalfArc();
	}

}