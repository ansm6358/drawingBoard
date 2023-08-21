package shape;

import java.awt.Graphics;

public class Ellipse extends Shape {
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		if(width<0) {
			x = x+width;
			width=-width;
		}
		if(height<0) {
			y=y+height;
			height=-height;
		}
		graphics.drawOval(x, y, width, height);
	}
}
