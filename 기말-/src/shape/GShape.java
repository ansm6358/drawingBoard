package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.Serializable;

import shape.GAnchors.EAnchors;

public abstract class GShape implements Cloneable, Serializable {

	public enum EOnState {
		eOnShape, eOnResize, eOnRotate
	};

	protected Shape shape; 
	protected int px;
	protected int py;
	private boolean selected;
	private GAnchors anchors;
	private boolean initAnchor;
	private Color color;
	private EAnchors eAnchor;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if (this.selected)
			this.anchors.setBoundingRect(this.shape.getBounds());
	}

	public GShape() {
		this.selected = false;
		this.anchors = new GAnchors();
	}
	
	public EAnchors geteAnchor() {
		return eAnchor;
	}

	public void seteAnchor(EAnchors eAnchor) {
		this.eAnchor = eAnchor;
	}

	abstract public void setOrigin(int x, int y);

	abstract public void setPoint(int x, int y);

	abstract public void addPoint(int x, int y);

	public void initMoving(Graphics2D graphics2d, int x, int y) {
		this.px = x;
		this.py = y;
		if (!this.selected) {
			this.selected = true;
			this.anchors.setBoundingRect(this.shape.getBounds());
			this.anchors.draw(graphics2d);
		}
		initAnchor = true;
	}

	public abstract void keepMoving(Graphics2D graphics2d, int x, int y);

	public abstract void finishMoving(Graphics2D graphics2d, int x, int y);

	public GShape clone() {
		try {
			return (GShape) this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics2D graphics2d) {
		graphics2d.draw(this.shape);
		if (this.selected) {
			this.anchors.setBoundingRect(this.shape.getBounds());
			if(this.initAnchor) {
				graphics2d.setPaintMode();
				this.anchors.draw(graphics2d);
				graphics2d.setXORMode(this.color);
				this.initAnchor = false;
			}
			this.anchors.draw(graphics2d);
		}
	}

	public EOnState onShape(int x, int y) {
		if (this.selected) {
			EAnchors eAnchor = this.anchors.onShape(x, y);
			this.seteAnchor(eAnchor);
			if (eAnchor == EAnchors.RR) { // rotate
				return EOnState.eOnRotate;
			} else if (eAnchor == null) { //
				if (this.shape.contains(x, y)) {
					return EOnState.eOnShape;
				}
			} else { // resize
				return EOnState.eOnResize;
			}
		} else {
			if (this.shape.contains(x, y)) {
				return EOnState.eOnShape;
			}
		}
		return null;
	}


}
