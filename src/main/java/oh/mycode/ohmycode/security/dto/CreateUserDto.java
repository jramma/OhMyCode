package oh.mycode.ohmycode.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
	@NotBlank(message = "username is mandatory")
	private String username;
	@NotBlank(message = "password is mandatory")
	private String password;
	private String date;
	@NotEmpty(message = "roles are mandatory")
	private List<String> roles;

	public CreateUserDto(@NotBlank(message = "username is mandatory") String username,
			@NotBlank(message = "password is mandatory") String password,
			@NotEmpty(message = "roles are mandatory") List<String> roles) throws Exception {
		
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

}
