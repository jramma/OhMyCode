package oh.mycode.ohmycode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oh.mycode.ohmycode.dto.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class Usuario {

    @Id
    private int id;
    private String name;

    private String username;

    private String password;

    private Address address;




}
