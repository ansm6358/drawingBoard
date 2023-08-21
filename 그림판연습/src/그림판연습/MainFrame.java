package 그림판연습;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private OptionPannel optionPannel;
	private CanvasPanel canvasPanel;
	
	public MainFrame()	{
		this.setTitle("그림판"); 
		this.setSize(800, 600);		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		ActionHandler actionHandler = new ActionHandler();
		this.optionPannel = new OptionPannel(actionHandler);
		this.add(optionPannel, BorderLayout.NORTH);
		
		this.canvasPanel = new CanvasPanel(actionHandler);
		this.add(canvasPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void initialize() {
		
	}

	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			
		}

	}
}
