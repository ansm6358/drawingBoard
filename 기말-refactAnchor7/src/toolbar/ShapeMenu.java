package toolbar;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

import shape.GShape;

public class ShapeMenu extends JMenu {

	private Vector<JRadioButton> buttons; 
	
	public ShapeMenu(GShape gShape) {
		super(); 
		JMenuItem b = new JMenuItem("qre");
		this.add(b);
		JMenuItem b1 = new JMenuItem("qresD");
		this.add(b1);
		JMenuItem b2 = new JMenuItem("qrefaf");
		this.add(b2);
		JMenuItem b3 = new JMenuItem("qreadf");
		this.add(b3);
	}

}
