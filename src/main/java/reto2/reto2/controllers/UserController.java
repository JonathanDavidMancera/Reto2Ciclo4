package reto2.reto2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto2.reto2.models.UserModel;
import reto2.reto2.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List <UserModel> listarUsuarios() {
        return userService.obtenerUsuarios();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel guardar(@RequestBody UserModel user) {
        return userService.guardarUsuario(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel actualizarUsuario(@RequestBody UserModel user) {
        return userService.guardarUsuario(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String borrarUsuarioPorId(@PathVariable("id") String id) {
        boolean valido = userService.eliminarUsuario(id);
        if (valido) {
            return "";
        } else {
            return "";
        }
    }

    @GetMapping(path = "/emailexist/{email}")
    public boolean obtenerPorEmail(@PathVariable("email") String email) {
        return userService.retornarUsuario(email);
    }

    @GetMapping("/{email}/{password}")
    public UserModel autenticar(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.atenticarUsuario(email, password);
    }
}
