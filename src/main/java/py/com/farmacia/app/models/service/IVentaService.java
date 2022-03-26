package py.com.farmacia.app.models.service;

import java.util.List;

import py.com.farmacia.app.models.dao.entity.Venta;

public interface IVentaService {
	
	List<Venta> findAll();
	void save(Venta venta);
	Venta findOne(Long id);
	void delete(Long id);
	//Long calcularTotal(int cantidad, Long precioMedicamento);
}
