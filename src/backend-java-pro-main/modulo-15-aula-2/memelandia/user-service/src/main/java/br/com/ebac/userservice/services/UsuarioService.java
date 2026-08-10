package br.com.ebac.userservice.services;

import br.com.ebac.userservice.entities.Usuario;
import br.com.ebac.userservice.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        logger.info("Buscando todos os usuários");
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        logger.info("Buscando usuário com id={}", id);
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        logger.info("Salvando novo usuário com e-mail={}", usuario.getEmail());
        if(usuario.getDataCadastro() == null) {
            usuario.setDataCadastro(new java.sql.Date(System.currentTimeMillis()));
        }
        return usuarioRepository.save(usuario);
    }
}
