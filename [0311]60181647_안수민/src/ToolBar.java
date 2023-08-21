import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	//components
	private ButtonGroup buttonGroup;
	private JToggleButton selectionButton;
	private JToggleButton rectangleButton;
	private JToggleButton ellipseButton;
	private JToggleButton lineButton;
	
	//associations
	private DrawingPanel drawingPanel;
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}	
	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();
		this.buttonGroup = new ButtonGroup();
		
		this.selectionButton = new JToggleButton("Select", new ImageIcon("Sel.png"));
		this.add(this.selectionButton);
		this.selectionButton.setActionCommand(this.selectionButton.getName());
		this.selectionButton.addActionListener(actionHandler);
		this.buttonGroup.add(this.selectionButton);
		
		this.rectangleButton = new JToggleButton("Rectangle", new ImageIcon("Rec.png"));
		this.add(this.rectangleButton);
		this.rectangleButton.setActionCommand(this.rectangleButton.getName());
		this.rectangleButton.addActionListener(actionHandler);
		this.buttonGroup.add(this.rectangleButton);
		
		this.ellipseButton = new JToggleButton("Ellipse",new ImageIcon("Oval.png"));
		this.add(this.ellipseButton);
		this.ellipseButton.setActionCommand(this.ellipseButton.getName());
		this.ellipseButton.addActionListener(actionHandler);
		this.buttonGroup.add(this.ellipseButton);

		this.lineButton = new JToggleButton("Line",new ImageIcon("Line.png"));
		this.add(this.lineButton);
		this.lineButton.setBackground(null);
		this.lineButton.setActionCommand(this.lineButton.getName());
		this.lineButton.addActionListener(actionHandler);
		this.buttonGroup.add(this.lineButton);
		}
	
	private class ActionHandler implements ActionListener	{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			drawingPanel.setCurrentTool(event.getActionCommand());
			
		}
		
	}


}
