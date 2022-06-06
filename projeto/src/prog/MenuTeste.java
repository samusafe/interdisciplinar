package prog;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import prog.Conta.ContaType;

import java.awt.Component;
import java.awt.event.*;
import java.util.Scanner;

import prog.Conta;
import prog.GereConta;
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
				drawLoginAccount ();
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
		frame.getContentPane().removeAll();
		
		JButton criar = new JButton("Criar local");
		criar.setBounds(15,200,120,20);
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateLocal();
			}
		});
		
		JButton edit = new JButton("Editar locais");
		edit.setBounds(140,200,120,20);
		edit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawEditLocal ();
			}
		});
		
		JButton back = new JButton("Voltar");
		back.setBounds(180,20,70,20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(edit);
		frame.add(criar);
		frame.add(back);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void drawTuristaMenu() {
		frame.getContentPane().removeAll();
		
		JButton criar = new JButton("Ver locais");
		criar.setBounds(15,200,120,20);
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSeeLocal();
			}
		});
		
		JButton edit = new JButton("Pesquisar local");
		edit.setBounds(140,200,120,20);
		edit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSearchLocal ();
			}
		});
		
		JButton back = new JButton("Voltar");
		back.setBounds(180,20,70,20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(edit);
		frame.add(criar);
		frame.add(back);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.repaint();
		
		
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
		ok.setBounds(280,200,120,20);
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
		
		JButton back = new JButton("Voltar");
		back.setBounds(160,200,120,20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(ok);
		frame.add(back);
		frame.add(nameLabel);
		frame.add(name);
		frame.add(passLabel);
		frame.add(password);
		frame.add(r1);
		frame.add(r2);
		frame.setSize(450,300);
		frame.repaint();
		
		
	}
	
	public void drawLoginAccount() {
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
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(280,200,120,20);
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
				
				if (GereConta.contas.size() == 0) {
					showError("Nenhuma conta criada");
					return;
				}
				else {
					Conta conta = null;
					for (int i = 0; i < GereConta.contas.size(); i++) {
						conta = GereConta.contas.get(i);
					}
					
					if (conta == null) {
						return;
					}
					
					ContaType tipo = null;
					gereConta.entrarConta(name.getText(), password.getPassword(), tipo);
					
					if (conta.getTipo() == ContaType.ADMIN) {
						drawAdminMenu();
					} else {
						drawTuristaMenu();
					}
				}
				
			}
		});
		

		JButton back = new JButton("Voltar");
		back.setBounds(160,200,120,20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(ok);
		frame.add(back);
		frame.add(nameLabel);
		frame.add(name);
		frame.add(passLabel);
		frame.add(password);
		frame.setSize(450,300);
		frame.repaint();
		
	}
	
	public void drawCreateLocal() {
		frame.getContentPane().removeAll();
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(75,30,60,30);
		
		JTextField name = new JTextField("");
		name.setBounds(150,30,200,30);
		
		JLabel infoLabel = new JLabel("Info");
		infoLabel.setBounds(75,70,60,30);
		
		JTextField info = new JTextField("");
		info.setBounds(150,70,200,30);
		
		JLabel locLabel = new JLabel("Localizaçao");
		infoLabel.setBounds(75,110,60,30);
		
		JTextField loc = new JTextField("");
		loc.setBounds(150,110,200,30);
		
		JRadioButton r1=new JRadioButton("Museu");    
		JRadioButton r2=new JRadioButton("Monumento");   
		r1.setBounds(90,140,100,30);
		r2.setBounds(240,140,100,30);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);  
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(280,200,120,20);
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					showError("Insira nome");
					return;
				}
				if (info.getText().equals("")) {
					showError("Insira info");
					return;
				}
				if (loc.getText().equals("")) {
					showError("Insira localizacao");
					return;
				}
				if (!r1.isSelected() && !r2.isSelected()) {
					showError("Escolha um tipo");
					return;
				}
			}
		});
		
		JButton back = new JButton("Voltar");
		back.setBounds(160,200,120,20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu();
			}
		});
		
		frame.add(ok);
		frame.add(back);
		frame.add(nameLabel);
		frame.add(name);
		frame.add(infoLabel);
		frame.add(info);
		frame.add(locLabel);
		frame.add(loc);
		frame.add(r1);
		frame.add(r2);
		frame.setSize(450,300);
		frame.repaint();
	}
	
	public void drawEditLocal() {
		System.out.println("editar local");
	}
	
	public void drawSeeLocal() {
		System.out.println("ver local");
	}
	
	public void drawSearchLocal() {
		System.out.println("procurar local");
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
