package com.springboot.crudspring.repository;

import com.springboot.crudspring.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Integer> {

}
