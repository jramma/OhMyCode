package oh.mycode.ohmycode.dto;


import org.junit.jupiter.api.Test;

import static com.mongodb.assertions.Assertions.assertFalse;
import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoDtoTest {

    @Test
    public void testTodoDto() {
        // Test valid input
        TodoDto todoDto = new TodoDto(1, "Title", "Username", "Country", false);
        assertNotNull(todoDto);
        assertEquals(1, todoDto.getId());
        assertEquals("Title", todoDto.getTitle());
        assertEquals("Username", todoDto.getUsername());
        assertEquals("Country", todoDto.getCountry());
        assertFalse(todoDto.isCompleted());

        // Test empty title input
        assertThrows(IllegalArgumentException.class, () -> new TodoDto(1, "", "Username", "Country", false));

        // Test null title input
        assertThrows(IllegalArgumentException.class, () -> new TodoDto(1, null, "Username", "Country", false));

        // Test null username input
        assertThrows(IllegalArgumentException.class, () -> new TodoDto(1, "Title", null, "Country", false));

        // Test null country input
        assertThrows(IllegalArgumentException.class, () -> new TodoDto(1, "Title", "Username", null, false));
    }
}