package br.com.fiap.revisaospringmvc.revisaospringmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.revisaospringmvc.revisaospringmvc.dto.ClienteDto;
import br.com.fiap.revisaospringmvc.revisaospringmvc.model.Cliente;
import br.com.fiap.revisaospringmvc.revisaospringmvc.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/clientes")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("clientes/index");
		
		List<Cliente> clientes = clienteRepository.findAll();
		modelView.addObject("listarClientes", clientes);
		
		return modelView;
	}
	
	@GetMapping("/clientes/criar")
	public ModelAndView criar(ClienteDto cliente) {
		ModelAndView modelView = new ModelAndView("clientes/criar");
		return modelView;
	}
	
	@PostMapping("clientes")
	public ModelAndView salvar(@Valid ClienteDto cliente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("clientes/criar");
		}
		
		Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
		clienteRepository.save(clienteEntity);
		
		return new ModelAndView("redirect:/clientes");
	}
	
	
}
