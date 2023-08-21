package shape;

import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.util.Vector;

public class GHeart extends GShape {
	private static final long serialVersionUID = 1L;
	 //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	private Area area;
	private Vector<Arc2D> arc;
	
	public GHeart() {
		super();
		this.shape = new Area();
		this.area = (Area)this.shape;
		this.arc = new Vector<Arc2D>();
		this.arc.add(new Arc2D.Double(0,0,0,0,180,180,Arc2D.OPEN));
		
		this.arc.add(new Arc2D.Double(0,0,0,0,0,180,Arc2D.OPEN));
		this.arc.add(new Arc2D.Double(0,0,0,0,0,180,Arc2D.OPEN));

	}
		
	public void setOrigin(int x, int y) {
		this.px = x;
		this.py = y;
	}
	
	public void setPoint(int x, int y) {
		this.area.reset();
		double w = x-this.px;
		double h = y-this.py;
		
		this.arc.get(0).setFrame(this.px, this.py, w, h);
		
		this.arc.get(1).setFrame(this.px, this.py+h/2-w/4, w/2, w/2);
		this.arc.get(2).setFrame(this.px+w/2, this.py+h/2-w/4, w/2, w/2);
		
		
		for(Arc2D arc2d:this.arc) {
			Area tempArea = new Area(arc2d);
			
			this.area.add(tempArea);
		}

	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GHeart();
	}

}