package oh.mycode.ohmycode.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginUserDto {
	@NotBlank(message = "username is mandatory")
	//@Indexed(unique = true)
	private String username;
	@NotBlank(message = "password is mandatory")
	private String password;	
	
}
