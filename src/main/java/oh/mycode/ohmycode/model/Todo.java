package oh.mycode.ohmycode.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "todo")
public class Todo {
    @NonNull
    @Id
    private int id;
    @NonNull
    private String title;
    @NonNull
    private boolean completed;
    @NonNull
    private Usuario user;
    // ManyToOne


    public Todo(String title, Usuario user) {
        this.title = title;
        this.user = user;
        this.completed = false;
    }
}
