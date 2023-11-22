package pfe.micro.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.User;
import pfe.micro.auth.repository.UserRepository;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

     // Sample User for testing
     private User sampleUser;

     @Before
     public void setUp() {
         // Initialize sample User
         sampleUser = new User();
         sampleUser.setUserName("testUser");
         sampleUser.setPassword("testPassword");
         sampleUser.setRole(Role.ASSUREE);
    }

    // Your test code here

}

    

    @Test
    public void testPostUser() throws Exception {
        // Create a new user
        User newUser = new User();
        newUser.setUserName("newUser");
        newUser.setPassword("newPassword");
        newUser.setRole(Role.ASSUREE);

        // Perform a POST request to create the user
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userName").value("newUser"))
                .andExpect(jsonPath("$.role").value("ASSUREE"));
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        // Perform a GET request to retrieve the existing user
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/{username}", "testUser"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        User retrievedUser = objectMapper.readValue(content, User.class);

        // Verify the retrieved user's properties
        assertEquals("testUser", retrievedUser.getUserName());
        assertEquals("ASSUREE", retrievedUser.getRole().name());
    }

    // Add more test cases as needed for your specific requirements
}
