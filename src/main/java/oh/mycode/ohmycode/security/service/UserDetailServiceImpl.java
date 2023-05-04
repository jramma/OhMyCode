package oh.mycode.ohmycode.security.service;



import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username);
		if (usuario == null)
			return null;
		return UsuarioPrincipal.build(usuario);
	}

}