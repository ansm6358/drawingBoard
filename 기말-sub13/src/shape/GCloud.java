package shape;

import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.util.Vector;

public class GCloud extends GShape {
	private static final long serialVersionUID = 1L;
	 //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	private Area area;
	private Vector<Arc2D> arc;
	private Rectangle rectangle;
	
	public GCloud() {
		super();
		this.shape = new Area();
		this.area = (Area)this.shape;
		this.arc = new Vector<Arc2D>();
		this.rectangle = new Rectangle();
		this.arc.add(new Arc2D.Double(0,0,0,0,90,180,Arc2D.OPEN));
		
		this.arc.add(new Arc2D.Double(0,0,0,0,0,180,Arc2D.OPEN));
		this.arc.add(new Arc2D.Double(0,0,0,0,0,180,Arc2D.OPEN));
		
		this.arc.add(new Arc2D.Double(0,0,0,0,270,180,Arc2D.OPEN));
		
		this.arc.add(new Arc2D.Double(0,0,0,0,180,180,Arc2D.OPEN));	
		this.arc.add(new Arc2D.Double(0,0,0,0,180,180,Arc2D.OPEN));
		this.arc.add(new Arc2D.Double(0,0,0,0,180,180,Arc2D.OPEN));
	}
		
	public void setOrigin(int x, int y) {
		this.px = x;
		this.py = y;
	}
	
	public void setPoint(int x, int y) {
		this.area.reset();
		double w = x-this.px;
		double h = y-this.py;
		this.rectangle.setFrame(this.px+w/6, this.py+h/4, w*2/3, h/2);
		
		this.arc.get(0).setFrame(this.px, this.py+h/4, w/3, h/2);
		
		this.arc.get(1).setFrame(this.px+w/6, this.py, w/3, h/2);
		this.arc.get(2).setFrame(this.px+w/2, this.py, w/3, h/2);
		
		this.arc.get(3).setFrame(this.px+w*2/3, this.py+h/4, w/3, h/2);
		
		this.arc.get(4).setFrame(this.px+w*11/18, this.py+h/2, w*2/9, h/2);
		this.arc.get(5).setFrame(this.px+w*7/18, this.py+h/2, w*2/9, h/2);
		this.arc.get(6).setFrame(this.px+w/6, this.py+h/2, w*2/9, h/2);
		
		for(Arc2D arc2d:this.arc) {
			Area tempArea = new Area(arc2d);
			
			this.area.add(tempArea);
		}
		Area tempArea = new Area(this.rectangle);
		this.area.add(tempArea);
	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GCloud();
	}

}