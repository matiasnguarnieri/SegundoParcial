package ar.edu.unlam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private Map<Producto, Integer> productosVendidos;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		productosVendidos = new HashMap<> ();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Map<Producto, Integer> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(Map<Producto, Integer> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	public void agregarProductoAlTicket(Producto codigo, Integer cantidad) {
		productosVendidos.put(codigo, cantidad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
	
}
