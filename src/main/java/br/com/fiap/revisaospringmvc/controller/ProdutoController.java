package br.com.fiap.revisaospringmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.revisaospringmvc.model.Produto;

@Controller
public class ProdutoController {

	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("produtos/index");
		Produto produto1 = new Produto(1L, "Chocolate	", 3, 2 );
		Produto produto2 = new Produto(2L, "Chocolate belga", 100, 40 );
		Produto produto3 = new Produto(3L, "Chocolate branco", 40, 30 );
		
		List<Produto> produtos = Arrays.asList(produto1,produto2, produto3 );
		
		modelView.addObject("listarProdutos", produtos);
		
		return modelView;
		  
	}
	
}
