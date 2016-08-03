package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void shouldLoginUser() throws Exception {
        Assert.assertEquals(new User("Xavier", "xxx-xxxx", "12345"), new UserService().login("xxx-xxxx", "12345"));
    }
}
