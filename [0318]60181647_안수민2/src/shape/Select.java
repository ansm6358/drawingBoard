package shape;

import java.awt.Graphics;

public class Select extends Shape {
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		graphics.drawRect(x, y, width, height);
	}
}