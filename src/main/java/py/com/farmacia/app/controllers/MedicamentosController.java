package py.com.farmacia.app.controllers;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import py.com.farmacia.app.models.dao.entity.Medicamento;
import py.com.farmacia.app.models.service.IMedicamentoService;

@Controller
@SessionAttributes("medicamento")
public class MedicamentosController {

	@Autowired
	private IMedicamentoService medicamentoService;

	@RequestMapping(value="/listarMedicamentos", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de Medicamentos de la farmacia");
		model.addAttribute("medicamentos", medicamentoService.findAll());
		return "listarMedicamentos";
	}

	@RequestMapping(value="/formMedicamento")
	public String crear(Map<String, Object> model) {
		Medicamento medicamento = new Medicamento();

		model.put("medicamento", medicamento);
		model.put("titulo", "Formulario de Medicamento");

		return "formMedicamento";
	}

	@RequestMapping(value="/formMedicamento/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		Medicamento medicamento = null;

		if (id > 0) {
			medicamento = medicamentoService.findOne(id);

		}else {
			return "redirect:/listarMedicamentos";
		}

		model.addAttribute("medicamento", medicamento);
		model.addAttribute("titulo", "Editar Medicamento");

		return "formMedicamento";
	}

	@RequestMapping(value="/formMedicamento", method=RequestMethod.POST)
	public String guardar (Medicamento medicamento, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Medicamento");
			model.addAttribute("medicamento", medicamento);

			return "formMedicamento";
		}

		medicamentoService.save(medicamento);
		return "redirect:/listarMedicamentos";
	}

	@RequestMapping(value="/eliminarMedicamento/{id}")
	public String eliminar (@PathVariable(value="id") Long id) {

		if (id > 0) {
			medicamentoService.delete(id);
		}

		return "redirect:/listarMedicamentos";
	}
}
