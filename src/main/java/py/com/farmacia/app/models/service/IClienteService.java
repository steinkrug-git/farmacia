package py.com.farmacia.app.models.service;

import java.util.List;

import py.com.farmacia.app.models.dao.entity.Cliente;

public interface IClienteService{

	List<Cliente> findAll();
	void save(Cliente cliente);
	Cliente findOne(Long id);
	void delete(Long id);

}
