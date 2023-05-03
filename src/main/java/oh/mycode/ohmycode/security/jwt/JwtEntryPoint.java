package oh.mycode.ohmycode.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Comprueba si existe un token si no devuelve un 401 no autorizado
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
	// Implementamos un logger para ver cual metodo da error en caso de falla
	private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	//Metodo implementado de AuthenticationEntryPoint
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
						 AuthenticationException authException) throws IOException, ServletException {
		logger.error("token not found or invalid");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthoized");
	}
}

