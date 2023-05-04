package oh.mycode.ohmycode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private int id;
    private String text;
    private String username;
    private String country;
    private boolean completed;
}
