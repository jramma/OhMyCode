package oh.mycode.ohmycode.util;

import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.User;

import java.util.Comparator;
import java.util.List;

public class Utils {

    public int autoIncrement(List<Todo> list) {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.stream().max(Comparator.comparing(Todo::getId)).get().getId() + 1;
        }
        return id;
    }

    public int idIncrement(List<User> list) {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.stream().max(Comparator.comparing(User::getId)).get().getId() + 1;
        }
        return id;
    }
}
