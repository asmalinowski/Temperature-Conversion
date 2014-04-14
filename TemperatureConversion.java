import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConversion{
	public static void main(String[] args){
				Conversion frame = new Conversion();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
	}
}

class Conversion extends JFrame{
	
	public Conversion(){
		setTitle("Fahrenheit to Celsius Calculator");
		ConversionPanel panel = new ConversionPanel();
		add(panel);
                pack();
	}
}
	
class ConversionPanel extends JPanel{
	
	public ConversionPanel(){
		
		setLayout(new BorderLayout());
		panel = new JPanel();
		
		textField = new JTextField();
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,1));
		northPanel.add(new JLabel("Enter the temperature in Fahrenheit ", SwingConstants.LEFT));
		northPanel.add(textField);
		add(northPanel, BorderLayout.NORTH);
		
		panel.setLayout(new GridLayout(1,2));
		cButton = new JButton("Convert to Celsius");
		panel.add(cButton);
		add(panel, BorderLayout.SOUTH);
		
		Converter converter = new Converter();
		cButton.addActionListener(converter);
		
	}
	private class Converter implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			
			if (event.getSource() == cButton){
				int c = (int)(((Double.parseDouble(textField.getText()))- 32) * 0.56);
				textField.setText(c + "");
				textField.requestFocus();
				textField.selectAll();
			}
		}
	}
	private JButton cButton;
	private JTextField textField;
	private JPanel panel;
}
