package py.com.farmacia.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import py.com.farmacia.app.models.dao.entity.Venta;
import py.com.farmacia.app.models.service.IVentaServiceImpl;

@Controller
@SessionAttributes("detalle_venta")
public class VentasController {

	@Autowired
	private IVentaServiceImpl ventasService;

	@RequestMapping(value="/listarVentas", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Detalle de ventas");
		model.addAttribute("ventas", ventasService.findAll());
		//model.addAttribute("total", ventasService.calcularTotal(0, null));
		return "listarVentas";
	}

	@RequestMapping(value="/formVentas")
	public String crear(Map<String, Object> model) {
		Venta venta = new Venta();

		model.put("venta", venta);
		model.put("titulo", "Agregar Compra");

		return "formVentas";
	}
	
	@RequestMapping(value="/formVentas", method=RequestMethod.POST)
	public String guardar (@Valid Venta venta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Historial de ventas");
			model.addAttribute("venta", venta);

			return "formVentas";
		}

		ventasService.save(venta);
		return "redirect:/listarVentas";
	}
}
