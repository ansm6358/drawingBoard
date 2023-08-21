import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	//components
	private FileMenu fileMenu;
	
	//associations
	private DrawingPanel drawingPanel;
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}		
	
	public MenuBar() {
		this.fileMenu = new FileMenu("file");
		this.add(this.fileMenu);
		
	}


}
