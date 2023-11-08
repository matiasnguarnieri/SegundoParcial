package ar.edu.unlam;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
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

	
	
}
