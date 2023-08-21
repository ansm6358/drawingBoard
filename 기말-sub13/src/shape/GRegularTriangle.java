package shape;

public class GRegularTriangle extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	
	public GRegularTriangle() {
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
		
		double cx = (this.px+x)/2;
		double cy= (this.py+y)/2;
		double angle = Math.toRadians(120);
		
		this.polygon.addPoint((this.px+x)/2, this.py);
		int x1 = this.newPointX((this.px+x)/2, this.py, cx, cy, angle);
		int y1 = this.newPointY((this.px+x)/2, this.py, cx, cy, angle);
		this.polygon.addPoint(x1, y1);
		int x2 = this.newPointX(x1, y1, cx, cy, angle);
		int y2 = this.newPointY(x1, y1, cx, cy, angle);
		this.polygon.addPoint(x2,y2);
		
	}
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GRegularTriangle();
	}
	private int newPointX(double x, double y, double cx, double cy, double angle) {
		int changePoint = (int) ((x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle) + cx);

		return changePoint;
	}

	private int newPointY(int x, int y, double cx, double cy, double angle) {
		int changePoint = (int) ((x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle) + cy);
		return changePoint;
	}
}