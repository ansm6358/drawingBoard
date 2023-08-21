package menu;
import javax.swing.JMenuBar;

import drawingPanel.GDrawingPanel;
import global.Constants.EMenu;

public class GMenuBar extends JMenuBar {  //***�̰� ���� �ſ� �߿�
	//attributes
	private static final long serialVersionUID = 1L;

	//components
	private GFileMenu fileMenu;
	private GEditMenu editMenu;
	private GColorMenu colorMenu;
	
	//associations
	private GDrawingPanel drawingPanel;
	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}		
	
	public GMenuBar() {
		//initialize attribute
		
		//create components
		this.fileMenu = new GFileMenu(EMenu.filemenu.getText());
		this.add(this.fileMenu);
		
		this.editMenu = new GEditMenu(EMenu.editmenu.getText());
		this.add(this.editMenu);
		
		this.colorMenu = new GColorMenu(EMenu.colormenu.getText());
		this.add(this.colorMenu);
			
	}

	public void initialize() {
		//associate
		this.fileMenu.associate(this.drawingPanel);
		this.editMenu.associate(this.drawingPanel);
		this.colorMenu.associate(this.drawingPanel);
		
		//initialize components
		this.fileMenu.initialize();
		this.editMenu.initialize();
		this.colorMenu.initialize();
	}


}
