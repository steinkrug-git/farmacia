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

import py.com.farmacia.app.models.dao.entity.Cliente;
import py.com.farmacia.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de clientes de la farmacia");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}

	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();

		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");

		return "form";
	}

	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);

		}else {
			return "redirect:/listar";
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");

		return "form";
	}

	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar (Cliente cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			model.addAttribute("cliente", cliente);

			return "form";
		}

		clienteService.save(cliente);
		return "redirect:/listar";
	}

	@RequestMapping(value="/eliminar/{id}")
	public String eliminar (@PathVariable(value="id") Long id) {

		if (id > 0) {
			clienteService.delete(id);
		}

		return "redirect:/listar";
	}
}
