package com.cegeka.spacebook;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PersonTest {

    @Test
    public void Person_givenUsername_thenPersonCreated() {
        Person person = new Person("randomUsername");

        assertThat(person).isNotNull();
    }

    @Test
    public void getUsername_givenUsername_thenUsernameIsThePassedUsername() {
        String randomUsername = "randomUsername";
        Person person = new Person(randomUsername);

        assertThat(person.getUsername()).isEqualTo(randomUsername);
    }

    @Test
    public void getFriends_givenUsername_thenPersonHasListOfFriends() {
        Person person = new Person("randomUsername");

        assertThat(person.getFriends()).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenNullUsername_thenIllegalArgumentException() {
        new Person(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenEmptyUsername_thenIllegalArgumentException() {
        new Person("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenUsernameOnlySpaces_thenIllegalArgumentException() {
        new Person(" ");
    }
}
