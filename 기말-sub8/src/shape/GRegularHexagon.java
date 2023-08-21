package shape;

public class GRegularHexagon extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	private int vertex;

	public GRegularHexagon() {
		super();
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon) this.shape;
		this.vertex = 6;
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
		double angle = Math.toRadians(60);
		int x1 = (this.px + x) / 2;
		int y1 = this.py;
		for (int i = 1; i < this.vertex; i++) {
			this.polygon.addPoint(x1, y1);
			x1 = this.newPointX(x1, y1, cx, cy, angle);
			y1 = this.newPointY(x1, y1, cx, cy, angle);
		}
		this.polygon.addPoint(x1, y1);

	}

	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GRegularHexagon();
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