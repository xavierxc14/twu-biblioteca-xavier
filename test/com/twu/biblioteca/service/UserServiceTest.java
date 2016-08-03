package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    @Test
    public void shouldLoginAUser() throws Exception {
        assertEquals(new User("Xavier", "6543-1234", "12345", "xnaunay@thoughtworks.com", "0987654321"),
                UserService.getInstance().login("6543-1234", "12345"));
    }
}
