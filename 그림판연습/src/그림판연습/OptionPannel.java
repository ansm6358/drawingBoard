package �׸��ǿ���;

import javax.swing.JButton;
import javax.swing.JPanel;

import �׸��ǿ���.MainFrame.ActionHandler;

public class OptionPannel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btColor;
	private JButton btPlus;
	private JButton btMinus;
	private JButton btDel;
	private JButton btAllDel;
	
	public OptionPannel(ActionHandler actionHandler) {
		
		this.btColor = new JButton("����");
		this.btColor.addActionListener(actionHandler);
		this.btColor.setActionCommand("����");
		this.add(this.btColor);
		
		this.btPlus = new JButton("+");
		this.btPlus.addActionListener(actionHandler);
		this.btPlus.setActionCommand("+");
		this.add(this.btPlus);
		
		this.btMinus = new JButton("-");
		this.btMinus.addActionListener(actionHandler);
		this.btMinus.setActionCommand("-");
		this.add(this.btMinus);
		
		this.btDel = new JButton("�����");
		this.btDel.addActionListener(actionHandler);
		this.btDel.setActionCommand("�����");
		this.add(this.btDel);
		
		this.btAllDel = new JButton("�ʱ�ȭ");
		this.btAllDel.addActionListener(actionHandler);
		this.btAllDel.setActionCommand("�ʱ�ȭ");
		this.add(this.btAllDel);
	}
}
