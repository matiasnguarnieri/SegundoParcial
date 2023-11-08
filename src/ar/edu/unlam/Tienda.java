package ar.edu.unlam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tienda {

	private String cuit;
	private String nombre;
	private Set<Producto> listadoDeProductos;
	private Map<Producto, Integer> stockDeProductos;
	private Set<Cliente> listadoClientes;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		listadoDeProductos = new HashSet<> ();
		stockDeProductos = new HashMap<> ();
		listadoClientes = new HashSet<> ();
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getListadoDeProductos() {
		return listadoDeProductos;
	}

	public void setListadoDeProductos(Set<Producto> listadoDeProductos) {
		this.listadoDeProductos = listadoDeProductos;
	}

	public Map<Producto, Integer> getStockDeProductos() {
		return stockDeProductos;
	}

	public void setStockDeProductos(Map<Producto, Integer> stockDeProductos) {
		this.stockDeProductos = stockDeProductos;
	}

	public void agregarProducto(Producto producto) {
		listadoDeProductos.add(producto);
		
	}

	public Producto getVendible(String codigo) {
		Producto porductoBuscado = buscarProductoDelListadoPorCodigo(codigo);
		return porductoBuscado;
	}
	
	public Producto buscarProductoDelListadoPorCodigo (String codigo) {
		for(Producto prod : listadoDeProductos) {
			if(prod.getCodigo().equals(codigo)) {
				return prod;
			}
		}
		return null;
	}
	
	public void agregarProducto(Producto producto, Integer cantidad) {
		stockDeProductos.put(producto, cantidad);
		
	}
	

	public Integer getStock(Producto producto) {
		Integer productoBuscado = stockDeProductos.get(producto);
		return productoBuscado;
	}

	public void agregarCliente(Cliente cliente) {
		listadoClientes.add(cliente);
		
	}
	
	public Cliente buscarCliente (String cuit) {
		for(Cliente cliente : listadoClientes) {
			if(cliente.getCuit().equals(cuit)) {
				return cliente;
			}
		}
		return null;
	}

	public Cliente getCliente(String cuitEjemplo) {
		Cliente clienteBuscado = buscarCliente(cuitEjemplo);
		return clienteBuscado;
	}
	
	
}
