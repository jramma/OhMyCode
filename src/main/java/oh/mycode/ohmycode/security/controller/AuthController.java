package oh.mycode.ohmycode.security.controller;


import jakarta.validation.Valid;
import oh.mycode.ohmycode.exception.AttributeException;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.security.dto.CreateUserDto;
import oh.mycode.ohmycode.security.dto.JwtTokenDto;
import oh.mycode.ohmycode.security.dto.LoginUserDto;
import oh.mycode.ohmycode.security.dto.Mensaje;
import oh.mycode.ohmycode.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    UserService userService;
	
    @PostMapping("/create")
    public ResponseEntity<Mensaje> create(@Valid @RequestBody CreateUserDto dto) throws AttributeException {
        Usuario usuario = userService.create(dto);
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, "user " + usuario.getUsername() + " have been created"));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginUserDto dto) throws AttributeException {
        JwtTokenDto jwtTokenDto = userService.login(dto);
        return ResponseEntity.ok(jwtTokenDto);
    }
}
