package com.softnar.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softnar.app.model.Noticia;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
	

}
