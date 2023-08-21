package shape;

public class GRegularPentagon extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	private int vertex;
	private int tempX;
	private int tempY;

	public GRegularPentagon() {
		super();
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon) this.shape;
		this.vertex = 5;
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
		
		double cx = (this.px + x) / 2;
		double cy = (this.py + y) / 2;
		
		double angle = Math.toRadians(72);
		
		this.tempX = (this.px + x) / 2;
		this.tempY = this.py;	
		this.polygon.addPoint(this.tempX, this.tempY);

		
		int x2 = this.newPointX(this.tempX, this.tempY, cx, cy, angle);
		int y2 = this.newPointY(this.tempX, this.tempY, cx, cy, angle);
		this.polygon.addPoint(x2, y2);
		
		int x3 = this.newPointX(x2, y2, cx, cy, angle);
		int y3 = this.newPointY(x2, y2, cx, cy, angle);
		this.polygon.addPoint(x3, y3);
		
		int x4 = this.newPointX(x3, y3, cx, cy, angle);
		int y4 = this.newPointY(x3, y3, cx, cy, angle);
		this.polygon.addPoint(x4, y4);
		
		int x5 = this.newPointX(x4, y4, cx, cy, angle);
		int y5 = this.newPointY(x4, y4, cx, cy, angle);
		this.polygon.addPoint(x5, y5);
		
//		for (int i = 1; i < this.vertex; i++) {
//			this.tempX = this.newPointX(this.tempX, this.tempY, cx, cy, angle);
//			this.tempY = this.newPointY(this.tempX, this.tempY, cx, cy, angle);
//			this.polygon.addPoint(this.tempX, this.tempY);
//		}
		

	}

	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GRegularPentagon();
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