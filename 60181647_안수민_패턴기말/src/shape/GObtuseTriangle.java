package shape;

public class GObtuseTriangle extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	
	public GObtuseTriangle() {
		super();
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon)this.shape;
	}
	public void setOrigin(int x, int y) {	
		this.polygon.addPoint(x, y);
		this.polygon.addPoint(x, y);
		this.polygon.addPoint(x, y);
		this.px = x;
		this.py = y;
	}
	public void setPoint(int x, int y) {
		this.polygon.reset();
		this.polygon.addPoint(this.px, this.py);
		this.polygon.addPoint((this.px+x)/2, y);
		this.polygon.addPoint(x, y);
	}
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GObtuseTriangle();
	}
	
}