package br.com.fiap.revisaospringmvc.revisaospringmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.revisaospringmvc.revisaospringmvc.model.Cliente;

@Controller
public class ClienteController {

	@GetMapping("/clientes")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("clientes/index");
		
		Cliente cliente1 = new Cliente(1L, "Eduardo", "123654987.1", "Rua Euclides Pacheco 36");
		Cliente cliente2 = new Cliente(2L, "Fernando", "98765432.1", "Rua XPTO 42069");
		
		List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
		modelView.addObject("listarClientes", clientes);
		
		return modelView;
	}
	
	
}
