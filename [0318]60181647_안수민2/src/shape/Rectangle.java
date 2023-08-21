package shape;

import java.awt.Graphics;

public class Rectangle extends Shape {
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		graphics.drawRect(x, y, width, height);
	}
}