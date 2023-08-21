package drawingPanel;

import java.util.Vector;

import shape.GShape;

public class Clipboard {
	private Vector<GShape> shapes;
	private int redoCount;
	private int undoCount;
	private Vector<GShape>[] record;
	private boolean start;
	private int canRedo;
	
	public Clipboard() {
		this.shapes = new Vector<GShape>();
		this.record= new Vector[10];
		this.redoCount = 0;
		this.undoCount = -1;
		this.canRedo = 0;
		this.start = false;
	}
	public void setContents(Vector<GShape> shapes) {
		this.shapes.clear();
		this.shapes.addAll(shapes);
		
	}
	
	public Vector<GShape> getContents() {
		Vector<GShape> clonedshapes = new Vector<GShape>();
		for(GShape shape: this.shapes) {
			shape.setClone();
			GShape clonedshape = shape.clone();
			clonedshapes.add(clonedshape);
		}
		return clonedshapes;
	}
	public void setDo(Vector<GShape> shapeVector) {
		this.record[this.redoCount] =shapeVector;
		this.undoCount = -1;
		this.redoCount++;
		if(this.redoCount >=10) {
			this.redoCount = 0;
		}
		
	}
	public Object undo() {
		
		this.canRedo++;
		this.redoCount--;
		if(this.redoCount <0) {
		this.redoCount = 9;
		}
		return this.record[this.redoCount];
	}
	public void redo() {
		if(this.canRedo !=0) {
		this.canRedo--;
		
	}
	}
}
