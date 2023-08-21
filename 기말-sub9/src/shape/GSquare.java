package shape;

public class GSquare extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Rectangle rectangle; //������ ������ ���� ������ ���ٱ��� �ּҸ� ������� �Ѵ�.
	
	public GSquare() {
		super();
		this.shape = new java.awt.Rectangle();
		this.rectangle = (java.awt.Rectangle)this.shape;
	}
		
	public void setOrigin(int x, int y) {
		this.rectangle.setBounds(x,y,0,0);
		
	}
	public void setPoint(int x, int y) {
		if(x-this.rectangle.x>y-this.rectangle.y) {
		this.rectangle.setSize(y-this.rectangle.y, y-this.rectangle.y);
		} else {
			this.rectangle.setSize(x-this.rectangle.x, x-this.rectangle.x);
		}
	}
	public void addPoint(int x, int y) {
	}

	public GShape newInstance() {
		return new GSquare();
	}

}