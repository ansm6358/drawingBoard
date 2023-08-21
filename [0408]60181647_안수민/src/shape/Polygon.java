package shape;

public class Polygon extends Shape {
	private java.awt.Polygon polygon;

	public Polygon() {
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon) this.shape;
	}

	public void setOrigin(int x, int y) {
		this.polygon.addPoint(x, y);
		this.polygon.addPoint(x, y);
	}

	public void setPoint(int x, int y) {
		this.polygon.xpoints[this.polygon.npoints - 1] = x;
		this.polygon.ypoints[this.polygon.npoints - 1] = y;
	}

	public void addPoint(int x, int y) {
		this.polygon.addPoint(x, y);

	}

	public void keepMoving(int x, int y) {
		int dw = x - this.px;
		int dh = y - this.py;
		this.mx = dw;
		this.my = dh;
		
		for (int i = 0; i < this.polygon.npoints; i++) {
			this.polygon.xpoints[i] += dw;
			this.polygon.ypoints[i] += dh;
		}

		this.px = x;
		this.py = y;
	}

	public void finishMoving(int x, int y) {
		java.awt.Polygon newPolygon = new java.awt.Polygon();
		for (int i = 0; i < this.polygon.npoints; i++) {
			newPolygon.addPoint(this.polygon.xpoints[i], this.polygon.ypoints[i]);
		}
		this.shape = newPolygon;
		this.polygon = (java.awt.Polygon) this.shape;
	}

	public void findCenter() {
		int tempX1 = this.polygon.xpoints[0];
		int tempY1 = this.polygon.ypoints[0];
		int tempX2 = this.polygon.xpoints[0];
		int tempY2 = this.polygon.ypoints[0];

		for (int i = 1; i < this.polygon.npoints; i++) {
			if (tempX1 < this.polygon.xpoints[i]) {
				tempX1 = this.polygon.xpoints[i];
			}
			if (tempY1 < this.polygon.ypoints[i]) {
				tempY1 = this.polygon.ypoints[i];
			}
			if (tempX2 > this.polygon.xpoints[i]) {
				tempX2 = this.polygon.xpoints[i];
			}
			if (tempY2 > this.polygon.ypoints[i]) {
				tempY2 = this.polygon.ypoints[i];
			}
		}

		this.bx = (tempX1 + tempX2) / 2;
		this.by = (tempY1 + tempY2) / 2;
		this.lx = (tempX1 - tempX2) / 2;
		this.ly = (tempY1 - tempY2) / 2;
	}
}