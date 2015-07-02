package com.cegeka.spacebook;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PersonTest {

    @Test
    public void Person_givenUsername_thenPersonCreated() {
        Person person = new Person("randomUsername");

        assertThat(person).isNotNull();
    }
}
