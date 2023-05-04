package oh.mycode.ohmycode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class Usuario {


    private int id;
    private String name;

    private String username;

    private String password;

    private Address address;




}
