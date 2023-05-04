package oh.mycode.ohmycode.security.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import oh.mycode.ohmycode.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPrincipal implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	// no construye, devuelve un details de un usuario
	public static UsuarioPrincipal build(Usuario user) {
		Collection<GrantedAuthority> authorities = 
				user.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.name()))
				.collect(Collectors.toList());
		return new UsuarioPrincipal(user.getUsername(), 
				user.getPassword(), authorities);

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}