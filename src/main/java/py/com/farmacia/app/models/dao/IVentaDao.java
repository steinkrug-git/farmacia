package py.com.farmacia.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.farmacia.app.models.dao.entity.Venta;


public interface IVentaDao extends JpaRepository<Venta, Long>{

}
