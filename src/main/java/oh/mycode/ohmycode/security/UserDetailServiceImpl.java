package oh.mycode.ohmycode.security;

import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findOneByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario "+username+ " no existe"));

        return new UserDetailsImp(usuario);
    }
}
