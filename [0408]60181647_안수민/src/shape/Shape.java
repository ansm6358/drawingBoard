package shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Shape implements Cloneable{	
	private Anchor anchor;
	public Shape() {
		this.anchor = new Anchor();
	}
	protected java.awt.Shape shape;
	protected int px;
	protected int py;
	protected int bx; //도형의 한 가운데
	protected int lx; //가로의 절반 길이
	protected int by; //도형의 한 가운데
	protected int ly; //세로의 절반 길이
	protected int mx;
	protected int my;
	
	abstract public void setOrigin(int x, int y);
	abstract public void setPoint(int x, int y);
	abstract public void addPoint(int x, int y);
	
	public void initMoving(int x, int y) {
		
		this.px = x;
		this.py = y;
		
	}
	public abstract void keepMoving(int x, int y);
	public abstract void finishMoving(int x, int y);
	
	public Shape clone() {
		try {
			return (Shape)this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();			
		}return null;
	}
	public void draw(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D)graphics;
		graphics2d.draw(this.shape);
	}
	public boolean contains(int x, int y) {
		return this.shape.contains(x,y);
	}
	public void findCenter() {
		
	}
	public void makeAnchor(Graphics2D graphics2d) {
		this.anchor.setLocation(this.bx, this.by, this.lx, this.ly);
		this.anchor.draw(graphics2d);
	}
	public void keepMoveAnchor(Graphics2D graphics2d) {
		this.anchor.draw(graphics2d);
		this.anchor.moveAnchor(graphics2d, this.mx, this.my);
		this.anchor.draw(graphics2d);
	}
	public void finishAnchor(Graphics2D graphics2d) {
		this.anchor.draw(graphics2d);

	}

}
