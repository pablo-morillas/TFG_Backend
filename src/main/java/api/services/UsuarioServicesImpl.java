package api.services;

import api.dao.UsuarioDAO;
import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

import static com.tfg.Project.GestorUsuarios.validatePassword;

@Service("usuarioservices")
@Transactional
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    @Qualifier("usuariorepository")
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean altaUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario) != null;
    }

    @Override
    public boolean deleteUsuarioByEmail(String email) {
        boolean result = false;
        Usuario usuario = findByEmail(email);
        if(usuario != null) {
            result = deleteUsuario(usuario);
        }
        return result;
    }

    @Override
    public boolean deleteUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
        return !usuarioDAO.findById(usuario.getEmail()).isPresent();
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    @Override
    public Usuario findByEmail(String email) {
        Usuario usuario = null;
        Optional<Usuario> user = usuarioDAO.findById(email);
        if (user.isPresent()) usuario = user.get();
        return  usuario;
    }

    @Override
    public boolean login(String email, String password) {
        try{
            boolean result = false;
            Usuario usuario = findByEmail(email);
            if (usuario != null) result = validatePassword(password,usuario.getPassword());
            return result;
        }catch (InvalidKeySpecException | NoSuchAlgorithmException e){
            return false;
        }
    }
}
