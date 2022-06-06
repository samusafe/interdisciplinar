//package prog;
//import java.util.Scanner;
//import javax.swing.*;
//
//public class Menu {
//
//	public static void main(String[] args) {
//		int menu = 0;
//		GereConta gereConta = new GereConta();
//		do {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("[0] Terminar programa \n[1] Criar conta \n[2] Entrar conta");
//			menu = scanner.nextInt();
//			switch (menu) {
//			case 1:
//				//gereConta.criarConta();
//				break;
//			case 2:
//				gereConta.entrarConta();
//				break;
//			default:
//				break;
//			}
//		} while (menu != 0);
//	}
//	
//	public static void menuAdmin(Conta user) {
//		int menu = 0;
//		GereLocal gereLocal = new GereLocal();
//		do {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("---- " + user + " ----");
//			System.out.println("[1] Criar local \n[2] Editar locais \n[3] Gerir atividade \n[9] Sair conta");
//			menu = scanner.nextInt();
//			switch (menu) {
//			case 1:
//				gereLocal.criarLocal();
//				break;
//			case 2:
//				gereLocal.editLocal();
//				break;
//			case 3:
//				gereLocal.printAtividade();
//				break;
//			default:
//				break;
//			}
//		} while (menu != 9);
//	}
//	
//	public static void menuTurista(Conta user) {
//		int menu = 0;
//		GereLocal gereLocal = new GereLocal();
//		do {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("---- " + user + " ----");
//			System.out.println("[1] Ver locais \n[2] Pesquisar um local \n[9] Sair conta");
//			menu = scanner.nextInt();
//			switch (menu) {
//			case 1:
//				System.out.println("[1] Museus \n[2] Monumentos");
//				menu = scanner.nextInt();
//				if (menu == 1 || menu == 2) {
//					gereLocal.printLocal(user, menu);
//					break;
//				}
//				break;
//			case 2:
//				gereLocal.pesquisaLocal();
//				break;
//			default:
//				break;
//			}
//		} while (menu != 9);
//		return;
//	}
//
//}
