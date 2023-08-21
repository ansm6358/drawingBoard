package shape;

public class GPentagon extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	
	public GPentagon() {
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
		this.polygon.addPoint((this.px+x)/2, this.py);
		this.polygon.addPoint(x, this.py+(y-this.py)*2/5);
		this.polygon.addPoint(this.px+(x-this.px)*4/5, y);
		this.polygon.addPoint(this.px+(x-this.px)/5, y);
		this.polygon.addPoint(this.px, this.py+(y-this.py)*2/5);
	}
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GPentagon();
	}
	
}