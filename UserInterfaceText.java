package projectponto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class UserInterfaceText extends JFrame {
	private static final long serialVersionUID = 1L;

	private int heightBtn = 40;
	private int widthBtn = 100;
	private JTextField textField;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	String dataDeHoje;
	
	private void createButtons() {

		JButton quitBtn = new JButton("Quit");
		quitBtn.setBounds(150, 0, widthBtn, heightBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		this.add(quitBtn);

		JButton button = new JButton("Entrada");
		button.setBounds(10, 50, widthBtn, heightBtn);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				Arquivo.escrever(dataDeHoje+" "+textField.getText()+" E\n", true);
			}
		});
		this.add(button);

		JButton saveBtn = new JButton("Saida");
		saveBtn.setBounds(150, 50, widthBtn, heightBtn);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				Arquivo.escrever(dataDeHoje+" "+textField.getText()+" S\n", true);
			}
		});
		this.add(saveBtn);
	}

	private void createTextField() {
		textField = new JTextField(20);
		textField.setToolTipText("Digite a hora");
		this.getContentPane().add(textField, "North");
		setVisible(true);
	}

	public void startUI() {
		createTextField();
		createButtons();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ponto Text");
		this.setSize(300, 150);
		this.setLayout(null);
		this.setVisible(true);
	}

}