package shape;

public class ex {
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Shape;
	import java.awt.font.GlyphVector;
	import java.awt.image.BufferedImage;
	/*from www  .j a  v  a2 s. c  o  m*/
	import javax.swing.JComponent;
	import javax.swing.JFrame;

	class MyCanvas extends JComponent {
	  public void paint(Graphics g) {
	    Graphics2D g2d = (Graphics2D) g;

	    Shape s = generateShapeFromText(new Font("Purisa", Font.ITALIC.PLAIN, 80), "java2s.com");
	    g2d.draw(s);
	  }
	  public static Shape generateShapeFromText(Font font, char ch) {
	    return generateShapeFromText(font, String.valueOf(ch));
	  }

	  public static Shape generateShapeFromText(Font font, String string) {
	    BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = img.createGraphics();

	    try {
	      GlyphVector vect = font.createGlyphVector(g2.getFontRenderContext(), string);
	      Shape shape = vect.getOutline(0f, (float) -vect.getVisualBounds().getY());

	      return shape;
	    } finally {
	      g2.dispose();
	    }
	  }
	}

	public class Main {
	  public static void main(String[] a) {
	    JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(30, 30, 450, 450);
	    window.getContentPane().add(new MyCanvas());
	    window.setVisible(true);
	  }
	}

}
