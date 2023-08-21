package 그림판연습;

import javax.swing.JButton;
import javax.swing.JPanel;

import 그림판연습.MainFrame.ActionHandler;

public class OptionPannel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btColor;
	private JButton btPlus;
	private JButton btMinus;
	private JButton btDel;
	private JButton btAllDel;
	
	public OptionPannel(ActionHandler actionHandler) {
		
		this.btColor = new JButton("색상");
		this.btColor.addActionListener(actionHandler);
		this.btColor.setActionCommand("색상");
		this.add(this.btColor);
		
		this.btPlus = new JButton("+");
		this.btPlus.addActionListener(actionHandler);
		this.btPlus.setActionCommand("+");
		this.add(this.btPlus);
		
		this.btMinus = new JButton("-");
		this.btMinus.addActionListener(actionHandler);
		this.btMinus.setActionCommand("-");
		this.add(this.btMinus);
		
		this.btDel = new JButton("지우기");
		this.btDel.addActionListener(actionHandler);
		this.btDel.setActionCommand("지우기");
		this.add(this.btDel);
		
		this.btAllDel = new JButton("초기화");
		this.btAllDel.addActionListener(actionHandler);
		this.btAllDel.setActionCommand("초기화");
		this.add(this.btAllDel);
	}
}
