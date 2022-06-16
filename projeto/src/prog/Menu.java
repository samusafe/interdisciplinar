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
import java.util.Collection;

public class Menu {

	private JFrame frame = new JFrame("Projeto");
	private GereConta gereConta = new GereConta();
	private GereLocal gereLocal = new GereLocal();
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpeg"));
	
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
				
				String pw = "";
				for (int i = 0; i < password.getPassword().length; i++) {
					pw += password.getPassword()[i];
				}
				
				Conta conta = gereConta.entrarConta(name.getText(), pw);
				
				if (tipo == ContaType.TURISTA) {
					drawTuristaMenu(conta);
				} else {
					drawAdminMenu(conta);
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
						drawAdminMenu(conta);
					} else {
						drawTuristaMenu(conta);
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
	
	public void drawAdminMenu(Conta conta) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JButton criar = new JButton("Criar local");
		criar.setBounds(40,80,120,20);
		criar.setBackground(Color.WHITE);
		criar.setFont(new Font("Arial", Font.BOLD, 14));
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateLocal(conta);
			}
		});
		
		JButton edit = new JButton("Editar locais");
		edit.setBounds(40,120,120,20);
		edit.setBackground(Color.WHITE);
		edit.setFont(new Font("Arial", Font.BOLD, 14));
		edit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawEditLocal(conta);
			}
		});
		
		JButton atividade = new JButton("Atividade");
		atividade.setBounds(40,160,120,20);
		atividade.setBackground(Color.WHITE);
		atividade.setFont(new Font("Arial", Font.BOLD, 14));
		atividade.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawActivity(conta);
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(edit);
		frame.add(criar);
		frame.add(atividade);
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
	
	public void drawTuristaMenu(Conta conta) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JButton ver = new JButton("Ver locais");
		ver.setBounds(40,80,120,20);
		ver.setBackground(Color.WHITE);
		ver.setFont(new Font("Arial", Font.BOLD, 14));
		ver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSeeLocal(conta);
			}
		});
		
		JButton pesquisar = new JButton("Pesquisar local");
		pesquisar.setBounds(40,120,160,20);
		pesquisar.setBackground(Color.WHITE);
		pesquisar.setFont(new Font("Arial", Font.BOLD, 14));
		pesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawSearchLocal(conta);
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
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
	
	public void drawCreateLocal(Conta conta) {
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
				drawAdminMenu(conta);
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu(conta);
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
	
	public void drawEditLocal(Conta conta) {
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
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu(conta);
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
				drawEditLocalDetail(tipo, conta);
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
	
	public void drawEditLocalDetail(LocalTipo tipo, Conta conta) {
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
		label.setBounds(50,70,200,50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelNome = new JLabel("");
		labelNome.setBounds(50,260,550,30);
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(50,280,550,30);
		labelInfo.setForeground(Color.WHITE);
		labelInfo.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelLoc = new JLabel("");
		labelLoc.setBounds(50,300,550,30);
		labelLoc.setForeground(Color.WHITE);
		labelLoc.setFont(new Font("Arial", Font.BOLD, 16));
		
		DefaultListModel<Local> localList = new DefaultListModel<>();
		
		localList.addAll(gereLocal.filterByType(tipo));
		
		JList<Local> listLocal = new JList<>(localList);
		listLocal.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 120, 250, 120);
		scrollPane.setViewportView(listLocal);
		
		listLocal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				labelNome.setText("Nome: " + localList.get(listLocal.getSelectedIndex()).getNome());
				labelInfo.setText("Info: " + localList.get(listLocal.getSelectedIndex()).getInfo());
				labelLoc.setText("Localizacao: " + localList.get(listLocal.getSelectedIndex()).getLoc());
			}
		});
		
		JButton editNome = new JButton("Alterar nome");
		editNome.setBounds(20,340,140,20);
		editNome.setBackground(Color.WHITE);
		editNome.setFont(new Font("Arial", Font.BOLD, 14));
		editNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = "nome";
				drawEdit(localList.get(listLocal.getSelectedIndex()), tipo, conta);
			}
		});
		
		JButton editInfo = new JButton("Alterar info");
		editInfo.setBounds(180,340,140,20);
		editInfo.setBackground(Color.WHITE);
		editInfo.setFont(new Font("Arial", Font.BOLD, 14));
		editInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = "info";
				drawEdit(localList.get(listLocal.getSelectedIndex()), tipo, conta);
			}
		});
		
		JButton editLoc = new JButton("Alterar loc");
		editLoc.setBounds(110,370,140,20);
		editLoc.setBackground(Color.WHITE);
		editLoc.setFont(new Font("Arial", Font.BOLD, 14));
		editLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = "localizacao";
				drawEdit(localList.get(listLocal.getSelectedIndex()), tipo, conta);
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawEditLocal(conta);
			}
		});
		
		frame.add(scrollPane);
		frame.add(label);
		frame.add(back);
		frame.add(labelNome);
		frame.add(labelInfo);
		frame.add(labelLoc);
		frame.add(editNome);
		frame.add(editInfo);
		frame.add(editLoc);
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
	
	public void drawEdit(Local local, String tipo, Conta conta) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel newLabel = new JLabel("Editar " + tipo);
		newLabel.setBounds(60,120,160,30);
		newLabel.setForeground(Color.WHITE);
		newLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField novo = new JTextField("");
		novo.setBounds(60,150,200,30);
		
		JButton ok = new JButton("Continuar");
		ok.setBounds(200,500,120,20);
		ok.setBackground(Color.WHITE);
		ok.setFont(new Font("Arial", Font.BOLD, 14));
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (novo.getText().equals("")) {
					showError("Insira " + tipo);
					return;
				}
				if (tipo == "nome") {
					local.setNome(novo.getText());
					drawEditLocal(conta);
				}
				if (tipo == "info") {
					local.setInfo(novo.getText());
					drawEditLocal(conta);
				}
				if (tipo == "localizacao") {
					local.setLoc(novo.getText());
					drawEditLocal(conta);
				}
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(80,500,120,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawEditLocal(conta);
			}
		});
		
		frame.add(ok);
		frame.add(back);
		frame.add(newLabel);
		frame.add(novo);
		frame.add(imagem);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(360,600);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawActivity(Conta conta) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel label = new JLabel("Atividade");
		label.setBounds(50,60,200,50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		DefaultListModel<String> activityList = new DefaultListModel<>();	
		
		for (int i = 0; i < GereLocal.locais.size(); i++) {
			for (int j = 0; j < GereLocal.locais.get(i).getAvaliacoes().size(); j++) {
				activityList.addElement(GereLocal.locais.get(i).getAvaliacoes().get(j).getUser().getNome() + " avaliou " 
			+ GereLocal.locais.get(i).getAvaliacoes().get(j).getRate() + " ao " + GereLocal.locais.get(i).getNome());
			}
		}
		
		JList<String> list = new JList<>(activityList);
		list.setBounds(40, 200, 250, 100);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 120, 250, 120);
		scrollPane.setViewportView(list);
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu(conta);
			}
		});
		
		frame.add(label);
		frame.add(scrollPane);
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
	
	public void drawSeeLocal(Conta conta) {
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
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTuristaMenu(conta);
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
				drawSeeLocalDetail(tipo, conta);
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
	
	public void drawSeeLocalDetail(LocalTipo tipo, Conta conta) {
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
		label.setBounds(50,70,200,50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelNome = new JLabel("");
		labelNome.setBounds(50,260,550,30);
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(50,280,550,30);
		labelInfo.setForeground(Color.WHITE);
		labelInfo.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelLoc = new JLabel("");
		labelLoc.setBounds(50,300,550,30);
		labelLoc.setForeground(Color.WHITE);
		labelLoc.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelRate = new JLabel("");
		labelRate.setBounds(50,340,550,30);
		labelRate.setForeground(Color.WHITE);
		labelRate.setFont(new Font("Arial", Font.BOLD, 16));
		
		DefaultListModel<Local> localList = new DefaultListModel<>();
		localList.addAll(gereLocal.filterByType(tipo));	
		
		JList<Local> listLocal = new JList<>(localList);
		listLocal.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 120, 250, 120);
		scrollPane.setViewportView(listLocal);
		
		listLocal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				labelNome.setText("Nome: " + localList.get(listLocal.getSelectedIndex()).getNome());
				labelInfo.setText("Info: " + localList.get(listLocal.getSelectedIndex()).getInfo());
				labelLoc.setText("Localizacao: " + localList.get(listLocal.getSelectedIndex()).getLoc());
				if (localList.get(listLocal.getSelectedIndex()).hasAvaliacoes()) {
					labelRate.setText("Classificaçao -> " + localList.get(listLocal.getSelectedIndex()).getRate());
					labelRate.setVisible(true);;
				} else {
					labelRate.setVisible(false);;
				}
			}
		});
		
		JButton avaliar = new JButton("Avaliar");
		avaliar.setBounds(200,500,120,20);
		avaliar.setBackground(Color.WHITE);
		avaliar.setFont(new Font("Arial", Font.BOLD, 14));
		avaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listLocal.getSelectedIndex() != -1) {
					String entrada;
				    int num;

				    entrada = JOptionPane.showInputDialog("Avalie de 1 a 5");
				    num = Integer.parseInt(entrada);
				    if (num < 1 || num > 5) {
				    	showError("Avalie de 1 a 5");
				    } else {
				    	Avaliacao avaliacao = new Avaliacao(num, conta);
				    	localList.get(listLocal.getSelectedIndex()).addAvaliacao(avaliacao);
						gereLocal.replaceLocal(localList.get(listLocal.getSelectedIndex()));
				    }
				} else {
					showError("Escolha um local");
				}
			}		
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawSeeLocal(conta);
			}
		});
		
		frame.add(scrollPane);
		frame.add(label);
		frame.add(back);
		frame.add(labelNome);
		frame.add(labelInfo);
		frame.add(labelLoc);
		frame.add(labelRate);
		frame.add(avaliar);
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
	
	public void drawSearchLocal(Conta conta) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 360, 600);
		
		JLabel nameLabel = new JLabel("Nome do local");
		nameLabel.setBounds(60,60,150,30);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextField name = new JTextField("");
		name.setBounds(60,90,200,30);
		
		JLabel labelNome = new JLabel("");
		labelNome.setBounds(50,260,550,30);
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(50,280,550,30);
		labelInfo.setForeground(Color.WHITE);
		labelInfo.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel labelLoc = new JLabel("");
		labelLoc.setBounds(50,300,550,30);
		labelLoc.setForeground(Color.WHITE);
		labelLoc.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton ok = new JButton("Pesquisar");
		ok.setBounds(140,140,120,20);
		ok.setBackground(Color.WHITE);
		ok.setFont(new Font("Arial", Font.BOLD, 14));
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					showError("Insira nome");
					return;
				}
				
				if (GereLocal.locais.size() == 0) {
					showError("Nenhum local criado");
					return;
				}
				else {
					for (int i = 0; i < GereLocal.locais.size(); i++) {
						if (name.getText().equals(GereLocal.locais.get(i).getNome())) {
							int j = i;
							labelNome.setText("Nome: " + GereLocal.locais.get(j).getNome());
							labelInfo.setText("Info: " + GereLocal.locais.get(j).getInfo());
							labelLoc.setText("Localizacao: " + GereLocal.locais.get(j).getLoc());
						}
					}
				}
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTuristaMenu(conta);
			}
		});
		
		frame.add(ok);
		frame.add(back);
		frame.add(nameLabel);
		frame.add(labelNome);
		frame.add(labelInfo);
		frame.add(labelLoc);
		frame.add(name);
		frame.add(imagem);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(360,600);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
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
