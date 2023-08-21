package transform;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public abstract class Transformer {

	protected AffineTransform affineTransform;
	protected java.awt.Shape shape;

	protected int px;
	protected int py;
	
	public abstract void initAction(Graphics2D graphics2d, int x, int y, Object object);

	public abstract void keepAction(Graphics2D graphics2d, int x, int y);

	public Object getShape() {
		return this.shape;
	}

	public void finishAction() {
		
	}
	
}
