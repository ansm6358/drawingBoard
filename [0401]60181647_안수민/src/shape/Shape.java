package shape;

import java.awt.Graphics;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	protected int startX, startY, endX, endY, x01, y01, x02, y02;
	protected int bigX, smallX, bigY, smallY;
	protected boolean range;
	
	public void setOrigin(int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}
	public void setPoint(int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}
	public void addPoint(int x, int y) {

	}
	public void startPoint(int x, int y) {
		this.x01 = this.x1;
		this.y01 = this.y1;
		this.x02 = this.x2;
		this.y02 = this.y2;
		this.startX = x;
		this.startY = y;
	}
	public void endPoint(int x, int y) {
		
		this.endX = x;
		this.endY = y;
	}
	public void changePoint() {
		
		this.x1 = this.x01 + (this.endX-this.startX);
		this.y1 = this.y01 + (this.endY-this.startY);
		this.x2 = this.x02 + (this.endX-this.startX);
		this.y2 = this.y02 + (this.endY-this.startY);
	}
	public void changeArrayPoint() {		
		
	}
	public int getFirstX() {return this.x1;}
	public int getFirstY() {return this.y1;}
	public int getLastX() {return this.x2;}
	public int getLastY() {return this.y2;}
	
	public int getbigX() {return this.bigX;}
	public int getsmallX() {return this.smallX;}
	public int getbigY() {return this.bigY;}
	public int getsmallY() {return this.smallY;}
	
	public void setisRange(boolean isRange) {
		this.range = isRange;
	}
	public boolean getisRange() {
		return this.range;
	}
	
	public void compareArray() {		
	}
	public void saveArray() {
		
	}
	public Shape clone() {
		try {
			return (Shape)this.getClass().newInstance();
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} 
		}
	
	abstract public void draw(Graphics graphics);
	
	
	
}
