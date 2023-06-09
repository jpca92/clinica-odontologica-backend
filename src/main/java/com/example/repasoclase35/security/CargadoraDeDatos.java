package com.example.repasoclase35.security;

import com.example.repasoclase35.domain.Usuario;
import com.example.repasoclase35.domain.UsuarioRol;
import com.example.repasoclase35.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadoraDeDatos implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;
    @Autowired
    public CargadoraDeDatos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passACifrar="1234";
        String passACifrar2="1234";
        String passCifrada=cifrador.encode(passACifrar);
        String passCifrada2=cifrador.encode(passACifrar2);
        Usuario usuarioAInsertar= new Usuario("Rodolfo","Baspineiro",
                "rodo@gmail.com",passCifrada, UsuarioRol.ROLE_USER);
        Usuario usuarioAInsertar2= new Usuario("RodoAdmin","Baspi",
                "rodoAdmin@gmail.com",passCifrada, UsuarioRol.ROLE_ADMIN);
        usuarioRepository.save(usuarioAInsertar);
        usuarioRepository.save(usuarioAInsertar2);
    }
}
