package oh.mycode.ohmycode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Todo {

    private int id;
    private String title;

    private boolean completed;

    private Usuario user;



    public Todo(String title, Usuario user) {
        this.title = title;
        this.user = user;
        this.completed = false;
    }
}
