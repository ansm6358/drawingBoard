import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	//components
	private JButton selectionButton;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton lineButton;
	
	//associations
	private DrawingPanel drawingPanel;
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}	
	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();
		
		this.selectionButton = new JButton("Select");
		this.add(this.selectionButton);
		this.selectionButton.setActionCommand(this.selectionButton.getName());
		this.selectionButton.addActionListener(actionHandler);
		
		this.rectangleButton = new JButton("Rectangle");
		this.add(this.rectangleButton);
		this.rectangleButton.setActionCommand(this.rectangleButton.getName());
		this.rectangleButton.addActionListener(actionHandler);
		
		this.ellipseButton = new JButton("Ellipse");
		this.add(this.ellipseButton);
		this.ellipseButton.setActionCommand(this.ellipseButton.getName());
		this.ellipseButton.addActionListener(actionHandler);
		
		this.lineButton = new JButton("Line");
		this.add(this.lineButton);
		this.lineButton.setBackground(null);
		this.lineButton.setActionCommand(this.lineButton.getName());
		this.lineButton.addActionListener(actionHandler);
		}
	
	private class ActionHandler implements ActionListener	{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals("Select")) {
				selectionButton.setBackground(Color.GRAY);
				rectangleButton.setBackground(null);
				ellipseButton.setBackground(null);
				lineButton.setBackground(null);
			} else if(event.getActionCommand().equals("Rectangle")) {
				selectionButton.setBackground(null);
				rectangleButton.setBackground(Color.GRAY);
				ellipseButton.setBackground(null);
				lineButton.setBackground(null);
			} else if(event.getActionCommand().equals("Ellipse")) {
				selectionButton.setBackground(null);
				rectangleButton.setBackground(null);
				ellipseButton.setBackground(Color.GRAY);
				lineButton.setBackground(null);
			} else if(event.getActionCommand().equals("Line")) {
				selectionButton.setBackground(null);
				rectangleButton.setBackground(null);
				ellipseButton.setBackground(null);
				lineButton.setBackground(Color.GRAY);
			}
			
			drawingPanel.setCurrentTool(event.getActionCommand());
			
		}
		
	}


}
