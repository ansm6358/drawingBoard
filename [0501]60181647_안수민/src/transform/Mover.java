package transform;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Mover extends Transformer {

	public void initAction(Graphics2D graphics2d, int x, int y, Object object) {
		this.px = x;
		this.py = y;
		this.shape = (Shape) object;

	}
	public void keepAction(Graphics2D graphics2d, int x, int y) {
		this.affineTransform = new AffineTransform();
		int dw = x - this.px;
		int dh = y - this.py;
		this.affineTransform.translate(dw, dh);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		this.px = x;
		this.py = y;
	}
}
