package shape;

import java.awt.Graphics;

public class Polygon extends Shape {
	private final static int nMaxPoints = 20;
	private int[] xPoints;
	private int[] yPoints;
	private int[] xSavePoints;
	private int[] ySavePoints;
	private int nPoints;
	public Polygon() {
		this.nPoints = 0;
		this.xPoints = new int[nMaxPoints];
		this.yPoints = new int[nMaxPoints];
		this.xSavePoints = new int[nMaxPoints];
		this.ySavePoints = new int[nMaxPoints];
	}
	public void setOrigin(int x, int y) {
		this.xPoints[this.nPoints] = x;
		this.yPoints[this.nPoints] = y;
		this.xSavePoints[this.nPoints] = x;
		this.ySavePoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;
		
		this.xPoints[this.nPoints] = x;
		this.yPoints[this.nPoints] = y;
		this.xSavePoints[this.nPoints] = x;
		this.ySavePoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;
	}
	public void setPoint(int x, int y) {
		this.xPoints[this.nPoints-1] = x;
		this.yPoints[this.nPoints-1] = y;
		this.xSavePoints[this.nPoints-1] = x;
		this.ySavePoints[this.nPoints-1] = y;
	}
	public void addPoint(int x, int y) {
		this.xPoints[this.nPoints] = x;
		this.yPoints[this.nPoints] = y;
		this.xSavePoints[this.nPoints] = x;
		this.ySavePoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;
		
	}
	public void compareArray() {
		int tempX1 = this.xPoints[0];
		int tempY1 = this.yPoints[0];
		int tempX2 = this.xPoints[0];
		int tempY2 = this.yPoints[0];
		
		for(int i=1; i < this.nPoints; i++) {
			if(tempX1 < this.xPoints[i]) {
				tempX1 = this.xPoints[i];
			}
			if(tempY1 < this.yPoints[i]) {
				tempY1 = this.yPoints[i];
			}
		}
		this.bigX = tempX1;
		this.bigY = tempY1;
		
		for(int i=1; i > this.nPoints; i++) {
			if(tempX2 > this.xPoints[i]) {
				tempX2 = this.xPoints[i];
			}
			if(tempY2 > this.yPoints[i]) {
				tempY2 = this.yPoints[i];
			}
		}
		this.smallX = tempX2;
		this.smallY = tempY2;
		
	}
	public void changeArrayPoint() {		
		for(int i=0; i < this.nPoints; i++) {
			this.xPoints[i] = this.xSavePoints[i] + (this.endX-this.startX);
			this.yPoints[i] = this.ySavePoints[i] + (this.endY-this.startY);	
		}
	}
	public void saveArray() {
		for(int i=0; i < this.nPoints; i++) {
			this.xSavePoints[i] = this.xPoints[i];
			this.ySavePoints[i] = this.yPoints[i];	
		}
	}
	public void draw(Graphics graphics) {
		graphics.drawPolygon(xPoints, yPoints, nPoints);
	}
}