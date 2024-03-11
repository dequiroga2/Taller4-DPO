package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	protected static final int COSTO_POR_KM = 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
		Aeropuerto aeropuerto1 = ruta.getOrigen();
		Aeropuerto aeropuerto2 = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		return COSTO_POR_KM*distancia;
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}
}
