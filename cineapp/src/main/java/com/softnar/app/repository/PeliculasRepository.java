/**
 * 
 */
package com.softnar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softnar.app.model.Pelicula;

/**
 * @author folio
 *
 */
@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {

}
