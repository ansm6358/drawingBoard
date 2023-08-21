package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import shape.GAnchors.EAnchors;

public abstract class GShape implements Cloneable, Serializable {

	public enum EOnState {
		eOnShape, eOnResize, eOnRotate, eOnShear
	};

	protected Shape shape;
	protected int px;
	protected int py;
	private boolean selected;
	private GAnchors anchors;
	private boolean initAnchor;
	private Color color;
	private EAnchors eAnchor;
	private AffineTransform affineTransform;
	private boolean isRotate= false;
	private double oldRate = 0;

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
		this.affineTransform = new AffineTransform();
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

	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x - this.px;
		int dh = y - this.py;

		this.affineTransform.setToTranslation(dw, dh);
		this.shape = this.affineTransform.createTransformedShape(this.shape);

		this.px = x;
		this.py = y;
	};

	public void finishMoving(Graphics2D graphics2d, int x, int y) {

	};

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
			if(!this.isRotate) {
			this.anchors.setBoundingRect(this.shape.getBounds());
			}
			if (this.initAnchor) {
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
			} else if(eAnchor == EAnchors.GG) {
				return EOnState.eOnShear;
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

	public void initResizing(int x, int y) {
		this.px = x;
		this.py = y;
		initAnchor = true;
	}

	public void keepResizing(Graphics2D graphics2d, int x, int y) {
		double rateW;
		double rateH;
		double settingX;
		double settingY;
		boolean changeAnchor = false;

		switch (this.eAnchor) {
		case NW:
			rateW = (this.px - x + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (this.py - y + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingX = this.px - (rateW * this.shape.getBounds().getX());
			settingY = this.py - (rateH * this.shape.getBounds().getY());
			if (rateW > 0 && rateH > 0) {
				doResize(rateW, rateH, settingX, settingY);
			} else if (rateW <= 0 && rateH <= 0) {
				this.seteAnchor(eAnchor.SE);
				changeAnchor = true;
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.NE);
				changeAnchor = true;
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.SW);
				changeAnchor = true;
			}

			break;
		case NN:
			rateH = (this.py - y + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingY = this.py - (rateH * this.shape.getBounds().getY());
			if (rateH > 0) {
				doResize(1, rateH, 0, settingY);
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.SS);
				changeAnchor = true;
			}
			break;
		case NE:
			rateW = (x - this.shape.getBounds().getX()) / this.shape.getBounds().getWidth();
			rateH = (this.py - y + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingX = this.shape.getBounds().getX() - (rateW * this.shape.getBounds().getX());
			settingY = this.py - (rateH * this.shape.getBounds().getY());
			if (rateW > 0 && rateH > 0) {
				doResize(rateW, rateH, settingX, settingY);
			} else if (rateW <= 0 && rateH <= 0) {
				this.seteAnchor(eAnchor.SW);
				changeAnchor = true;
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.NW);
				changeAnchor = true;
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.SE);
				changeAnchor = true;
			}
			break;
		case EE:
			rateW = (x - this.shape.getBounds().getX()) / this.shape.getBounds().getWidth();
			settingX = this.shape.getBounds().getX() - (rateW * this.shape.getBounds().getX());
			
			if (rateW > 0) {
				doResize(rateW, 1, settingX, 0);
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.WW);
				changeAnchor = true;
			}
			break;
		case SE:
			rateW = (x - this.shape.getBounds().getX()) / this.shape.getBounds().getWidth();
			rateH = (y - this.shape.getBounds().getY()) / this.shape.getBounds().getHeight();
			settingX = this.shape.getBounds().getX() - (rateW * this.shape.getBounds().getX());
			settingY = this.shape.getBounds().getY() - (rateH * this.shape.getBounds().getY());
			
			if (rateW > 0 && rateH > 0) {
				doResize(rateW, rateH, settingX, settingY);
			} else if (rateW <= 0 && rateH <= 0) {
				this.seteAnchor(eAnchor.NW);
				changeAnchor = true;
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.SW);
				changeAnchor = true;
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.NE);
				changeAnchor = true;
			}
			break;
		case SS:
			rateH = (y - this.shape.getBounds().getY()) / this.shape.getBounds().getHeight();
			settingY = this.shape.getBounds().getY() - (rateH * this.shape.getBounds().getY());
			
			if (rateH > 0) {
				doResize(1, rateH, 0, settingY);
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.NN);
				changeAnchor = true;
			}
			break;
		case SW:
			rateW = (this.px - x + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (y - this.shape.getBounds().getY()) / this.shape.getBounds().getHeight();
			settingX = this.px - (rateW * this.shape.getBounds().getX());
			settingY = this.shape.getBounds().getY() - (rateH * this.shape.getBounds().getY());
			
			if (rateW > 0 && rateH > 0) {
				doResize(rateW, rateH, settingX, settingY);
			} else if (rateW <= 0 && rateH <= 0) {
				this.seteAnchor(eAnchor.NE);
				changeAnchor = true;
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.SE);
				changeAnchor = true;
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.NW);
				changeAnchor = true;
			}
			break;
		case WW:
			rateW = (this.px - x + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			settingX = this.px - (rateW * this.shape.getBounds().getX());
			
			if (rateW > 0) {
				doResize(rateW, 1, settingX, 0);
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.EE);
				changeAnchor = true;
			}
			break;
		}

		this.px = x;
		this.py = y;

		if (changeAnchor) {
			keepResizing(graphics2d, x, y);
		}
	}

	private void doResize(double rateW, double rateH, double settingX, double settingY) {
		this.affineTransform.setToScale(rateW, rateH);
		this.shape = this.affineTransform.createTransformedShape(this.shape);

		this.affineTransform.setToTranslation(settingX, settingY);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
	}

	public void finishResizing(Graphics2D graphics2d, int x, int y) {

	}

	public void initRotating(int x, int y) {
		this.px = x;
		this.py = y;
		initAnchor = true;
	}

	public void keepRotating(Graphics2D graphics2d, int x, int y) {
		this.isRotate = true;
		double rate = Math.sqrt(this.px*this.px+this.py*this.py)/Math.sqrt(x*x+y*y);
		
		this.affineTransform.rotate(Math.atan(rate)-this.oldRate, this.shape.getBounds().getCenterX(), this.shape.getBounds().getCenterY());
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.anchors.rotate(this.affineTransform, graphics2d);
		this.oldRate = rate;
		this.px = x;
		this.py = y;
	}

	public void finishRotating(Graphics2D graphics2d, int x, int y) {
		this.isRotate = false;
	}

	public void initShearing(int x, int y) {
		this.px = x;
		this.py = y;
		initAnchor = true;
	}

	public void keepShearing(Graphics2D graphics2d, int x, int y) {
		this.affineTransform.shear(1, 0);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.px = x;
		this.py = y;
	}

	public void finishShearing(Graphics2D graphics2d, int x, int y) {
		
	}

}
