package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	public Ruta ruta;
	public Avion avion;
	public Map<String,Tiquete> tiquetes;
	
	public Vuelo(String fecha, Ruta ruta, Avion avion) {
		super();
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
		tiquetes = new HashMap<String,Tiquete>();
	}
	
	
	public String getFecha() {
		return fecha;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}

	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		return calculadora.calcularTarifa(this, cliente) * cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(avion, other.avion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(ruta, other.ruta) && Objects.equals(tiquetes, other.tiquetes);
	}
}
