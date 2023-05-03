package oh.mycode.ohmycode;

import oh.mycode.ohmycode.model.Address;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.User;
import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OhmycodeApplication {

//	@Autowired
//	TodoService service;


	public static void main(String[] args) {
		SpringApplication.run(OhmycodeApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//
//		User user = new User(1, "Juan","juanTo","password",new Address("c calle china","Shanghai","12345","China"));
//		Todo todo = new Todo(1, "limpiar cocina", false, user );
//
//		service.saveTodo(todo);
//		service.saveUser(user);
//		User user1 = new User(2, "Marta","martaVa","password1",new Address("c San Antonio","Barcelona","08080","Spain"));
//		Todo todo1 = new Todo(2, "Escribir mail", false, user );
//
//		service.saveTodo(todo1);
//		service.saveUser(user1);
//
//
//
//	}






}
