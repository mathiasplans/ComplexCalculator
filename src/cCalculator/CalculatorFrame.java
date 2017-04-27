package cCalculator;

import java.awt.Dimension;


import javax.swing.*;

public class CalculatorFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5000908503750404115L;
	JFrame frame = new JFrame("Complex Calculator");
	
	public CalculatorFrame(int dimX, int dimY, cCalculator c){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(dimX, dimY));
		frame.setMaximumSize(new Dimension(dimX, dimY));
		frame.setMinimumSize(new Dimension(dimX, dimY));
		
		JPanel thePanel = new JPanel(new SpringLayout());
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// info
		JLabel label5 = new JLabel("");
		JLabel label6 = new JLabel("");
		JLabel label7 = new JLabel("");
		JTextField firstComplex = new JTextField("", 15);
		JTextField secondComplex = new JTextField("", 15);
		JLabel product = new JLabel("= ");
		JLabel label8 = new JLabel("");
		JLabel label9 = new JLabel("");
		
		thePanel.add(label5);
		thePanel.add(label6);
		thePanel.add(label7);
		thePanel.add(firstComplex);
		thePanel.add(secondComplex);
		thePanel.add(product);
		thePanel.add(label8);
		thePanel.add(label9);
		
		JLabel label10 = new JLabel("");
		JLabel label11 = new JLabel("");
		JLabel label2 = new JLabel("");
		JLabel label3 = new JLabel("");
		JLabel label4 = new JLabel("");
		JLabel lastOp = new JLabel("");
		JLabel label12 = new JLabel("");
		JLabel label13 = new JLabel("");
		
		thePanel.add(label10);
		thePanel.add(label11);
		thePanel.add(label2);
		thePanel.add(label3);
		thePanel.add(label4);
		thePanel.add(lastOp);
		thePanel.add(label12);
		thePanel.add(label13);
		
		
		// control
		JButton square = new JButton("z^2");
		JButton pow = new JButton("z^z");
		JButton ln = new JButton("ln");
		JButton ex = new JButton("e^z");
		JButton pi = new JButton("pi");
		JButton Sign = new JButton("+/-");
		JButton Reverse = new JButton("<-");
		JButton Clear = new JButton("C");
		
		thePanel.add(square);
		thePanel.add(pow);
		thePanel.add(ln);
		thePanel.add(ex);
		thePanel.add(pi);
		thePanel.add(Sign);
		thePanel.add(Reverse);
		thePanel.add(Clear);
		
		JButton sqrt = new JButton("\u221A");
		JButton x_rt = new JButton("z\u221A");
		JButton log = new JButton("log");
		JButton k7 = new JButton("7");
		JButton k8 = new JButton("8");
		JButton k9 = new JButton("9");
		JButton Multi = new JButton("X");
		JButton Div = new JButton("/");
		
		thePanel.add(sqrt);
		thePanel.add(x_rt);
		thePanel.add(log);
		thePanel.add(k7);
		thePanel.add(k8);
		thePanel.add(k9);
		thePanel.add(Multi);
		thePanel.add(Div);
		
		JButton sin = new JButton("sin");
		JButton cos = new JButton("cos");
		JButton tan = new JButton("tan");
		JButton k4 = new JButton("4");
		JButton k5 = new JButton("5");
		JButton k6 = new JButton("6");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		
		thePanel.add(sin);
		thePanel.add(cos);
		thePanel.add(tan);
		thePanel.add(k4);
		thePanel.add(k5);
		thePanel.add(k6);
		thePanel.add(plus);
		thePanel.add(minus);
		
		JButton asin = new JButton("asin");
		JButton acos = new JButton("acos");
		JButton atan = new JButton("atan");
		JButton k1 = new JButton("1");
		JButton k2 = new JButton("2");
		JButton k3 = new JButton("3");
		JButton abs = new JButton("|z|");
		JButton conjug = new JButton("z*");
		
		thePanel.add(asin);
		thePanel.add(acos);
		thePanel.add(atan);
		thePanel.add(k1);
		thePanel.add(k2);
		thePanel.add(k3);
		thePanel.add(abs);
		thePanel.add(conjug);
		
		JButton sinh = new JButton("sinh");
		JButton cosh = new JButton("cosh");
		JButton tanh = new JButton("tanh");
		JButton k0 = new JButton("0");
		JButton point = new JButton(".");
		JButton im = new JButton("i");
		JButton Answ1 = new JButton("Ans1");
		JButton Answ2 = new JButton("Ans1");
		
		thePanel.add(sinh);
		thePanel.add(cosh);
		thePanel.add(tanh);
		thePanel.add(k0);
		thePanel.add(point);
		thePanel.add(im);
		thePanel.add(Answ1);
		thePanel.add(Answ2);
		
		
		
		SpringUtilities.makeGrid(thePanel, 
				7, 8, // rows/cols
				3, 3, // initX/initY
				3, 3  // padX/padY
				);
		
		frame.add(thePanel);
		
		
		
		frame.setVisible(true);
		
//		frame.add(c);
//		c.start();
	}
}
