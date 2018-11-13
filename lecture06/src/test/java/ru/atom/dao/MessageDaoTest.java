package ru.atom.dao;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.atom.model.Message;
import ru.atom.model.User;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 3/25/17.
 */
public class MessageDaoTest {
    private MessageDao messageDao;
    private String msg ;
    private Message message;
    private int messagesBeforeTest;
    private int userId;

    @Before
    public void setUp() {
        messageDao = new MessageDao();
        userId = new UserDao().getAll()
                .stream()
                .findFirst()
                .get()
                .getId();
        msg = "Hello World " + new Random().nextInt(999999);
        messagesBeforeTest = messageDao.getAll().size();
        message = new Message()
                .setUser(new User().setId(userId))
                .setValue(msg);

        messageDao.insert(message);
    }

    @Test
    public void getAllTest() {
        assertTrue(messageDao.getAll().size() > 0);
    }

    @Test
    public void insertTest() {
        assertEquals(messagesBeforeTest + 1, messageDao.getAll().size());
    }

}