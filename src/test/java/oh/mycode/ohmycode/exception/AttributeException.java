package oh.mycode.ohmycode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AttributeException extends Exception {
    public AttributeException(String message) {
        super(message);
    }
}
