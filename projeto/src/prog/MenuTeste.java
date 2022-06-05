package prog;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import prog.Conta.ContaType;

import java.awt.Component;
import java.awt.event.*;

//import prog.Conta;
//import prog.Menu;

public class MenuTeste {

	private JFrame frame = new JFrame("Projeto");
	private GereConta gereConta = new GereConta();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JButton criar = new JButton("Criar conta");
		criar.setBounds(15,200,120,20);
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateAccount();
			}
		});
		
		JButton login = new JButton("Entrar conta");
		login.setBounds(140,200,120,20);
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//gereConta.entrarConta(name.getText(), password.getPassword(), tipo);
				
			}
		});
		
		frame.add(login);
		frame.add(criar);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void drawAdminMenu() {
		
	}
	
	public void drawTuristaMenu() {
		
	}
	
	
	public void drawCreateAccount() {
		frame.getContentPane().removeAll();
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(75,30,60,30);
		
		JTextField name = new JTextField("");
		name.setBounds(150,30,200,30);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(60,70,60,30);
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(150,70,200,30);
		password.setEchoChar('*');
		
		JRadioButton r1=new JRadioButton("Turista");    
		JRadioButton r2=new JRadioButton("Admin");   
		r1.setBounds(90,140,100,30);
		r2.setBounds(240,140,100,30);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);  
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(15,200,120,20);
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					showError("Insira nome");
					return;
				}
				if (password.getPassword().length == 0) {
					showError("Insira password");
					return;
				}
				if (!r1.isSelected() && !r2.isSelected()) {
					showError("Escolha um tipo");
					return;
				}
				
				ContaType tipo;
				if (r1.isSelected()) {
					tipo = ContaType.TURISTA;
				} else {
					tipo = ContaType.ADMIN;
				}
				
				if (!gereConta.criarConta(name.getText(), password.getPassword(), tipo)) {
					showError("Ja existe uma conta");
					return;
				}
				
				if (tipo == ContaType.TURISTA) {
					drawTuristaMenu();
				} else {
					drawAdminMenu();
				}
			}
		});
		
		frame.add(ok);
		frame.add(nameLabel);
		frame.add(name);
		frame.add(passLabel);
		frame.add(password);
		frame.add(r1);
		frame.add(r2);
		frame.setSize(450,300);
		frame.repaint();
		
		
	}
	
	public void showError(String error) {
		JFrame errorFrame = new JFrame("Error");

		JLabel errorLabel = new JLabel(error);
		errorLabel.setBounds(60,50,150,200);

		errorFrame.add(errorLabel);
		errorFrame.setSize(250,250);
		errorFrame.setLayout(null);
		errorFrame.setVisible(true);
	}

	public static void main(String[] args) {
		MenuTeste menu = new MenuTeste();
		menu.drawMainMenu();
	}
}
