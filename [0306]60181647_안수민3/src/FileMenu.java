import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem newItem;
	public FileMenu(String text) {
		super(text);
		
		this.newItem = new JMenuItem("New");
		this.add(this.newItem);
	}

}
