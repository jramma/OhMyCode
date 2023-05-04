package oh.mycode.ohmycode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "todo")
public class Todo {


    private int id;
    private String title;

    private boolean completed;

    private Usuario user;
    // ManyToOne


    public Todo(String title, Usuario user) {
        this.title = title;
        this.user = user;
        this.completed = false;
    }
}
