package oh.mycode.ohmycode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDto {
    private int id;
    private String title;
    private String username;
    private String country;
    private boolean completed;
}
