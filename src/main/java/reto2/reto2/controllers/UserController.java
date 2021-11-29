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
/**
 * @author Jonathan David Mancera - Sambas
 * @version 1
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    /**
     * Inyección de depencias y relación entre clases
     */
    @Autowired
    private UserService userService;

    /**
     * Devuelve una colección de UserModel en la ruta all
     * @return
     */
    @GetMapping("/all")
    public List <UserModel> listarUsuarios() {
        return userService.obtenerUsuarios();
    }

    /**
     *  Envia como cuerpo de la petición en un objeto de UserModel
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel guardar(@RequestBody UserModel user) {
        return userService.guardarUsuario(user);
    }

    /**
     * Utiliza el método put para la petición, pero utiliza el mismo método de guardar usuario, si encuentra un usuario con el mismo id, lo actualiza 
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel actualizarUsuario(@RequestBody UserModel user) {
        return userService.guardarUsuario(user);
    }

    /**
     * Por medio del id permite eliminar un usuario si existe
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String borrarUsuarioPorId(@PathVariable("id") Long id) {
        boolean valido = userService.eliminarUsuario(id);
        if (valido) {
            return "";
        } else {
            return "";
        }
    }

    /**
     * retorna un booleano si el email que se ha pasado existe, en el servicio el método está negado
     * @param email
     * @return
     */
    @GetMapping(path = "/emailexist/{email}")
    public boolean obtenerPorEmail(@PathVariable("email") String email) {
        return userService.retornarUsuario(email);
    }

    /**
     * Devuelve un objeto por medio de userService utilizando el método autenticasUsuario, retorna un objeto con todos sus argumentos en null en caso de que el objeto no exista
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public UserModel autenticar(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.atenticarUsuario(email, password);
    }
}
