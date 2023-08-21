package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import shape.GAnchors.EAnchors;

public abstract class GShape implements Cloneable, Serializable {

	public enum EOnState {
		eOnShape, eOnResize, eOnRotate, eOnShear
	};

	protected Shape shape;
	protected int px;
	protected int py;
	public Shape getShape() {return this.shape;}
	private boolean selected;
	private GAnchors anchors;
	// private boolean initAnchor;
	private Color color;
	private Color lineColor;
	private Color fillColor;
	private EAnchors eAnchor;
	private AffineTransform affineTransform;
	private double rotateRate = 0;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if (this.selected) {
//			this.affineTransform = new AffineTransform();
//			this.shape = this.affineTransform.createTransformedShape(this.shape);
//		this.anchors.setBoundingRect(this.shape.getBounds());
		}
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
		if (this.selected) {
			//this.selected = true;
//			this.shape = this.affineTransform.createTransformedShape(this.shape);
//			this.anchors.setBoundingRect(this.shape.getBounds());

			this.anchors.draw(graphics2d);
		}
		// initAnchor = true;
	}

	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x - this.px;
		int dh = y - this.py;

		this.affineTransform.setToTranslation(dw, dh);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.anchors.moveAnchor(dw, dh);

		this.px = x;
		this.py = y;
	};

	public void finishMoving(Graphics2D graphics2d, int x, int y) {

	};

	public void setClone() {
		this.affineTransform.setToTranslation(10, 10);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
	}

	public GShape clone() {
		try {

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(this);

			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return (GShape) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	abstract public GShape newInstance();

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics2D graphics2d) {
		if (this.fillColor != null) {
			graphics2d.setColor(fillColor);
			graphics2d.fill(this.shape);
		}
//		graphics2d.setComposite(AlphaComposite.Src);
//		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(this.lineColor != null) {
			graphics2d.setColor(this.lineColor);
			//System.out.println("Asdf");
		}
		
		graphics2d.draw(this.shape);
		
		if (this.selected) {
			// this.anchors.setBoundingRect(this.shape.getBounds());
			// if (this.initAnchor) {
			// graphics2d.setPaintMode();
			// this.anchors.draw(graphics2d);
			// if(this.color != null) {
			// graphics2d.setXORMode(this.color);
			// }
			// this.initAnchor = false;
			// }
			this.anchors.draw(graphics2d);
		}
	}

	public EOnState onShape(int x, int y) {
		if (this.selected) {
			EAnchors eAnchor = this.anchors.onShape(x, y);
			this.seteAnchor(eAnchor);
			if (eAnchor == EAnchors.RR) { // rotate
				return EOnState.eOnRotate;
			} else if (eAnchor == EAnchors.GG) {
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
		// initAnchor = true;
	}

	public void keepResizing(Graphics2D graphics2d, int x, int y) {
		double rateW;
		double rateH;
		double settingX;
		double settingY;
		
		boolean changeAnchor = false;
		double cx = this.shape.getBounds().getCenterX();
		double cy = this.shape.getBounds().getCenterY();
		this.affineTransform.setToRotation(-this.rotateRate, cx, cy);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		
		int ox = beforeRotatePointX(this.px, this.py, cx, cy);
		int oy = beforeRotatePointY(this.px, this.py, cx, cy);
		int bx = beforeRotatePointX(x, y, cx, cy);
		int by = beforeRotatePointY(x, y, cx, cy);
		
		switch (this.eAnchor) {
		case NW:
			rateW = (ox - bx + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (oy - by + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingX = bx - (rateW * this.shape.getBounds().getX());
			settingY = by - (rateH * this.shape.getBounds().getY());
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
			rateH = (oy - by + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingY = by - (rateH * this.shape.getBounds().getY());
			if (rateH > 0) {
				doResize(1, rateH, 0, settingY);
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.SS);
				changeAnchor = true;
			}
			break;
		case NE:
			rateW = (bx-ox + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (oy - by + this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingX = this.shape.getBounds().getX() - (rateW * this.shape.getBounds().getX());
			settingY = by - (rateH * this.shape.getBounds().getY());
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
			rateW = (bx-ox + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			settingX = this.shape.getBounds().getX() - (rateW * this.shape.getBounds().getX());

			if (rateW > 0) {
				doResize(rateW, 1, settingX, 0);
			} else if (rateW <= 0) {
				this.seteAnchor(eAnchor.WW);
				changeAnchor = true;
			}
			break;
		case SE:
			rateW = (bx-ox + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (by -oy +this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
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
			rateH = (by -oy +this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingY = this.shape.getBounds().getY() - (rateH * this.shape.getBounds().getY());
			if (rateH > 0) {
				doResize(1, rateH, 0, settingY);
			} else if (rateH <= 0) {
				this.seteAnchor(eAnchor.NN);
				changeAnchor = true;
			}
			break;
		case SW:
			rateW = (ox - bx + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			rateH = (by -oy +this.shape.getBounds().getHeight()) / this.shape.getBounds().getHeight();
			settingX = bx - (rateW * this.shape.getBounds().getX());
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
			rateW = (ox - bx + this.shape.getBounds().getWidth()) / this.shape.getBounds().getWidth();
			settingX = bx - (rateW * this.shape.getBounds().getX());

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

	private int beforeRotatePointX(int x, int y, double cx, double cy) {
		int changePoint = (int) ((x - cx) * Math.cos(-this.rotateRate) - (y - cy) * Math.sin(-this.rotateRate) + cx);

		return changePoint;
	}

	private int beforeRotatePointY(int x, int y, double cx, double cy) {
		int changePoint = (int) ((x - cx) * Math.sin(-this.rotateRate) + (y - cy) * Math.cos(-this.rotateRate) + cy);
		return changePoint;
	}

	private void doResize(double rateW, double rateH, double settingX, double settingY) {
		double sx = this.shape.getBounds().getCenterX();
		double sy =this.shape.getBounds().getCenterY();
		
		this.affineTransform.setToScale(rateW, rateH);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		
		this.affineTransform.setToTranslation(settingX, settingY);
		this.shape = this.affineTransform.createTransformedShape(this.shape);

		this.anchors.setBoundingRect(this.shape.getBounds());
		this.affineTransform.setToRotation(this.rotateRate, sx, sy);
		this.shape = this.affineTransform.createTransformedShape(this.shape);

	}

	public void finishResizing(Graphics2D graphics2d, int x, int y) {

	}

	public void initRotating(int x, int y) {
		this.px = x;
		this.py = y;
		// initAnchor = true;
	}

	public void keepRotating(Graphics2D graphics2d, int x, int y) {
		double centerX = this.shape.getBounds().getCenterX();
		double centerY = this.shape.getBounds().getCenterY();

		double radian = Math.atan2(centerY - y, centerX - x) - Math.atan2(centerY - this.py, centerX - this.px);
		this.affineTransform.setToRotation(radian, centerX, centerY);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.anchors.rotateAnchors(affineTransform, radian);
		this.rotateRate = this.rotateRate + radian;
		this.px = x;
		this.py = y;
	}

	public void finishRotating(Graphics2D graphics2d, int x, int y) {

	}

	public void initShearing(int x, int y) {
		this.px = x;
		this.py = y;
		// initAnchor = true;
	}

	public void keepShearing(Graphics2D graphics2d, int x, int y) {
		double oldW = this.shape.getBounds().getWidth();
		double oldX = this.shape.getBounds().getX();
		double rateShear = (this.px - x) / (this.shape.getBounds().getWidth() / 2);

		if (this.px < this.shape.getBounds().getX()) {
			this.px = (int) this.shape.getBounds().getX();
		} else if (this.px > (this.shape.getBounds().getX() + this.shape.getBounds().getWidth())) {
			this.px = (int) (this.shape.getBounds().getX() + this.shape.getBounds().getWidth());
		}

		if (x >= this.shape.getBounds().getX()
				&& x <= (this.shape.getBounds().getX() + this.shape.getBounds().getWidth())) {
			this.affineTransform.setToShear(rateShear, 0);
			this.shape = this.affineTransform.createTransformedShape(this.shape);

			this.affineTransform.setToScale(oldW / this.shape.getBounds().getWidth(), 1);
			this.shape = this.affineTransform.createTransformedShape(this.shape);

			this.affineTransform.setToTranslation(oldX - this.shape.getBounds().getX(), 0);
			this.shape = this.affineTransform.createTransformedShape(this.shape);
			this.anchors.changeGG(graphics2d, this.affineTransform, this.shape.getBounds().getBounds().getCenterX(),
					this.shape.getBounds().getBounds().getCenterY());
			this.px = x;
			this.py = y;
		}
	}

	public void finishShearing(Graphics2D graphics2d, int x, int y) {

	}

	public void setting() {
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.anchors.setBoundingRect(this.shape.getBounds());
	}

	public void setLineColor(Color color) {
		this.lineColor = color;
	}

	public void setFillColor(Color color) {
		this.fillColor = color;		
	}

}
