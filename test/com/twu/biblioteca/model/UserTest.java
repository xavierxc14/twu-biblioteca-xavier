package com.twu.biblioteca.model;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void shouldDisplayUserInformation() throws Exception {
        User user = new User("Xavier", "6543-1234", "12345", "xnaunay@thoughtworks.com", "0987654321");
        Assert.assertEquals("User Information:\n" +
                "\tName: Xavier\n" +
                "\tEmail: xnaunay@thoughtworks.com\n" +
                "\tPhone Number: 0987654321\n", user.toString());
    }
}