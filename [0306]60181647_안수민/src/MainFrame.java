import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	
	public MainFrame() { 
		
		ActionListener actionHandler = new ActionHandler();
		
		// attributes = 속성, 값
		this.setLocation(200, 100);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// component = 자식
		this.menuBar = new MenuBar(actionHandler);
		this.setJMenuBar(this.menuBar);
	
		this.setLayout(new BorderLayout());
		this.toolBar = new ToolBar(actionHandler);
		this.add(this.toolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new DrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);	
		
		
			}
	private void changeShape(String Cshape) {
			this.drawingPanel.changeShape(Cshape);
		}
	class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			changeShape(e.getActionCommand());
		}

		
	}
}
