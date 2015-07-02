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

    @Test
    public void addFriend_givenPersonToAdd_thenPersonIsInFriendList() {
        Person person = new Person("person");
        Person friend = new Person("friend");

        person.addFriend(friend);

        assertThat(person.hasFriend(friend)).isTrue();
    }

    @Test
    public void addFriend_givenPersonToAdd_thenFriendShipIsBidirectional() {
        Person person = new Person("person");
        Person friend = new Person("friend");

        person.addFriend(friend);

        assertThat(friend.hasFriend(person)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFriend_givenHimself_thenIllegalArgumentException() {
        Person person = new Person("person");

        person.addFriend(person);
    }

    @Test
    public void sendMessage_givenFriendAndMessage_thenMessageSent() {
        Person person = new Person("person");
        Person friend = new Person("friend");
        person.addFriend(friend);
        Message message = new Message(person, "message");

        person.sendMessage(friend, message);

        assertThat(friend.getReceivedMessages().contains(message)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void sendMessage_givenNotAFriendAndMessage_thenIllegalArgumentException() {
        Person person = new Person("person");
        Person notAFriend = new Person("notAFriend");
        Message message = new Message(person, "message");

        person.sendMessage(notAFriend, message);
    }

    @Test
    public void getReceivedMessagesByDate_givenPersonWithMessages_thenSortedMessagesReturned() {
        Person person = new Person("person");
        Person friend = new Person("friend");
        person.addFriend(friend);
        Message message = new Message(person, "message");
        Message message2 = new Message(person, "message2");

        friend.sendMessage(person, message);
        friend.sendMessage(person, message2);

        assertThat(person.getReceivedMessagesByDate().get(0)).isEqualTo(message);
        assertThat(person.getReceivedMessagesByDate().get(1)).isEqualTo(message2);
    }

}
