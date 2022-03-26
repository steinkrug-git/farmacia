package py.com.farmacia.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.farmacia.app.models.dao.IMedicamentosDao;
import py.com.farmacia.app.models.dao.entity.Medicamento;

@Service
public class IMedicamentoServiceImpl implements IMedicamentoService{

	@Autowired
	private IMedicamentosDao medicamentoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findAll() {

		return medicamentoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Medicamento medicamento) {
		medicamentoDao.save(medicamento);

	}

	@Override
	@Transactional
	public Medicamento findOne(Long id) {
		return medicamentoDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		medicamentoDao.deleteById(id);

	}

}
