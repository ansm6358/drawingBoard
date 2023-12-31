package Mouse;

import java.awt.Cursor;
import java.util.Vector;

public class GCursorChanger extends Vector<Cursor> {
	private static final long serialVersionUID = 1L;
	
	public GCursorChanger() {
		add(new Cursor(Cursor.NW_RESIZE_CURSOR));
		add(new Cursor(Cursor.N_RESIZE_CURSOR));
		add(new Cursor(Cursor.NE_RESIZE_CURSOR));
		add(new Cursor(Cursor.E_RESIZE_CURSOR));
		add(new Cursor(Cursor.SE_RESIZE_CURSOR));
		add(new Cursor(Cursor.S_RESIZE_CURSOR));
		add(new Cursor(Cursor.SW_RESIZE_CURSOR));
		add(new Cursor(Cursor.W_RESIZE_CURSOR));
		add(new Cursor(Cursor.WAIT_CURSOR));
		add(new Cursor(Cursor.HAND_CURSOR));
	}

}
