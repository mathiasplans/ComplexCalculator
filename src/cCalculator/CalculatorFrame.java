package cCalculator;

import java.awt.*;
import java.awt.event.*;
import com.singularsys.jep.*;
import javax.swing.*;

class CalculatorFrame extends JFrame implements ActionListener, KeyListener {

	private Jep jep;
	private GrammarCheck grammar;

	/* Tekstivaljad */
	private JTextField firstComplex = new JTextField("", 15),
	secondComplex = new JTextField("", 15);

	/* Nuppud */
	private JButton square = new JButton("z^2"),
	pow = new JButton("z^z"),
	ln = new JButton("ln"),
	ex = new JButton("e^z"),
	pi = new JButton("pi"),
	Argument = new JButton("arg"),
	Reverse = new JButton("<-"),
	Clear = new JButton("C"),

	sqrt = new JButton("\u221A"),
	x_rt = new JButton("z\u221A"),
	log = new JButton("log"),
	k7 = new JButton("7"),
	k8 = new JButton("8"),
	k9 = new JButton("9"),
	Multi = new JButton("X"),
	Div = new JButton("/"),

	sin = new JButton("sin"),
	cos = new JButton("cos"),
	tan = new JButton("tan"),
	k4 = new JButton("4"),
	k5 = new JButton("5"),
	k6 = new JButton("6"),
	plus = new JButton("+"),
	minus = new JButton("-"),

	asin = new JButton("asin"),
	acos = new JButton("acos"),
	atan = new JButton("atan"),
	k1 = new JButton("1"),
	k2 = new JButton("2"),
	k3 = new JButton("3"),
	abs = new JButton("|z|"),
	conjug = new JButton("z*"),

	sinh = new JButton("sinh"),
	cosh = new JButton("cosh"),
	tanh = new JButton("tanh"),
	k0 = new JButton("0"),
	point = new JButton("."),
	im = new JButton("i"),
	left_p = new JButton("("),
	right_p = new JButton(")");

	/**
	 * Konstruktor, konfigureerib raami, tekstivaljad ning nuppud.
	 * @param dimX X-ddimensiooni suurus
	 * @param dimY Y-dimensiooni suurus
	 * @param jep Jep objekt
	 * @param grammar GrammarCheck objekt
	 */
	CalculatorFrame(int dimX, int dimY, Jep jep, GrammarCheck grammar){

		JFrame frame = new JFrame("Complex Calculator");

		this.jep = jep;
		this.grammar = grammar;

		/* Raami seadistamine */
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(dimX, dimY));
		frame.setMaximumSize(new Dimension(dimX, dimY));
		frame.setMinimumSize(new Dimension(dimX, dimY));
		
		JPanel thePanel = new JPanel();

		thePanel.setLayout(null);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JLabel equals = new JLabel("=");

		/* Nuppude ja valjade seadistamine */
		firstComplex.setLocation(3, 3);
		firstComplex.setSize(dimX/3, dimY/7);

		secondComplex.setLocation(dimX/3 + 15 , 3);
		secondComplex.setSize(2*dimX/3 - 17, dimY/7 - 1);
		secondComplex.setEditable(false);

		equals.setLocation(dimX/3 + 3, 3);
		equals.setSize(11, dimY/7);

		thePanel.add(firstComplex);
		thePanel.add(secondComplex);
		thePanel.add(equals);

		square.setLocation(3, dimY/7 + 3);
		square.setSize(dimX/8 - 3, dimY/7 - 3);
		square.addActionListener(this);

		pow.setLocation(3 + dimX/8, dimY/7 + 3);
		pow.setSize(dimX/8 - 3, dimY/7 - 3);
		pow.addActionListener(this);

		ln.setLocation(3 + 2*dimX/8, dimY/7 + 3);
		ln.setSize(dimX/8 - 3, dimY/7 - 3);
		ln.addActionListener(this);

		ex.setLocation(3 + 3*dimX/8, dimY/7 + 3);
		ex.setSize(dimX/8 - 3, dimY/7 - 3);
		ex.addActionListener(this);

		pi.setLocation(3 + 4*dimX/8, dimY/7 + 3);
		pi.setSize(dimX/8 - 3, dimY/7 - 3);
		pi.addActionListener(this);

		Argument.setLocation(3 + 5*dimX/8, dimY/7 + 3);
		Argument.setSize(dimX/8 - 3, dimY/7 - 3);
		Argument.addActionListener(this);

		Reverse.setLocation(3 + 6*dimX/8, dimY/7 + 3);
		Reverse.setSize(dimX/8 - 3, dimY/7 - 3);
		Reverse.addActionListener(this);

		Clear.setLocation(3 + 7*dimX/8, dimY/7 + 3);
		Clear.setSize(dimX/8 - 3, dimY/7 - 3);
		Clear.addActionListener(this);
		
		thePanel.add(square);
		thePanel.add(pow);
		thePanel.add(ln);
		thePanel.add(ex);
		thePanel.add(pi);
		thePanel.add(Argument);
		thePanel.add(Reverse);
		thePanel.add(Clear);

		sqrt.setLocation(3, 2*dimY/7 + 3);
		sqrt.setSize(dimX/8 - 3, dimY/7 - 3);
		sqrt.addActionListener(this);

		x_rt.setLocation(3 + dimX/8, 2*dimY/7 + 3);
		x_rt.setSize(dimX/8 - 3, dimY/7 - 3);
		x_rt.addActionListener(this);

		log.setLocation(3 + 2*dimX/8, 2*dimY/7 + 3);
		log.setSize(dimX/8 - 3, dimY/7 - 3);
		log.addActionListener(this);

		k7.setLocation(3 + 3*dimX/8, 2*dimY/7 + 3);
		k7.setSize(dimX/8 - 3, dimY/7 - 3);
		k7.addActionListener(this);

		k8.setLocation(3 + 4*dimX/8, 2*dimY/7 + 3);
		k8.setSize(dimX/8 - 3, dimY/7 - 3);
		k8.addActionListener(this);

		k9.setLocation(3 + 5*dimX/8, 2*dimY/7 + 3);
		k9.setSize(dimX/8 - 3, dimY/7 - 3);
		k9.addActionListener(this);

		Multi.setLocation(3 + 6*dimX/8, 2*dimY/7 + 3);
		Multi.setSize(dimX/8 - 3, dimY/7 - 3);
		Multi.addActionListener(this);

		Div.setLocation(3 + 7*dimX/8, 2*dimY/7 + 3);
		Div.setSize(dimX/8 - 3, dimY/7 - 3);
		Div.addActionListener(this);

		thePanel.add(sqrt);
		thePanel.add(x_rt);
		thePanel.add(log);
		thePanel.add(k7);
		thePanel.add(k8);
		thePanel.add(k9);
		thePanel.add(Multi);
		thePanel.add(Div);

		sin.setLocation(3, 3*dimY/7 + 3);
		sin.setSize(dimX/8 - 3, dimY/7 - 3);
		sin.addActionListener(this);

		cos.setLocation(3 + dimX/8, 3*dimY/7 + 3);
		cos.setSize(dimX/8 - 3, dimY/7 - 3);
		cos.addActionListener(this);

		tan.setLocation(3 + 2*dimX/8, 3*dimY/7 + 3);
		tan.setSize(dimX/8 - 3, dimY/7 - 3);
		tan.addActionListener(this);

		k4.setLocation(3 + 3*dimX/8, 3*dimY/7 + 3);
		k4.setSize(dimX/8 - 3, dimY/7 - 3);
		k4.addActionListener(this);

		k5.setLocation(3 + 4*dimX/8, 3*dimY/7 + 3);
		k5.setSize(dimX/8 - 3, dimY/7 - 3);
		k5.addActionListener(this);

		k6.setLocation(3 + 5*dimX/8, 3*dimY/7 + 3);
		k6.setSize(dimX/8 - 3, dimY/7 - 3);
		k6.addActionListener(this);

		plus.setLocation(3 + 6*dimX/8, 3*dimY/7 + 3);
		plus.setSize(dimX/8 - 3, dimY/7 - 3);
		plus.addActionListener(this);

		minus.setLocation(3 + 7*dimX/8, 3*dimY/7 + 3);
		minus.setSize(dimX/8 - 3, dimY/7 - 3);
		minus.addActionListener(this);
		
		thePanel.add(sin);
		thePanel.add(cos);
		thePanel.add(tan);
		thePanel.add(k4);
		thePanel.add(k5);
		thePanel.add(k6);
		thePanel.add(plus);
		thePanel.add(minus);

		asin.setLocation(3, 4*dimY/7 + 3);
		asin.setSize(dimX/8 - 3, dimY/7 - 3);
		asin.addActionListener(this);

		acos.setLocation(3 + dimX/8, 4*dimY/7 + 3);
		acos.setSize(dimX/8 - 3, dimY/7 - 3);
		acos.addActionListener(this);

		atan.setLocation(3 + 2*dimX/8, 4*dimY/7 + 3);
		atan.setSize(dimX/8 - 3, dimY/7 - 3);
		atan.addActionListener(this);

		k1.setLocation(3 + 3*dimX/8, 4*dimY/7 + 3);
		k1.setSize(dimX/8 - 3, dimY/7 - 3);
		k1.addActionListener(this);

		k2.setLocation(3 + 4*dimX/8, 4*dimY/7 + 3);
		k2.setSize(dimX/8 - 3, dimY/7 - 3);
		k2.addActionListener(this);

		k3.setLocation(3 + 5*dimX/8, 4*dimY/7 + 3);
		k3.setSize(dimX/8 - 3, dimY/7 - 3);
		k3.addActionListener(this);

		abs.setLocation(3 + 6*dimX/8, 4*dimY/7 + 3);
		abs.setSize(dimX/8 - 3, dimY/7 - 3);
		abs.addActionListener(this);

		conjug.setLocation(3 + 7*dimX/8, 4*dimY/7 + 3);
		conjug.setSize(dimX/8 - 3, dimY/7 - 3);
		conjug.addActionListener(this);

		thePanel.add(asin);
		thePanel.add(acos);
		thePanel.add(atan);
		thePanel.add(k1);
		thePanel.add(k2);
		thePanel.add(k3);
		thePanel.add(abs);
		thePanel.add(conjug);

		sinh.setLocation(3, 5*dimY/7 + 3);
		sinh.setSize(dimX/8 - 3, dimY/7 - 3);
		sinh.addActionListener(this);

		cosh.setLocation(3 + dimX/8, 5*dimY/7 + 3);
		cosh.setSize(dimX/8 - 3, dimY/7 - 3);
		cosh.addActionListener(this);

		tanh.setLocation(3 + 2*dimX/8, 5*dimY/7 + 3);
		tanh.setSize(dimX/8 - 3, dimY/7 - 3);
		tanh.addActionListener(this);

		k0.setLocation(3 + 3*dimX/8, 5*dimY/7 + 3);
		k0.setSize(dimX/8 - 3, dimY/7 - 3);
		k0.addActionListener(this);

		point.setLocation(3 + 4*dimX/8, 5*dimY/7 + 3);
		point.setSize(dimX/8 - 3, dimY/7 - 3);
		point.addActionListener(this);

		im.setLocation(3 + 5*dimX/8, 5*dimY/7 + 3);
		im.setSize(dimX/8 - 3, dimY/7 - 3);
		im.addActionListener(this);

		left_p.setLocation(3 + 6*dimX/8, 5*dimY/7 + 3);
		left_p.setSize(dimX/8 - 3, dimY/7 - 3);
		left_p.addActionListener(this);

		right_p.setLocation(3 + 7*dimX/8, 5*dimY/7 + 3);
		right_p.setSize(dimX/8 - 3, dimY/7 - 3);
		right_p.addActionListener(this);

		thePanel.add(sinh);
		thePanel.add(cosh);
		thePanel.add(tanh);
		thePanel.add(k0);
		thePanel.add(point);
		thePanel.add(im);
		thePanel.add(left_p);
		thePanel.add(right_p);

		/* Klaviatuuri kuulaja lisamine */
		firstComplex.addKeyListener(this);
		
		frame.add(thePanel);
		
		frame.setVisible(true);
	}

	/**
	 * Funktsioon, mis editib esimest tektivalja
	 * @param str tekstivalja listatav sone
	 */
	private void appendTextField(String str){
		firstComplex.setText(firstComplex.getText() + str);
	}

	/**
	 * Nuppude kuulaja
	 * @param e action event
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(square)) appendTextField("^2");
		else if(e.getSource().equals(pow)) appendTextField("^");
		else if(e.getSource().equals(ln)) appendTextField("ln(");
		else if(e.getSource().equals(ex)) appendTextField("e^");
		else if(e.getSource().equals(pi)) appendTextField("pi");
		else if(e.getSource().equals(Argument)) appendTextField("arg(");
		else if(e.getSource().equals(Reverse)){ // backspace
			if(firstComplex.getText().length() != 0) firstComplex.setText(firstComplex.getText().substring(0, firstComplex.getText().length()-1));
		}
		else if(e.getSource().equals(Clear)) firstComplex.setText(""); // full clear

		else if(e.getSource().equals(sqrt)) appendTextField("sqrt(");
		else if(e.getSource().equals(x_rt)) appendTextField("^(1/");
		else if(e.getSource().equals(log)) appendTextField("log(");
		else if(e.getSource().equals(k7)) appendTextField("7");
		else if(e.getSource().equals(k8)) appendTextField("8");
		else if(e.getSource().equals(k9)) appendTextField("9");
		else if(e.getSource().equals(Multi)) appendTextField("*");
		else if(e.getSource().equals(Div)) appendTextField("/");

		else if(e.getSource().equals(sin)) appendTextField("sin(");
		else if(e.getSource().equals(cos)) appendTextField("cos(");
		else if(e.getSource().equals(tan)) appendTextField("tan(");
		else if(e.getSource().equals(k4)) appendTextField("4");
		else if(e.getSource().equals(k5)) appendTextField("5");
		else if(e.getSource().equals(k6)) appendTextField("6");
		else if(e.getSource().equals(plus)) appendTextField("+");
		else if(e.getSource().equals(minus)) appendTextField("-");

		else if(e.getSource().equals(asin)) appendTextField("asin(");
		else if(e.getSource().equals(acos)) appendTextField("acos(");
		else if(e.getSource().equals(atan)) appendTextField("atan(");
		else if(e.getSource().equals(k1)) appendTextField("1");
		else if(e.getSource().equals(k2)) appendTextField("2");
		else if(e.getSource().equals(k3)) appendTextField("3");
		else if(e.getSource().equals(abs)) appendTextField("cmod(");
		else if(e.getSource().equals(conjug)) appendTextField("conj(");

		else if(e.getSource().equals(sinh)) appendTextField("sinh(");
		else if(e.getSource().equals(cosh)) appendTextField("cosh(");
		else if(e.getSource().equals(tanh)) appendTextField("tanh(");
		else if(e.getSource().equals(k0)) appendTextField("0");
		else if(e.getSource().equals(point)) appendTextField(".");
		else if(e.getSource().equals(im)) appendTextField("i");
		else if(e.getSource().equals(left_p)) appendTextField("(");
		else if(e.getSource().equals(right_p)) appendTextField(")");

		// Vastuse uuendus
		updateSecondField();

	}

	/**
	 * Kalviatuuri kuulaja, prindib konsooli vajautatud nuppu koodi
	 * @param e key event
	 */
	public void keyTyped(KeyEvent e){
		System.out.println("Key pressed: KeyCode " + e.getKeyCode());
	}

	/**
	 * Klaviatuuri kuulaja, tuhi, kuna pole vaja tuvastada nuppu vajutust
	 * @param e key event
	 */
	public void keyPressed(KeyEvent e){

	}

	/**
	 * Klaviatuuri kuulaja, uuendab teist tekstivalja ehk vastuse valja, toimub hetkel, kui nupp lahti lastakse
	 * @param e key event
	 */
	public void keyReleased(KeyEvent e){
		updateSecondField();
	}

	/**
	 * Funktsioon, mis kutsub valja teise tekstivalja uuendamise
	 */
	private void updateSecondField(){
		/* Kui esimeses tekstivaljas tekst pole parsitav, siis taganeb */
		if(!grammar.isParsable(firstComplex.getText())) return;

		try {
			jep.parse(firstComplex.getText()); // Esimese tekstivalja parsimine
			String result = jep.evaluate().toString(); // evalueerib ekspressiooni, tagastab stringi
			// vormistab String sedasi, et oleks re,im
			result = result.replace("(", "").replace(")", "").replace(" ", "");
			String Re = result.split(",")[0]; // omistab reaalarvu
			String Im = "0"; // omistab imaginaararvu nulliks
			if(result.split(",").length > 1) Im = result.split(",")[1]; // Kui vastuses on reall- ja imaginaararv, siis omistab ka imaginaararvu
			if(Im.contains("-")){ // Kui imaginaararv on negatiivne, siis prindib maaratud vormistusega
				Im = Im.replace("-", "");
				secondComplex.setText(Re + " - " + Im + "i");
			}else if(Double.valueOf(Im) == 0) secondComplex.setText(Re); // Kui imaginaararv on 0, siis valjastab ainult reaalarvu
			else if(Double.valueOf(Re) == 0) secondComplex.setText(Im + "i"); // Kui reaalarv on 0, siis valjastab ainult imaginaararvu
			else secondComplex.setText(Re + " + " + Im + "i"); // Kui molemad positiivsed, siis valjastab maaratud vormistusega
		} catch (JepException exception) { // exception handling
			System.err.println("An error occurred: " + exception.getMessage());
		}
	}
}
