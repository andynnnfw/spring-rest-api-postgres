package com.api_banco.postgreSQL.repository;

import com.api_banco.postgreSQL.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
