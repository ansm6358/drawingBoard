package transform;

import java.awt.Graphics2D;

public class Resize extends Transformer {

	public void initAction(Graphics2D graphics2d, int x, int y, Object object) {
		this.px = x;
		this.py = y;
		

	}
	public void keepAction(Graphics2D graphics2d, int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
