package br.com.fiap.revisaospringmvc.revisaospringmvc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("clientes/{id}")
	public ModelAndView mostrar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			Cliente clienteGet = cliente.get();
			ModelAndView modelView = new ModelAndView("clientes/detalhe");
			modelView.addObject("cliente", clienteGet);
			return modelView;
		}
		
		return new ModelAndView("redirect:/clientes");
	}
	
	@GetMapping("/clientes/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, ClienteDto request) {
		Optional<Cliente> optionalCliente= clienteRepository.findById(id);
		
		if(optionalCliente.isPresent()) {
			Cliente cliente = optionalCliente.get();
			request.fromCliente(cliente);
			ModelAndView modelView = new ModelAndView("clientes/edit");
			modelView.addObject("clienteId", cliente.getId());
			return modelView;
		}
		
		return new ModelAndView("redirect:/clientes");
	}
	
	
	@PostMapping("/clientes/{id}")
	public ModelAndView update(@PathVariable Long id, @Valid ClienteDto request, BindingResult bindigResult) {
		
		if(bindigResult.hasErrors()) {
			ModelAndView model = new ModelAndView("clientes/edit");
			model.addObject("clientesId", id);
			return model;
		}
		
		Optional<Cliente> optionalClientes= clienteRepository.findById(id);
		
		if(optionalClientes.isPresent()) {
			Cliente cliente = modelMapper.map(request, Cliente.class);
			cliente.setId(id);
			clienteRepository.save(cliente);
			return new ModelAndView("redirect:/clientes/".concat(cliente.getId().toString()));
		}
		
		return null ;
	}
	
	@GetMapping("clientes/{id}/delete")
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/clientes");
		
		this.clienteRepository.deleteById(id);
		model.addObject("mensagem", "Produto removido com sucesso!");
		
		return model;
	}
	
	
	
	
	
}
