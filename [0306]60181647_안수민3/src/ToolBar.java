import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	private JButton selectionButton;
	
	public ToolBar() {
		this.selectionButton = new JButton("Select");
		this.add(this.selectionButton);
	}
}
