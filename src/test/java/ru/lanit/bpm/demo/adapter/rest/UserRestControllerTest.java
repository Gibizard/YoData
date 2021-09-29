/*
 * Copyright (c) 2008-2021
 * LANIT
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * LANIT and its licensors, if any.
 *
 * UserRestAdapterTest$
 */
package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.adapter.rest.UserRestController;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@SpringBootTest(classes = UserRestController.class)
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class UserRestControllerTest {
    private final UserRestController userRestController;
    @Mock
    UserService userService;

/*
    @BeforeEach
    void setUp() {
        userRestAdapter = new UserRestAdapter(userService);
    }
*/

/*
    @Test
    @Transactional
    void createUser() {
        ResponseEntity<String> response = userRestController.createUser(new User("a", "b", "c", "d", "e"));

        assertEquals(200, response.getStatusCode().value());
        assertEquals("success", response.getBody());
    }

    @Test
    @Transactional
    void createUser_error_duplicate() throws DuplicateEntityException {
        doThrow(new DuplicateEntityException("bad"))
                .when(userService)
                .addUser("a","b","c","d","e");

        ResponseEntity<String> response = userRestController.createUser(new User("a", "b", "c", "d", "e"));

        assertEquals(400, response.getStatusCode().value());
        assertEquals("Duplicate Entity: bad", response.getBody());
    }

    @Test
    void getUsers() {
        List<User> users = userRestController.getUsers();

        assertTrue(users.size() > 0);;
    }

    @Test
    void getUser() throws EntityDoesnotExistException {
        assertNotNull(userRestController.getUser("DGiba"));
    }
*/
}
