package cn.mhope.jframe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestJFrame extends JFrame {
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2;
	private JLabel jl1,jl2;
	private JTextField jtf;
	
	public static void main(String[] args) {
		new TestJFrame();
	}

	public TestJFrame() {
		this.setTitle("标题栏");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		jb1.add("button");
		this.add(jb1);
		
		this.setVisible(true);
	}

}
