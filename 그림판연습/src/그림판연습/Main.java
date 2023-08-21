package 그림판연습;


public class Main {

	private MainFrame mainFrame;
	
	public Main() {
		this.mainFrame = new MainFrame();
	}
	
	private void initialize() {
		this.mainFrame.initialize();
	}
	
	public static void main(String[] args) {
		Main main;
		main = new Main();
		main.initialize();
	}


}
