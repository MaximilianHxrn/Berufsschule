import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMI extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(final String[] args) {
		new BMI();
	}

	private final JLabel label;
	private final JTextField tf_weight;
	private final JTextField tf_height;

	public BMI() {
		super();

		setTitle("BMI Rechner");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				exit();
			}
		});

		final Container con = getContentPane();
		con.setLayout(new BorderLayout());

		tf_weight = new JTextField();
		tf_height = new JTextField();
		setStandardText();
		label = new JLabel();

		final JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(tf_weight);
		p.add(tf_height);

		p.add(label);

		add(p, BorderLayout.CENTER);

		tf_weight.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				tf_weight.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tf_weight.getText().equals("")) {
					tf_weight.setText("Gewicht in kg");
				}
			}
		});
		tf_height.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				tf_height.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tf_height.getText().equals("")) {
					tf_height.setText("Größe in m.cm");
				}
			}
		});

		tf_weight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				checkEvent(e);
			}
		});
		tf_height.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				checkEvent(e);
			}
		});

		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		this.requestFocus();
	}

	public void checkEvent(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				if (tf_height.getText() != "" && tf_weight.getText() != "") {
					calcBMI();
				}
			} catch(Exception exc) {
				label.setText(exc.getMessage());
			}
		}
	}

	private void calcBMI() {
		Double result = db(tf_weight.getText()) / (db(tf_height.getText()) * db(tf_height.getText()));
		result *= 100;
		int temp = (int) Math.round(result);
		result = Double.parseDouble(Integer.toString(temp)) / 100;
		label.setText(Double.toString(result));
		setStandardText();
	}

	private void setStandardText() {
		tf_weight.setText("Gewicht in kg");
		tf_height.setText("Größe in m.cm");
	}

	public Double db(String input) {
		return Double.parseDouble(input);
	}

	private void exit() {
		System.exit(0);
	}

}