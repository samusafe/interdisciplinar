package prog;
import javax.swing.*;

import prog.Conta.ContaType;
import prog.Local.LocalTipo;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.List;

public class MenuTeste {

	private JFrame frame = new JFrame("Projeto");
	private GereConta gereConta = new GereConta();
	private GereLocal gereLocal = new GereLocal();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel("New label");
		imagem.setIcon(new ImageIcon("src\\img\\Beautiful_Sunrise_with_Sun_Background-450.jpg"));
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
		frame.repaint();
	}
	
	public void drawAdminMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel("New label");
		imagem.setIcon(new ImageIcon("src\\img\\Beautiful_Sunrise_with_Sun_Background-450.jpg"));
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\\\img\\icon.jpg"));
		frame.repaint();
	}
	
	public void drawTuristaMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel("New label");
		imagem.setIcon(new ImageIcon("src\\img\\Beautiful_Sunrise_with_Sun_Background-450.jpg"));
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
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
					
					if (gereConta.entrarConta(name.getText(), pw) == ContaType.ADMIN) {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
		frame.repaint();
	}
	
	public void drawEditLocal() {
		frame.getContentPane().removeAll();
	    String bigList[] = new String[30];
	    

	    for (int i = 0; i < bigList.length; i++) {
	      bigList[i] = Integer.toString(i);
	    }
	    


	    String choice = (String) JOptionPane.showInputDialog(frame, "Escolhe o local", "Locais", JOptionPane.QUESTION_MESSAGE,
	        null, bigList, "Titan");
	    
	    System.out.println(choice);

		
		JButton back = new JButton("Voltar");
		back.setBounds(160,200,120,20);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu();
			}
		});
		
		frame.add(back);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,300);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
		frame.repaint();
	}
	
	public void drawSeeLocal() {
		frame.getContentPane().removeAll();
		
		JList list = new JList(gereLocal.locais.toArray());
		JScrollPane scrollpane = new JScrollPane();
		JPanel panel = new JPanel();
		panel.add(scrollpane);
		scrollpane.getViewport().add(list);
		JOptionPane.showMessageDialog(null, scrollpane, 
		      "Please select an object", JOptionPane.PLAIN_MESSAGE);
		
		JButton back = new JButton("Voltar");
		back.setBounds(160,200,120,20);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAdminMenu();
			}
		});
		
		frame.add(back);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450,300);
		frame.setTitle("Projeto");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\icon.jpg"));
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
		MenuTeste menu = new MenuTeste();
		menu.drawMainMenu();
	}
}
