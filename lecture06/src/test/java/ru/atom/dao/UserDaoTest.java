package ru.atom.dao;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.atom.model.User;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 3/25/17.
 */
public class UserDaoTest {
    private UserDao userDao;
    private String login;
    private User user;
    private int usersBeforeTest;


    @Before
    public void setUp() {
        userDao = new UserDao();
        login = "Lolita " + new Random().nextInt(999999);
        user = new User().setLogin(login);
        usersBeforeTest = userDao.getAll().size();

        userDao.insert(user);
    }

    @Test
    public void getAllTest() {
        assertTrue(userDao.getAll().size() > 0);
    }

    @Test
    public void insertTest() {
        assertEquals(usersBeforeTest + 1, userDao.getAll().size());
    }

    @Test
    public void findWhereTest() {
        List<User> lol = userDao.getAllWhere("login like 'Lol%'");
        assertTrue(
                lol.stream()
                        .map(User::getLogin)
                        .anyMatch(s -> s.startsWith(login))
        );
    }

}