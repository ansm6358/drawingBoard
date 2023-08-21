package shape;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class GMoon extends GShape {
	private static final long serialVersionUID = 1L;
	 //렉시컬 스코프 상의 오류로 렉텐글의 주소를 적어줘야 한다.
	private Area area;
	private Ellipse2D ellipse, subEllipse;
	
	public GMoon() {
		super();
		this.shape = new Area();
		this.area = (Area)this.shape;
		this.ellipse = new Ellipse2D.Double();
		this.subEllipse = new Ellipse2D.Double();
	}
		
	public void setOrigin(int x, int y) {
		this.ellipse.setFrame(x, y, 0, 0);
		this.subEllipse.setFrame(x, y, 0, 0);
		this.px = x;
		this.py = y;
	}
	
	public void setPoint(int x, int y) {
		this.area.reset();
		double w = x-this.px;
		double h = y-this.py;
		
		this.ellipse.setFrame(this.px, this.py, w, h);
		this.subEllipse.setFrame(this.px+w/4,this.py, w, h);
		
		Area tempArea = new Area(this.ellipse);
		this.area.add(tempArea);
		
		Area tempArea2 = new Area(this.subEllipse);
		this.area.subtract(tempArea2);


	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GMoon();
	}

}