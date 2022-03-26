package py.com.farmacia.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.farmacia.app.models.dao.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
