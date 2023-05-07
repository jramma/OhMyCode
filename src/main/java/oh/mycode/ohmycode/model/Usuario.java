package oh.mycode.ohmycode.model;

import lombok.*;
import oh.mycode.ohmycode.dto.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class Usuario {
    @NonNull
    @Id
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private Address address;




}
