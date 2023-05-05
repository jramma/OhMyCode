package oh.mycode.ohmycode.dto;

import lombok.Data;
import oh.mycode.ohmycode.model.Address;

@Data
public class UserNotRegistredDto {
    private int id;
    private String name;

    private String username;

    private String password;

    private Address address;
    private String street;
    private String city;
    private String zipcode;
    private String country;
}
