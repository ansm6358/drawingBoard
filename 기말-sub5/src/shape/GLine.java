package shape;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class GLine extends GShape {
	private static final long serialVersionUID = 1L;
	private Line2D line; 
	private double x1;
	private double y1;
	
	public GLine() {
		super();
		this.shape = new Line2D.Double();
		this.line = (Line2D)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.x1 = x;
		this.y1 = y;
		}
	
	public void setPoint(int x, int y) {
		this.line.setLine(this.x1, this.y1, x, y);

	}
	
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GLine();
	}

}