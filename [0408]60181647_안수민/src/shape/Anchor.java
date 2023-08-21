package shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.Vector;

public class Anchor {
	private Ellipse2D.Double ellipse;
	private Vector<Ellipse2D.Double> ellipseVector;
	private int height = 10;
	private int width = 10;
	
	public Anchor() {
		
		this.ellipse = new Ellipse2D.Double();
	}

	public void setLocation(int bx, int by, int lx, int ly) {
		this.ellipseVector = new Vector<Ellipse2D.Double>();
		this.ellipse.setFrame(bx+lx-height/2, by-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx-lx-height/2, by-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx-height/2, by+ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx-height/2, by-ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx+lx-height/2, by+ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx-lx-height/2, by+ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx+lx-height/2, by-ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
		
		this.ellipse.setFrame(bx-lx-height/2, by-ly-width/2, height, width);
		this.ellipseVector.add((Double) this.ellipse.clone());
	}

	public void draw(Graphics2D graphics2d) {
		
		for(Ellipse2D dEllipse: this.ellipseVector) {
			graphics2d.draw(dEllipse);
		}
	}

	public void moveAnchor(Graphics2D graphics2d, int mx, int my) {
		for(Ellipse2D dEllipse: this.ellipseVector) {
			dEllipse.setFrame(dEllipse.getX()+mx, dEllipse.getY()+my, dEllipse.getWidth(), dEllipse.getHeight());
			
		}
	}

}
