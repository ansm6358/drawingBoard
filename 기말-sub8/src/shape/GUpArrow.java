package shape;

public class GUpArrow extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	
	public GUpArrow() {
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
		this.polygon.addPoint(this.px+(x-this.px)/2, this.py);
		this.polygon.addPoint(x, this.py+(y-this.py)/4);
		this.polygon.addPoint(this.px+(x-this.px)*3/4, this.py+(y-this.py)/4);
		this.polygon.addPoint(this.px+(x-this.px)*3/4, y);
		this.polygon.addPoint(this.px+(x-this.px)/4, y);
		this.polygon.addPoint(this.px+(x-this.px)/4, this.py+(y-this.py)/4);
	}
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GUpArrow();
	}
	
}