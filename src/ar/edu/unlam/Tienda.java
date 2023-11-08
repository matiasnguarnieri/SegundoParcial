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
	private Set<Vendedor> listadoVendedores;
	private Set<Venta> listadoDeVentas;
	private Set<Servicio> listadoServicios;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		listadoDeProductos = new HashSet<>();
		stockDeProductos = new HashMap<>();
		listadoClientes = new HashSet<>();
		listadoVendedores = new HashSet<>();
		listadoDeVentas = new HashSet<>();
		listadoServicios = new HashSet<>();
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

	public Set<Cliente> getListadoClientes() {
		return listadoClientes;
	}

	public void setListadoClientes(Set<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}

	public Set<Vendedor> getListadoVendedores() {
		return listadoVendedores;
	}

	public void setListadoVendedores(Set<Vendedor> listadoVendedores) {
		this.listadoVendedores = listadoVendedores;
	}

	public void agregarProducto(Producto producto) {
		listadoDeProductos.add(producto);

	}

	public Producto getVendible(String codigo) {
		Producto porductoBuscado = buscarProductoDelListadoPorCodigo(codigo);
		return porductoBuscado;
	}

	public Producto buscarProductoDelListadoPorCodigo(String codigo) {
		for (Producto prod : listadoDeProductos) {
			if (prod.getCodigo().equals(codigo)) {
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

	public Cliente buscarCliente(String cuit) {
		for (Cliente cliente : listadoClientes) {
			if (cliente.getCuit().equals(cuit)) {
				return cliente;
			}
		}
		return null;
	}

	public Cliente getCliente(String cuitEjemplo) {
		Cliente clienteBuscado = buscarCliente(cuitEjemplo);
		return clienteBuscado;
	}

	public void agregarVendedor(Vendedor vendedor) {
		listadoVendedores.add(vendedor);
	}

	public Vendedor buscarVendedor(String dni) {
		for (Vendedor vendedor : listadoVendedores) {
			if (vendedor.getDni().equals(dni)) {
				return vendedor;
			}
		}
		return null;
	}

	public Vendedor getVendedor(String dni) {
		Vendedor vendedorBuscado = buscarVendedor(dni);
		return vendedorBuscado;
	}

	public void agregarVenta(Venta ticket) {
		listadoDeVentas.add(ticket);
	}

	public Venta buscarVentaPorCodigo(String codigo) {
		for (Venta venta : listadoDeVentas) {
			if (venta.getCodigo().equals(codigo)) {
				return venta;
			}
		}
		return null;
	}

	public Boolean comprobarSiLaCantidadAVenderSuperaElStockDisponible(Producto producto, Integer cantidadVendida) throws StockInsuficienteException {
		Integer stockActualDelProducto = stockDeProductos.get(producto);
		if (stockActualDelProducto < cantidadVendida) {
			throw new StockInsuficienteException();
		}
		return true;
	}

	public void agregarProductoAVenta(String codigo, Producto producto, Integer cantidadVendida) throws StockInsuficienteException {
		comprobarSiLaCantidadAVenderSuperaElStockDisponible(producto, cantidadVendida);
		Venta ventaEncontrada = buscarVentaPorCodigo(codigo);
		Integer stockActualDelProducto = stockDeProductos.get(producto);
		ventaEncontrada.agregarProductoAlTicket(producto, cantidadVendida);
		stockDeProductos.put(producto, stockActualDelProducto - cantidadVendida);
	}

	public void agregarServicio(Servicio servicio) {
		listadoServicios.add(servicio);
		
	}

	public void agregarServicioAVenta(String codigo, Servicio servicio) {
		Venta ventaEncontrada = buscarVentaPorCodigo(codigo);
		ventaEncontrada.agregarServicioAlTicket(servicio);
		
	}

}
