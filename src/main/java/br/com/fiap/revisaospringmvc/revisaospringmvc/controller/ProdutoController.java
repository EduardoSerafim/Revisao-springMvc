package br.com.fiap.revisaospringmvc.revisaospringmvc.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.revisaospringmvc.revisaospringmvc.dto.ProdutoDto;
import br.com.fiap.revisaospringmvc.revisaospringmvc.model.Produto;
import br.com.fiap.revisaospringmvc.revisaospringmvc.repositories.ProdutoRepository;


@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("produtos/index");
		
		List<Produto> produtoDaRepository = produtoRepository.findAll();
		modelView.addObject("listarProdutos", produtoDaRepository);
		
		return modelView;
		  
	}
	
	@GetMapping("/produtos/criar")
	public ModelAndView criar() {
		ModelAndView modelView = new ModelAndView("produtos/criar");
		return modelView; 
	}
	
	@PostMapping("produtos")
	public String salvar(ProdutoDto produto) {
		Produto produtoEntity = modelMapper.map(produto, Produto.class); 
		
		produtoRepository.save(produtoEntity);
		
		return "redirect:/produtos ";
	}
	
}
