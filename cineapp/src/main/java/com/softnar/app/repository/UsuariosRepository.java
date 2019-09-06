package com.softnar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softnar.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {

}
