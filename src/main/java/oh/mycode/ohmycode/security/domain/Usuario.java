package oh.mycode.ohmycode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oh.mycode.ohmycode.model.Address;
import oh.mycode.ohmycode.security.dto.Rol;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class Usuario {
	
	@Id
	private String id;
	private String username;
	private String password;
	private Address address;
	private List<Rol> roles;
	
	public Usuario(String username, String password, Address address, List<Rol>roles) {
		this.username=username;
		this.password=password;
		this.roles=roles;
		this.address = address;
	}


	public Usuario(String username, String password, List<Rol> roles) {
		this.username=username;
		this.password=password;
		this.roles=roles;
	}
}
