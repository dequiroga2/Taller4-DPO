package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	public List<Tiquete> tiquetesSinUsar;
	
	public List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int valorTotal = 0;
		for(Tiquete tiquete:tiquetesSinUsar) {
			int valor = tiquete.getTarifa();
			valorTotal = valorTotal+valor;
		}
		for(Tiquete tiquete:tiquetesUsados) {
			int valor = tiquete.getTarifa();
			valorTotal = valorTotal+valor;
		}
		return valorTotal;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for(Tiquete tiquete:tiquetesSinUsar) {
			if(vuelo == tiquete.getVuelo()) {
				tiquetesSinUsar.remove(vuelo);
				tiquetesUsados.add(tiquete);
			}
		}
	}
}
