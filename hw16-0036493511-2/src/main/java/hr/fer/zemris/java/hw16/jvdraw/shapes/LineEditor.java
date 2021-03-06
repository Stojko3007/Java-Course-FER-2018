package hr.fer.zemris.java.hw16.jvdraw.shapes;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Predstavlja panel koji nudi opcije promjene svakog svojstva dužine.
 * 
 * @author Filip
 *
 */
public class LineEditor extends GeometricalObjectEditor {
	/**
	 * Serijska vrijednost UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Prostor za unos X0.
	 */
	private JTextArea area1;
	/**
	 * Prostor za unos Y0.
	 */
	private JTextArea area2;
	/**
	 * Prostor za unos X1.
	 */
	private JTextArea area3;
	/**
	 * Prostor za unos Y1.
	 */
	private JTextArea area4;
	/**
	 * Prostor za unos crvene boje.
	 */
	private JTextArea area5;
	/**
	 * Prostor za unos zelene boje.
	 */
	private JTextArea area6;
	/**
	 * Prostor za unos plave boje.
	 */
	private JTextArea area7;
	/**
	 * Linija koja se editira.
	 */
	private Line line;
	/**
	 * X0.
	 */
	private int x0;
	/**
	 * X1.
	 */
	private int x1;
	/**
	 * Y0.
	 */
	private int y0;
	/**
	 * Y1.
	 */
	private int y1;
	/**
	 * Crvena.
	 */
	private int r;
	/**
	 * Zelena.
	 */
	private int g;
	/**
	 * Plava.
	 */
	private int b;

	/**
	 * Konstruktor.
	 * 
	 * @param line
	 *            linija koja se editira
	 */
	public LineEditor(Line line) {
		this.line = line;

		JPanel first = new JPanel();
		JLabel startPointX = new JLabel("X0: ");
		first.add(startPointX);
		area1 = new JTextArea(String.valueOf(line.getStartPoint().x), 1, 3);
		first.add(area1);

		JPanel second = new JPanel();
		JLabel startPointY = new JLabel("Y0: ");
		first.add(startPointY);
		area2 = new JTextArea(String.valueOf(line.getStartPoint().y), 1, 3);
		first.add(area2);

		JPanel third = new JPanel();
		JLabel endPointX = new JLabel("X1: ");
		first.add(endPointX);
		area3 = new JTextArea(String.valueOf(line.getEndPoint().x), 1, 3);
		first.add(area3);

		JPanel fourth = new JPanel();
		JLabel endPointY = new JLabel("Y1: ");
		first.add(endPointY);
		area4 = new JTextArea(String.valueOf(line.getEndPoint().y), 1, 3);
		first.add(area4);

		JPanel fifth = new JPanel();
		JLabel red = new JLabel("red: ");
		first.add(red);
		area5 = new JTextArea(String.valueOf(line.getColor().getRed()), 1, 3);
		first.add(area5);

		JPanel sixth = new JPanel();
		JLabel green = new JLabel("green: ");
		first.add(green);
		area6 = new JTextArea(String.valueOf(line.getColor().getGreen()), 1, 3);
		first.add(area6);

		JPanel seventh = new JPanel();
		JLabel blue = new JLabel("blue: ");
		first.add(blue);
		area7 = new JTextArea(String.valueOf(line.getColor().getBlue()), 1, 3);
		first.add(area7);

		add(first);
		add(second);
		add(third);
		add(fourth);
		add(fifth);
		add(sixth);
		add(seventh);
	}

	@Override
	public void checkEditing() {
		try {
			String input1 = area1.getText();
			x0 = Integer.parseInt(input1);
			String input2 = area2.getText();
			y0 = Integer.parseInt(input2);
			String input3 = area3.getText();
			x1 = Integer.parseInt(input3);
			String input4 = area4.getText();
			y1 = Integer.parseInt(input4);
			String input5 = area5.getText();
			r = Integer.parseInt(input5);
			String input6 = area6.getText();
			g = Integer.parseInt(input6);
			String input7 = area7.getText();
			b = Integer.parseInt(input7);

			if (!((r >= 0 && r <= 255) && (g >= 0 && g <= 255) && (b >= 0 && b <= 255))) {
				throw new RuntimeException("Colors have to be from interval: [0,255].");
			}
			if (!(x0 >= 0 && y0 >= 0 && x1 >= 0 && y1 >= 0)) {
				throw new RuntimeException("The coordinates of the points have to be positive.");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void acceptEditing() {
		line.editLine(new Line(new Point(x0, y0), new Point(x1, y1), new Color(r, g, b)));
		line.listeners.forEach(l -> l.geometricalObjectChanged(line));
	}

}
