package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected static final int COSTO_POR_KM_NATURAL = 600;
	protected static final int COSTO_POR_KM_CORPORATIVO = 900;
	protected static final double DESCUENTO_PEQ = 0.02;
	protected static final double DESCUENTO_MEDIANAS = 0.1;
	protected static final double DESCUENTO_GRANDES = 0.2;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
		Aeropuerto aeropuerto1 = ruta.getOrigen();
		Aeropuerto aeropuerto2 = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		if(cliente.getTipoCliente()=="CORPORATIVO") {
			return COSTO_POR_KM_CORPORATIVO*distancia;
		} else {
			return COSTO_POR_KM_NATURAL*distancia;
		}
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		if(cliente.getTipoCliente()=="CORPORATIVO") {
			ClienteCorporativo tamano = (ClienteCorporativo) cliente;
			if(tamano.getTamanoEmpresa()==1) {
				return DESCUENTO_PEQ;
			} else if (tamano.getTamanoEmpresa()==2) {
				return DESCUENTO_MEDIANAS;
			} else {
				return DESCUENTO_GRANDES;
			}
		} else {
			return 0;
		}
	}
}
