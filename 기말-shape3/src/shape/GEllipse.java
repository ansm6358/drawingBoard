package shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class GEllipse extends GShape {
	private Ellipse2D ellipse; //������ ������ ���� ������ ���ٱ��� �ּҸ� ������� �Ѵ�.
	
	public GEllipse() {
		super();
		this.shape = new Ellipse2D.Double();
		this.ellipse = (Ellipse2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.ellipse.setFrame(x, y, 0, 0);
		
	}
	public void setPoint(int x, int y) {
		this.ellipse.setFrame(this.ellipse.getX(), this.ellipse.getY(), x-this.ellipse.getX(), y-this.ellipse.getY());

	}
	public void addPoint(int x, int y) {
	}



}