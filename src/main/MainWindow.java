package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField yField;
	private JTextField xField;
	private JLabel espLabel;
	private JTextField espField;
	private JLabel qtdLabel;
	private JTextField qtdField;
	private JLabel matLabel;
	private JTextField densityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 500, 200, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		yField = new JTextField();
		yField.setBounds(50, 36, 86, 20);
		frame.getContentPane().add(yField);
		yField.setColumns(10);
		
		JLabel yLabel = new JLabel("Medida Y");
		yLabel.setBounds(70, 11, 66, 14);
		frame.getContentPane().add(yLabel);
		
		JLabel xLabel = new JLabel("Medida X");
		xLabel.setBounds(70, 67, 66, 14);
		frame.getContentPane().add(xLabel);
		
		xField = new JTextField();
		xField.setColumns(10);
		xField.setBounds(50, 92, 86, 20);
		frame.getContentPane().add(xField);
		
		espLabel = new JLabel("Espessura");
		espLabel.setBounds(65, 123, 71, 14);
		frame.getContentPane().add(espLabel);
		
		espField = new JTextField();
		espField.setColumns(10);
		espField.setBounds(50, 148, 86, 20);
		frame.getContentPane().add(espField);
		
		qtdLabel = new JLabel("Quantidade");
		qtdLabel.setBounds(62, 179, 74, 14);
		frame.getContentPane().add(qtdLabel);
		
		qtdField = new JTextField();
		qtdField.setColumns(10);
		qtdField.setBounds(50, 204, 86, 20);
		frame.getContentPane().add(qtdField);
		
		matLabel = new JLabel("Material");
		matLabel.setBounds(70, 235, 66, 14);
		frame.getContentPane().add(matLabel);
		
		JComboBox matBox = new JComboBox();
		matBox.setModel(new DefaultComboBoxModel(Material.values()));
		matBox.setBounds(50, 260, 86, 22);
		
		frame.getContentPane().add(matBox);
		
		JLabel resultLabel = new JLabel("Resultado");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(27, 411, 132, 14);
		frame.getContentPane().add(resultLabel);
		JLabel densityLabel = new JLabel("Densidade em g/cm3");
		densityLabel.setBounds(27, 295, 132, 14);
		frame.getContentPane().add(densityLabel);
		densityLabel.setVisible(false);
		
		densityField = new JTextField();
		densityField.setHorizontalAlignment(SwingConstants.CENTER);
		densityField.setColumns(10);
		densityField.setBounds(50, 320, 86, 20);
		densityField.setVisible(false);
		frame.getContentPane().add(densityField);
		matBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((Material) matBox.getSelectedItem() == Material.OUTRO) {
					densityField.setVisible(true);
					densityLabel.setVisible(true);
				}
				else {
					densityField.setVisible(false);
					densityLabel.setVisible(false);
				}
			}
		});
		
		
		
		JButton calcButton = new JButton("Calcular");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double density = 0;
				double y = Double.parseDouble(yField.getText());
				double x = Double.parseDouble(xField.getText());
				double esp = Double.parseDouble(espField.getText());
				double qtd = Double.parseDouble(qtdField.getText());
				Material material = (Material) matBox.getSelectedItem();
				switch (material) {
				case ALUMINIO:
					density = 0.0027;
					break;
				case CARBONO:
					density = 0.00787;
					break;
				case INOX:
					density = 0.008;
					break;
				case BRAS_CARBONO:
					density = 0.007851851850;
					break;
				case OUTRO:
					density = Double.parseDouble(densityField.getText()) / 1000;
				}
				
				double res = y * x * esp * qtd * density / 1000;
				resultLabel.setText(String.valueOf(res) + " kg");
			}
		});
		calcButton.setBounds(47, 364, 89, 23);
		frame.getContentPane().add(calcButton);
		
		
		
		
		
		
	}
	
	public void calcular() {
		
	}
}
