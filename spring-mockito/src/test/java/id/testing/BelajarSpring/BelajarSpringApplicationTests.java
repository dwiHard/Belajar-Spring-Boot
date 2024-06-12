package id.testing.BelajarSpring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import id.testing.BelajarSpring.DTO.User;
import id.testing.BelajarSpring.repos.UserRepository;
import id.testing.BelajarSpring.service.UserService;

@SpringBootTest
class BelajarSpringApplicationTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	void contextLoads() {
        User user = new User("1", "Vinson");
        Mockito.when(userRepository.findUserById("1")).thenReturn(user);

        User result = userService.getUserById("1");
        assertNotNull(result);
        assertEquals("Vinson", result.getName());
	}

}
