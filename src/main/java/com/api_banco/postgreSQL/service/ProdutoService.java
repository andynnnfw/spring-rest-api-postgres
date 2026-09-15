package com.api_banco.postgreSQL.service;

import com.api_banco.postgreSQL.model.Produto;
import com.api_banco.postgreSQL.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
