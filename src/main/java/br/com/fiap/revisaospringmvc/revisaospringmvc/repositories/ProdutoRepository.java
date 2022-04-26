package br.com.fiap.revisaospringmvc.revisaospringmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.revisaospringmvc.revisaospringmvc.model.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
}
