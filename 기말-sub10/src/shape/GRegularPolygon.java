package shape;

import javax.swing.JOptionPane;

public class GRegularPolygon extends GShape {
	private static final long serialVersionUID = 1L;
	private java.awt.Polygon polygon;
	private int vertex;
	private int tempX;
	private int tempY;
	private double angle;
	private char first =0x30; //0
	private char last = 0x39; //9
	
	public GRegularPolygon() {
		super();
		this.shape = new java.awt.Polygon();
		this.polygon = (java.awt.Polygon) this.shape;

	}

	private void setVertex() {
		boolean num = true;
		int currenVal = 0;
		String vt = JOptionPane.showInputDialog("����� �׸��ڽ��ϱ�? (3�̻��� �ڿ����� �Է����ּ���)");
		if(vt != null) {
		for(int i =0; i<vt.length(); i++) {
			 if(vt.charAt(i)>=first && vt.charAt(i)<=last) //������ ���
			currenVal = currenVal*10 + (vt.charAt(i) & 0x0F); //00001111 and ���Ѽ� �ƽ�Űĳ���ͷ� ���������� ��ȯ			
		
			else { //���ڰ� �ƴѰ��
				num = false;
			}
		}
		} 
		
		if(num && (currenVal >3)) {
			this.vertex = Integer.parseInt(vt);
		} else {
						JOptionPane.showMessageDialog(null,"3�̻��� �ڿ����� �ƴմϴ�, �ڵ����� �ﰢ������ �����˴ϴ�.", "error",JOptionPane.INFORMATION_MESSAGE);
						this.vertex = 3;
		}
	}

	public void setOrigin(int x, int y) {
		this.setVertex();
		this.polygon.addPoint(x, y);
		this.px = x;
		this.py = y;
		
		double firstangle = 360 / this.vertex;
		this.angle = Math.toRadians(firstangle);
	}

	public void setPoint(int x, int y) {
		this.polygon.reset();
		
		double cx = (this.px + x) / 2;
		double cy = (this.py + y) / 2;
		
		this.tempX = (this.px + x) / 2;
		this.tempY = this.py;	
		this.polygon.addPoint(this.tempX, this.tempY);
		
		for (int i = 1; i < this.vertex; i++) {
			int tempX1 = this.newPointX(this.tempX, this.tempY, cx, cy, this.angle);
			int tempY1 = this.newPointY(this.tempX, this.tempY, cx, cy, this.angle);
			this.polygon.addPoint(tempX1, tempY1);
			this.tempX = tempX1;
			this.tempY = tempY1;
		}
	}
	
	public void addPoint(int x, int y) {
	}
	
	public GShape newInstance() {
		return new GRegularPolygon();
	}
	
	private int newPointX(double x, double y, double cx, double cy, double angle) {
		int changePoint = (int) ((x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle) + cx);

		return changePoint;
	}

	private int newPointY(int x, int y, double cx, double cy, double angle) {
		int changePoint = (int) ((x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle) + cy);
		return changePoint;
	}
	
}