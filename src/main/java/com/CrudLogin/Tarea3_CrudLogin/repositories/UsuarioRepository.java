package com.CrudLogin.Tarea3_CrudLogin.repositories;

import com.CrudLogin.Tarea3_CrudLogin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
