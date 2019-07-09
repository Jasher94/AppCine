package com.softnar.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softnar.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	//select *  from Noticias
	List<Noticia> findBy();
			
	//select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	//select * from Noticias where fecha = ?
	List<Noticia> findByFecha(Date fecha);
	
	//select * from Noticias where estauts=? and fecha=?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	//select * from Noticias where estauts=? Or fecha=? 
	List<Noticia> findByEstatusOrFecha(String estatus,Date fecha);
	
	//where fecha between ? and ?
	List<Noticia> findByFechaBetween(Date fecha1,Date fecha2);
	
	

}
