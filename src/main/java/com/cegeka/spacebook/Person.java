package com.cegeka.spacebook;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String username;
    private List<Person> friends;
    private List<Message> receivedMessages;

    public Person(String username) {
        if(StringUtils.isBlank(username)) {
            throw new IllegalArgumentException();
        }

        this.username = username;
        this.friends = new ArrayList<Person>();
        this.receivedMessages = new ArrayList<Message>();
    }

    public String getUsername() {
        return username;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person friend) {
        if(friend.equals(this)) {
            throw new IllegalArgumentException();
        }

        this.friends.add(friend);

        ensureBidirectionalFriendship(friend);
    }

    private void ensureBidirectionalFriendship(Person friend) {
        if(friend.hasFriend(this)) {
            return;
        }
        friend.addFriend(this);
    }

    public boolean hasFriend(Person friend) {
        return this.friends.contains(friend);
    }

    public void sendMessage(Person friend, Message message) {
        if(!friend.hasFriend(this)) {
            throw new IllegalArgumentException();
        }
        friend.receive(message);
    }

    private void receive(Message message) {
        receivedMessages.add(message);
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public List<Message> getReceivedMessagesByDate() {
        Collections.sort(receivedMessages, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return receivedMessages;
    }


}
