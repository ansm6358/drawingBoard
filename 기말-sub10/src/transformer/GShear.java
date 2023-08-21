package transformer;

import java.awt.Color;
import java.awt.Graphics2D;

public class GShear extends GTransformer {

	@Override
	public void initTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().initShearing(x, y);
	}

	@Override
	public void keepTransforming(Graphics2D graphics2d, int x, int y, Color color) {
		this.getgShape().setColor(color);
		this.getgShape().draw(graphics2d);
		this.getgShape().keepShearing(graphics2d, x, y);
		this.getgShape().draw(graphics2d);
	}

	@Override
	public void finishTransforming(Graphics2D graphics2d, int x, int y) {
		this.getgShape().finishShearing(graphics2d, x, y);
	}

	@Override
	public void continueTransforming(Graphics2D graphics2d, int x, int y, Color background) {
		// TODO Auto-generated method stub
		
	}

}
