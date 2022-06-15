package prog;
import javax.swing.*;

import prog.Conta.ContaType;
import prog.Local.LocalTipo;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.List;

public class Menu {

	private JFrame frame = new JFrame("Projeto");
	private GereConta gereConta = new GereConta();
	private GereLocal gereLocal = new GereLocal();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/img/Beautiful_Sunrise_with_Sun_Background-450.jpg")));
		imagem.setBounds(0, 0, 300,300);
		
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
		frame.add(imagem);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawAdminMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/img/Beautiful_Sunrise_with_Sun_Background-450.jpg")));
		imagem.setBounds(0, 0, 300,300);
		
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
		frame.add(imagem);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawTuristaMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/img/Beautiful_Sunrise_with_Sun_Background-450.jpg")));
		imagem.setBounds(0, 0, 300,300);
		
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
		frame.add(imagem);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,300);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					String pw = "";
					for (int i = 0; i < password.getPassword().length; i++) {
						pw += password.getPassword()[i];
					}
					
					Conta conta = gereConta.entrarConta(name.getText(), pw);
					if (conta == null) {
						showError("Conta não existe");
						return;
					}
					
					if  (conta.getTipo() == ContaType.ADMIN) {
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
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,300);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		
	}
	
	public void drawCreateLocal() {
		frame.getContentPane().removeAll();
		
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(75,30,60,30);
		
		JTextField name = new JTextField("");
		name.setBounds(150,30,200,30);
		
		JLabel infoLabel = new JLabel("Info");
		infoLabel.setBounds(80,70,60,30);
		
		JTextField info = new JTextField("");
		info.setBounds(150,70,200,30);
		
		JLabel locLabel = new JLabel("Localizacao");
		locLabel.setBounds(50,110,80,30);
		
		JTextField loc = new JTextField("");
		loc.setBounds(150,110,200,30);
		
		JRadioButton r1=new JRadioButton("Museu");    
		JRadioButton r2=new JRadioButton("Monumento");   
		r1.setBounds(90,150,100,30);
		r2.setBounds(240,150,100,30);
		
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
				
				LocalTipo tipo;
				if (r1.isSelected()) {
					tipo = LocalTipo.MONUMENTO;
				} else {
					tipo = LocalTipo.MUSEU;
				}
				
				if (gereLocal.criarLocal(name.getText(), info.getText(), loc.getText(), tipo) == false) {
					showError("Ja existe um local com essas informacoes");
					return;
				}
				
				showError("Local criado");
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
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,300);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawEditLocal() {
		
	}
	
	public void drawSeeLocal() {
		frame.getContentPane().removeAll();
		
		DefaultListModel<String> locaisList = new DefaultListModel<>();
		DefaultListModel<Local> museusList = new DefaultListModel<>();
		DefaultListModel<Local> monumentosList = new DefaultListModel<>();
		
		locaisList.addElement("Museus");
		locaisList.addElement("Monumentos");
		
		for (int i = 0; i < GereLocal.filterByType(LocalTipo.MUSEU).size(); i++) {
			museusList.addElement(GereLocal.filterByType(LocalTipo.MUSEU).get(i));
		}
		
		for (int i = 0; i < GereLocal.filterByType(LocalTipo.MONUMENTO).size(); i++) {
			monumentosList.addElement(GereLocal.filterByType(LocalTipo.MONUMENTO).get(i));
		}
		
		JList<String> list = new JList<>(locaisList);
		list.setBounds(90, 80, 250, 100);
		
		JList<Local> list2 = new JList<>(museusList);
		list2.setBounds(90, 80, 250, 100);
		
		JList<Local> list3 = new JList<>(monumentosList);
		list3.setBounds(90, 80, 250, 100);
		
		JLabel label = new JLabel("Tipos de locais");
		label.setBounds(90,30,200,50);
		
		JLabel labelEach = new JLabel("Informação sobre o local");
		labelEach.setBounds(400,30,200,50);
		
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setBounds(400,80,200,50);
		
		JLabel labelInfo = new JLabel("Info: ");
		labelInfo.setBounds(400,100,200,50);
		
		JLabel labelLoc = new JLabel("Localizaçao: ");
		labelLoc.setBounds(400,120,200,50);
		
		JButton back = new JButton("Voltar");
		back.setBounds(150,220,120,20);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTuristaMenu();
			}
		});
		
		JButton btn = new JButton("OK");
		btn.setBounds(150,200,120,20);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (list.getSelectedIndex() == 0) {
					frame.remove(list);
					frame.remove(back);
					frame.remove(btn);
					label.setText(list.getSelectedValue());
					JButton backIn = new JButton("Voltar");
					backIn.setBounds(150,220,120,20);
					
					backIn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							drawSeeLocal();
						}
					});
					
					JButton btnIn = new JButton("OK");
					btnIn.setBounds(150,200,120,20);
					
					btnIn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (list3.getSelectedIndex() != -1) {
								labelNome.setText("Nome: " + GereLocal.filterByType(LocalTipo.MUSEU).get(list3.getSelectedIndex()).getNome());
								labelInfo.setText("Info: " + GereLocal.filterByType(LocalTipo.MUSEU).get(list3.getSelectedIndex()).getInfo());
								labelLoc.setText("Localizacao: " + GereLocal.filterByType(LocalTipo.MUSEU).get(list3.getSelectedIndex()).getLoc());
								frame.add(labelNome);
								frame.add(labelInfo);
								frame.add(labelLoc);
								frame.repaint();
							} else {
								showError("Escolha um local");
								return;
							}
						}	
					});
					
					frame.add(list3);
					frame.add(labelEach);
					frame.add(backIn);
					frame.add(btnIn);
					frame.setSize(820,320);
					frame.repaint();
				}
				
				if (list.getSelectedIndex() == 1) {
					frame.remove(list);
					frame.remove(back);
					frame.remove(btn);
					label.setText(list.getSelectedValue());
					
					JButton backIn = new JButton("Voltar");
					backIn.setBounds(150,220,120,20);
					
					backIn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							drawSeeLocal();
						}
					});
					
					frame.add(list2);
					frame.add(backIn);
					frame.setSize(820,320);
					frame.repaint();
				}
			}
		});
		
		frame.add(label);
		frame.add(btn);
		frame.add(list);
		frame.add(back);
		frame.setSize(460,320);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawSearchLocal() {
		System.out.println("procurar local");
	}
	
	public void showError(String error) {
		JFrame errorFrame = new JFrame("Error");

		JLabel errorLabel = new JLabel(error);
		errorLabel.setBounds(20,0,100,70);

		errorFrame.add(errorLabel);
		errorFrame.setSize(100,100);
		errorFrame.setLayout(null);
		errorFrame.setResizable(false);
		errorFrame.setVisible(true);
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.drawMainMenu();
	}
}
