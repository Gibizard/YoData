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
package ru.lanit.bpm.demo.fw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ru.lanit.bpm.demo.adapter.rest.UserRestAdapter;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

/**
 * todo Document type UserRestAdapterTest
 */
@ExtendWith(MockitoExtension.class)
public class UserRestAdapterTest {
    UserRestAdapter userRestAdapter;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        userRestAdapter = new UserRestAdapter(userService);
    }

    void success() {
        ResponseEntity<String> response = userRestAdapter.createUser(new User("a", "b", "c", "d", "e"));

        assertEquals(200, response.getStatusCode().value());
        assertEquals("success", response.getBody());
    }

    void error_duplicate() throws DuplicateEntityException {
        doThrow(new DuplicateEntityException("bad"))
                .when(userService)
                .addUser("a","b","c","d","e");

        ResponseEntity<String> response = userRestAdapter.createUser(new User("a", "b", "c", "d", "e"));

        assertEquals(400, response.getStatusCode().value());
        assertEquals("Duplicate Entity: bad", response.getBody());
    }
}
