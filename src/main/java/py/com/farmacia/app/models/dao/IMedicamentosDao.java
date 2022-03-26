package py.com.farmacia.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.farmacia.app.models.dao.entity.Medicamento;

public interface IMedicamentosDao extends JpaRepository<Medicamento, Long>{
	
}
