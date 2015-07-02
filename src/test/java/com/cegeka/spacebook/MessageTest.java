package com.cegeka.spacebook;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MessageTest {

    @Test
    public void Message_givenMessageBodyAndSender_thenMessageIsCreated() {
        Person sender = new Person("sender");
        Message message = new Message(sender, "message");

        assertThat(message).isNotNull();
    }

    @Test
    public void Message_givenMessageBodyAndSender_thenMessageIsCreatedWithSender() {
        Person sender = new Person("sender");
        Message message = new Message(sender, "message");

        assertThat(message.getSender()).isEqualTo(sender);
    }

    @Test
    public void Message_givenMessageBodyAndSender_thenMessageIsCreatedWithBody() {
        String body = "message";
        Person sender = new Person("sender");
        Message message = new Message(sender, body);

        assertThat(message.getBody()).isEqualTo(body);
    }

    @Test
    public void Message_givenMessageBodyAndSender_thenMessageIsCreatedWithDate() {
        String body = "message";
        Person sender = new Person("sender");
        Message message = new Message(sender, body);

        assertThat(message.getDate()).isNotNull();
    }

}
