package py.com.farmacia.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.farmacia.app.models.dao.IVentaDao;
import py.com.farmacia.app.models.dao.entity.Venta;

@Service
public class IVentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaDao ventaDao;
	
	/*@Autowired
	private IMedicamentoService medicamentoService;*/

	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll() {

		return ventaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Venta venta) {
		ventaDao.save(venta);

	}

	@Override
	@Transactional
	public Venta findOne(Long id) {
		return ventaDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ventaDao.deleteById(id);

	}
	
	//falta implementar
	/*@Override
	@Transactional
	public Long calcularTotal(int cantidad, Long idMedicamento) {
		Long total;

		total = medicamentoService.findOne(idMedicamento).getPrecio() * cantidad;
		
		return total;
		
	}*/
	
}
