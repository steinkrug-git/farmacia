package py.com.farmacia.app.models.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "detalle_venta")
public class Venta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private Long id;

	
	@Column(name = "id_cliente")
	private Integer idCliente	;

	@NotNull
	@Column(name = "id_medicamento")
	private Long idMedicamento;


	@NotNull
	@Column(name = "cantidad")
	private int cantidad;
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Integer getIdCliente() {
		return idCliente;
	}




	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}




	public Long getIdMedicamento() {
		return idMedicamento;
	}




	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	private static final long serialVersionUID = 1L;

}
