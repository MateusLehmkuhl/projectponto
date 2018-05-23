package projectponto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class UserInterface extends JFrame {
	private static final long serialVersionUID = 1L;

	private int heightBtn = 40;
	private int widthBtn = 100;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String dataDeHoje;
	SimpleDateFormat horarioFormat = new SimpleDateFormat("HH:mm:ss");
	String horarioAtual;
	
	private void createButtons() {
		dataDeHoje  = dateFormat.format(new Date());
		JLabel texto = new JLabel(dataDeHoje);
		texto.setSize(200,40);
		texto.setBounds(80,0, 200, 40);
		add(texto);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.setBounds(150, 50, widthBtn, heightBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(quitBtn);

		JButton button = new JButton("Entrada");
		button.setBounds(10, 100, widthBtn, heightBtn);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				Arquivo.escrever(dataDeHoje+" E\n", true);
			}
		});
		add(button);

		JButton saveBtn = new JButton("Saida");
		saveBtn.setBounds(150, 100, widthBtn, heightBtn);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				Arquivo.escrever(dataDeHoje + " S\n", true);
			}
		});
		add(saveBtn);
		
		JButton horarioBtn = new JButton("Att Horario");
		horarioBtn.setBounds(10, 50, widthBtn, heightBtn);
		horarioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				texto.setText(dataDeHoje);
			}
		});
		add(horarioBtn);		
	}


	public void startUI() {
		createButtons();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ponto");
		setSize(300, 200);
		setLayout(null);
		setVisible(true);
	}

}