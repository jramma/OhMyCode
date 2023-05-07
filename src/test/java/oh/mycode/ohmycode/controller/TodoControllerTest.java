package oh.mycode.ohmycode.controller;



import oh.mycode.ohmycode.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(oh.mycode.ohmycode.controller.TodoController.class)
public class TodoControllerTest {

    @MockBean
    private TodoService todoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "username", password = "password")
    public void testInicio() throws Exception {
        MvcResult result = mockMvc.perform(get("/")
                        .with(user("username").password("password")))
                .andExpect(status().isOk())
                .andExpect(view().name("listado"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attributeExists("todos"))
                .andExpect(model().attributeExists("current"))
                .andExpect(model().attributeExists("next"))
                .andExpect(model().attributeExists("prev"))
                .andExpect(model().attributeExists("last"))
                .andReturn();
    }
}