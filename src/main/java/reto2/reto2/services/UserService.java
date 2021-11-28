package reto2.reto2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto2.reto2.models.UserModel;
import reto2.reto2.repositories.UserRepository;

/**
 * @author Jonathan David Mancera R
 * @version 1
 */

@Service
public class UserService {
    /**
     * Inyección de dependencias y relación de clases
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Devuelve una colección de registros encontrados en la base de datos
     * 
     * @return
     */
    public List<UserModel> obtenerUsuarios() {
        return (List<UserModel>) userRepository.findAll();
    }

    /**
     * Se pasa como argumento una instancia de usuario y lo guarda en userRepository
     * usando el método save de MongoRepository
     * 
     * @param user
     * @return
     */
    public UserModel guardarUsuario(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * Este método devuelve una colección pero hace exactamente lo mismo que el
     * siguiente,solo cambia el valor retornado, si existe devuelve toda la
     * información del email correspondiente
     * 
     * @param email
     * @return
     */
    public ArrayList<UserModel> obtenerPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Se pasa como argumento email, posteriormente el metodo findByEmail declarado
     * en UserRepository buscara dicho argumento y devuelve un arrayList si existe y
     * también verifica que la colección este vacia, si está vacia devuelve un true,
     * por lo que se niega (!) al retornar el método
     * 
     * @param email
     * @return
     */
    public boolean retornarUsuario(String email) {
        return !userRepository.findByEmail(email).isEmpty();
    }

    /**
     * Recibe como argumento user, lo que sería igual a id, es simplemente por
     * buenas prácticas y no crear variables de menos de 4 palabras
     * 
     * @param user
     * @return
     */
    public boolean eliminarUsuario(String user) {
        try {
            userRepository.deleteById(user);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    /**
     * Se guarda en usuario el resultado de optional, también se invierte el valor devuelto
     * y si está vacio devuelve un nuevo objeto con todos los argumentos en null.
     * @param email
     * @param password
     * @return
     */
    public UserModel atenticarUsuario(String email, String password) {
        Optional<UserModel> usuario = userRepository.findByEmailAndPassword(email, password);

        if (!usuario.isEmpty()) {
            return usuario.get();
        } else {
            return new UserModel(null, null, null, null, null, null, null, null, null);
        }
    }

}
