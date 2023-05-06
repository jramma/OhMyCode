package oh.mycode.ohmycode.service;

import oh.mycode.ohmycode.dto.UserNotRegistredDto;
import oh.mycode.ohmycode.dto.Address;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.repos.UserRepository;
import oh.mycode.ohmycode.util.Increment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public boolean save(UserNotRegistredDto userDto) {
        Optional yaexiste = userRepo.findOneByUsername(userDto.getUsername());
        boolean success = false;
        if (yaexiste.isEmpty()) {
            int id = Increment.idIncrement(userRepo.findAll());
            Address address = new Address(userDto.getStreet(),
                    userDto.getCity(),
                    userDto.getZipcode(),
                    userDto.getCountry());
            Usuario usuario = new Usuario(id,
                    userDto.getName(),
                    userDto.getUsername(),
                    new BCryptPasswordEncoder().encode(userDto.getPassword()),
                    address);
            userRepo.save(usuario);
            success = true;
        }
        return success;
    }
}
