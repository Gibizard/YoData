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
 * UserREstAdapter$
 */
package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/users")
public class UserRestAdapter {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.addUser(user.getLogin(), user.getPassword(), user.getFistName(), user.getLastName(), user.getTelegramId());
            return ResponseEntity.ok("success");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body("Duplicate Entity: " + e.getMessage());
        }
    }
}
