package com.CrudLogin.Tarea3_CrudLogin.Controller;

import com.CrudLogin.Tarea3_CrudLogin.model.Usuario;
import com.CrudLogin.Tarea3_CrudLogin.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        repository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", repository.findAll());
        model.addAttribute("nuevoUsuario", new Usuario());
        return "crud";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuario inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/usuarios";
    }
}
