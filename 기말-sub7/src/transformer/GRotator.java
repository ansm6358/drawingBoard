package transformer;

import java.awt.Color;
import java.awt.Graphics2D;

public class GRotator extends GTransformer {

	@Override
	public void initTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().initRotating(x, y);
	}

	@Override
	public void keepTransforming(Graphics2D graphics2d, int x, int y, Color color) {
		this.getgShape().setColor(color);
		this.getgShape().draw(graphics2d);
		this.getgShape().keepRotating(graphics2d, x, y);
		this.getgShape().draw(graphics2d);
	}

	@Override
	public void finishTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().finishRotating(graphics2d, x, y);
	}

}
