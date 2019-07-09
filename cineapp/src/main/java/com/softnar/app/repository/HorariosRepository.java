package com.softnar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softnar.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

}
