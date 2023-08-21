import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;



public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	private JButton selectionButton;
	private JButton recButton;
	private JButton circleButton;
	
	public ToolBar(ActionListener actionHandler) {
		this.selectionButton = new JButton("Select");
		this.add(this.selectionButton);
		
		this.recButton = new JButton("사각형");
		this.recButton.setActionCommand("rec");
		this.recButton.addActionListener(actionHandler);
		this.add(this.recButton);
		
		this.circleButton = new JButton("원");
		this.circleButton.setActionCommand("cir");
		this.circleButton.addActionListener(actionHandler);
		this.add(this.circleButton);
	}
}
