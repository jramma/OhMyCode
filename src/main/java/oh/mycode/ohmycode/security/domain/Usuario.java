package oh.mycode.ohmycode.security.domain;

import lombok.Getter;
import lombok.Setter;
import oh.mycode.ohmycode.security.dto.Rol;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document (collection="users")
public class Usuario {
	
	@Id
	private String id;
	private String username;
	private String password;
	private List<Rol> roles;
	
	public Usuario(String username, String password, List<Rol>roles) {	
		this.username=username;
		this.password=password;
		this.roles=roles;
	}
	

}
