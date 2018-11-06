package ru.atom.mm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.atom.mm.controller.ConnectionController;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConnectionControllerTest {

    @Test
    public void connect() throws Exception {
        ConnectionController connectionHandler = new ConnectionController();
        assertTrue(connectionHandler.list().isEmpty());

        connectionHandler.connect(1, "a");
        connectionHandler.connect(2, "b");
        connectionHandler.connect(3, "c");

        assertFalse(connectionHandler.list().isEmpty());
    }

    @Test
    public void list() throws Exception {
        ConnectionController connectionHandler = new ConnectionController();
        assertTrue(connectionHandler.list().isEmpty());
        StringBuilder stringBuilder = new StringBuilder();

        connectionHandler.connect(1, "a");
        stringBuilder.append("Connection{playerId=1, name=\'a\'}");
        stringBuilder.append("%n");
        connectionHandler.connect(2, "b");
        stringBuilder.append("Connection{playerId=2, name=\'b\'}");
        stringBuilder.append("%n");
        connectionHandler.connect(3, "c");
        stringBuilder.append("Connection{playerId=3, name=\'c\'}");
        stringBuilder.append("%n");
        String expect = stringBuilder.toString();
        String actual = connectionHandler.list();
        assertTrue(expect.equalsIgnoreCase(actual));
    }

}