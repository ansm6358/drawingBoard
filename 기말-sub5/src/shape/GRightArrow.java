package shape;

import java.awt.Graphics2D;

public class GRightArrow extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	
	public GRightArrow() {
		super();
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon)this.shape;
	}
	public void setOrigin(int x, int y) {	
		this.polygon.addPoint(x, y);
		this.px = x;
		this.py = y;
	}
	public void setPoint(int x, int y) {
		this.polygon.reset();
		this.polygon.addPoint(this.px, this.py+(y-this.py)/4);
		this.polygon.addPoint(this.px+(x-this.px)*2/3, this.py+(y-this.py)/4);
		this.polygon.addPoint(this.px+(x-this.px)*2/3, this.py);
		this.polygon.addPoint(x, this.py+(y-this.py)/2);
		this.polygon.addPoint(this.px+(x-this.px)*2/3, y);
		this.polygon.addPoint(this.px+(x-this.px)*2/3, this.py+(y-this.py)*3/4);
		this.polygon.addPoint(this.px, this.py+(y-this.py)*3/4);
	}
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GRightArrow();
	}
	
}