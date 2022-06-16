package prog;

import prog.Local.LocalTipo;

import java.util.ArrayList;

public class GereLocal {
	public static ArrayList<Local> locais = new ArrayList<>();
	
	public GereLocal() {
		locais.add(new Local("museu 1", "info 1", "loc 1", LocalTipo.MUSEU));
		locais.add(new Local("museu 2", "info 2", "loc 2", LocalTipo.MUSEU));
		locais.add(new Local("museu 3", "info 3", "loc 3", LocalTipo.MUSEU));
		locais.add(new Local("museu 4", "info 4", "loc 4", LocalTipo.MUSEU));
		locais.add(new Local("museu 5", "info 5", "loc 5", LocalTipo.MUSEU));
		locais.add(new Local("museu 6", "info 6", "loc 6", LocalTipo.MUSEU));
		locais.add(new Local("museu 7", "info 7", "loc 7", LocalTipo.MUSEU));
		locais.add(new Local("museu 8", "info 8", "loc 8", LocalTipo.MUSEU));
		
		locais.add(new Local("monumento 1", "info 1", "loc 1", LocalTipo.MONUMENTO));
		locais.add(new Local("monumento 2", "info 2", "loc 2", LocalTipo.MONUMENTO));
		locais.add(new Local("monumento 3", "info 3", "loc 3", LocalTipo.MONUMENTO));
	}
	
	public boolean criarLocal(String nome, String info, String loc, LocalTipo tipo) {
		Local local = new Local(nome, info, loc, tipo);
		for (int i = 0; i < locais.size(); i++) {
			if (local.equals(locais.get(i))) {
				return false;
			}
		}
		return locais.add(local);
	}
	
	void replaceLocal(Local local) {
		for (int i = 0; i < locais.size(); i++) {
			if (locais.get(i).equals(local)) {
				locais.set(i, local);
			}
		}
	}
	
	ArrayList<Local> filterByType(LocalTipo type) {
		ArrayList<Local> locaisFiltrados = new ArrayList<>();
		for(Local local: locais) {
			if (local.getTipo() == type)
				locaisFiltrados.add(local);
		}
		return locaisFiltrados;
	}
}
