package prog;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import prog.Conta.ContaType;
import prog.Local.LocalTipo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

public class Menu {

	private JFrame frame = new JFrame("Projeto");
	private GereConta gereConta = new GereConta();
	private GereLocal gereLocal = new GereLocal();
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpeg"));
	private ImageIcon notSelectedImage = new ImageIcon(getClass().getResource("/img/not_selected.png"));
	private ImageIcon selectedImage = new ImageIcon(getClass().getResource("/img/selected.png"));
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JButton criar = new JButton("Criar conta");
		criar.setBounds(30,450,120,20);
		criar.setBackground(Color.WHITE);
		criar.setFont(new Font("Arial", Font.BOLD, 14));
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateAccount();	
			}
		});
		
		JButton login = new JButton("Entrar conta");
		login.setBounds(180,450,120,20);
		login.setBackground(Color.WHITE);
		login.setFont(new Font("Arial", Font.BOLD, 14));
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawLoginAccount ();
			}
		});
		
		frame.add(login);
		frame.add(criar);
		frame.add(imagem);
		frame.setSize(360,600);
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
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(60,70,60,30);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField name = new JTextField("");
		name.setBounds(60,100,200,30);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(60,140,100,30);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(60,170,200,30);
		password.setEchoChar('*');
		
		JRadioButton r1=new JRadioButton("Turista"); 
		r1.setBounds(60,270,100,30);
		r1.setOpaque(true);
		r1.setContentAreaFilled(false);
		r1.setBorderPainted(false);
		r1.setFont(new Font("Arial", Font.BOLD, 16));
		r1.setForeground(Color.WHITE);
		
		JRadioButton r2=new JRadioButton("Admin");  
		r2.setBounds(180,270,100,30);
		r2.setOpaque(false);
		r2.setContentAreaFilled(false);
		r2.setBorderPainted(false);
		r2.setFont(new Font("Arial", Font.BOLD, 16));
		r2.setForeground(Color.WHITE);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);  
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(200,500,120,20);
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
		
		JButton back = new JButton("<<<");
		back.setBounds(80,500,120,20);
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
		frame.add(imagem);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(360,600);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		
		
	}
	
	public void drawLoginAccount() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(60,120,60,30);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField name = new JTextField("");
		name.setBounds(60,150,200,30);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(60,200,140,30);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(60,230,200,30);
		password.setEchoChar('*');
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(200,500,120,20);
		ok.setBackground(Color.WHITE);
		ok.setFont(new Font("Arial", Font.BOLD, 14));
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
		
		JButton back = new JButton("<<<");
		back.setBounds(80,500,120,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
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
		frame.add(imagem);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(360,600);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		
	}
	
	public void drawAdminMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JButton criar = new JButton("Criar local");
		criar.setBounds(40,80,120,20);
		criar.setBackground(Color.WHITE);
		criar.setFont(new Font("Arial", Font.BOLD, 14));
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateLocal();
			}
		});
		
		JButton edit = new JButton("Editar locais");
		edit.setBounds(40,120,120,20);
		edit.setBackground(Color.WHITE);
		edit.setFont(new Font("Arial", Font.BOLD, 14));
		edit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawEditLocal ();
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(250,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(edit);
		frame.add(criar);
		frame.add(back);
		frame.add(imagem);
		frame.setSize(360,600);
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
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JButton ver = new JButton("Ver locais");
		ver.setBounds(15,200,120,20);
		ver.setBackground(Color.WHITE);
		ver.setFont(new Font("Arial", Font.BOLD, 14));
		ver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSeeLocal();
			}
		});
		
		JButton pesquisar = new JButton("Pesquisar local");
		pesquisar.setBounds(140,200,120,20);
		pesquisar.setBackground(Color.WHITE);
		pesquisar.setFont(new Font("Arial", Font.BOLD, 14));
		pesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSearchLocal ();
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(250,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(pesquisar);
		frame.add(ver);
		frame.add(back);
		frame.add(imagem);
		frame.setSize(360,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		
	}
	
	public void drawCreateLocal() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel nameLabel = new JLabel("Nome");
		nameLabel.setBounds(60,70,60,30);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField name = new JTextField("");
		name.setBounds(60,100,200,30);
		
		JLabel infoLabel = new JLabel("Info");
		infoLabel.setBounds(60,150,60,30);
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField info = new JTextField("");
		info.setBounds(60,180,200,30);
		
		JLabel locLabel = new JLabel("Localizacao");
		locLabel.setBounds(60,230,120,30);
		locLabel.setForeground(Color.WHITE);
		locLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField loc = new JTextField("");
		loc.setBounds(60,260,200,30);
		
		JRadioButton r1=new JRadioButton("Museu"); 
		r1.setBounds(50,360,100,30);
		r1.setOpaque(false);
		r1.setContentAreaFilled(false);
		r1.setBorderPainted(false);
		r1.setFont(new Font("Arial", Font.BOLD, 14));
		r1.setForeground(Color.WHITE);
		
		JRadioButton r2=new JRadioButton("Monumento");   
		r2.setBounds(170,360,120,30);
		r2.setOpaque(false);
		r2.setContentAreaFilled(false);
		r2.setBorderPainted(false);
		r2.setFont(new Font("Arial", Font.BOLD, 14));
		r2.setForeground(Color.WHITE);
		
		ButtonGroup bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);  
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(200,500,120,20);
		ok.setBackground(Color.WHITE);
		ok.setFont(new Font("Arial", Font.BOLD, 14));
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
					tipo = LocalTipo.MUSEU;
				} else {
					tipo = LocalTipo.MONUMENTO;
				}
				
				if (gereLocal.criarLocal(name.getText(), info.getText(), loc.getText(), tipo) == false) {
					showError("Ja existe um local com essas informacoes");
					return;
				}
				showError("Local criado");
				drawAdminMenu();
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(250,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		
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
		frame.add(imagem);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(360,600);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawEditLocal() {
		
	}
	
	public void drawSeeLocal() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel label = new JLabel("Tipos de locais");
		label.setBounds(50,60,200,50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		DefaultListModel<String> locaisList = new DefaultListModel<>();
		
		locaisList.addElement("Museus");
		locaisList.addElement("Monumentos");
		
		JList<String> list = new JList<>(locaisList);
		list.setBounds(40, 120, 250, 100);
		
		JButton back = new JButton("<<<");
		back.setBounds(250,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTuristaMenu();
			}
		});
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(200,500,120,20);
		ok.setBackground(Color.WHITE);
		ok.setFont(new Font("Arial", Font.BOLD, 14));
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() == - 1) {
					showError("Escolha um tipo de local");
				}
				LocalTipo tipo;
				if (list.getSelectedIndex() == 0) {
					tipo = LocalTipo.MUSEU;
				} else { 
					tipo = LocalTipo.MONUMENTO;
				}
				drawSeeLocalDetail(tipo);
			}		
		});
		
		frame.add(label);
		frame.add(ok);
		frame.add(list);
		frame.add(back);
		frame.add(imagem);
		frame.setSize(360,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawSeeLocalDetail(LocalTipo tipo) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		String nome;
		if (tipo == LocalTipo.MUSEU) {
			nome = "Museus";
		} else {
			nome = "Monumentos";
		}
		
		JLabel label = new JLabel(nome);
		label.setBounds(50,60,200,50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelNome = new JLabel("");
		labelNome.setBounds(60,240,60,30);
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(50,240,200,550);
		labelInfo.setForeground(Color.WHITE);
		labelInfo.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelLoc = new JLabel("");
		labelLoc.setBounds(50,280,200,550);
		labelLoc.setForeground(Color.WHITE);
		labelLoc.setFont(new Font("Arial", Font.BOLD, 16));
		
		DefaultListModel<Local> localList = new DefaultListModel<>();
		
		localList.addAll(gereLocal.filterByType(tipo));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 120, 250, 120);
		
		JList<Local> listLocal = new JList<>(localList);
		listLocal.setLayoutOrientation(JList.VERTICAL);
		
		listLocal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				labelNome.setText("Nome: " + localList.get(listLocal.getSelectedIndex()).getNome());
				labelInfo.setText("Info: " + localList.get(listLocal.getSelectedIndex()).getInfo());
				labelLoc.setText("Localizacao: " + localList.get(listLocal.getSelectedIndex()).getLoc());
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(250,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawSeeLocal();
			}
		});
		
		scrollPane.setViewportView(listLocal);
		frame.add(scrollPane);
		frame.add(label);
		frame.add(back);
		frame.add(labelNome);
		frame.add(labelInfo);
		frame.add(labelLoc);
		frame.add(imagem);
		frame.setSize(360,600);
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
