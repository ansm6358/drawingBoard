package transformer;

import java.awt.Color;
import java.awt.Graphics2D;

public class GResizer extends GTransformer {

	@Override
	public void initTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().initResizing(x, y);
	}

	@Override
	public void keepTransforming(Graphics2D graphics2d, int x, int y, Color color) {
		this.getgShape().setColor(color);
		this.getgShape().draw(graphics2d);
		this.getgShape().keepResizing(graphics2d, x, y);
		this.getgShape().draw(graphics2d);
	}

	@Override
	public void finishTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().finishResizing(graphics2d, x, y);
	}

}
