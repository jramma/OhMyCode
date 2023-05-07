package oh.mycode.ohmycode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TodoDto {
    private int id;
    private String title;
    private String username;
    private String country;
    private boolean completed;

    public TodoDto(int id, String title, String username, String country, boolean completed) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        }
        this.id = id;
        this.title = title;
        this.username = username;
        this.country = country;
        this.completed = completed;
    }
}



