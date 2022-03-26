package py.com.farmacia.app.models.service;

import java.util.List;

import py.com.farmacia.app.models.dao.entity.Medicamento;

public interface IMedicamentoService {

	List<Medicamento> findAll();
	void save(Medicamento medicamento);
	Medicamento findOne(Long id);
	void delete(Long id);
}
