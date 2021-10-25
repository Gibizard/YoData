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
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.addUser(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getTelegramId(), user.getRole());
            return ResponseEntity.ok("success");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body("Duplicate Entity: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getTelegramId(), user.getRole());
            return ResponseEntity.ok("success");
        } catch (EntityDoesnotExistException e) {
            return ResponseEntity.badRequest().body("User with login: " + user.getLogin() + " doesn't exist: "+ e.getMessage());
        }
    }

    @GetMapping("/{login}")
    public User getUser(@PathVariable String login) throws EntityDoesnotExistException {
        return userService.findUserByLogin(login).orElseThrow();
    }

    @GetMapping("/delete/{login}")
    public ResponseEntity<String> deleteUser(@PathVariable String login) {
        try {
            userService.deleteUser(login);
            return ResponseEntity.ok("Success");
        } catch (EntityDoesnotExistException e) {
            return ResponseEntity.badRequest().body("No such user: " + e.getMessage());
        }
    }

    @GetMapping("/updatePassword/{login};{password}")
    public ResponseEntity<String> updatePassword(@PathVariable String login, @PathVariable String password) {
        try {
            userService.updatePassword(login, password);
            return ResponseEntity.ok("Success");
        } catch (EntityDoesnotExistException e) {
            return ResponseEntity.badRequest().body("Unable to update password: " + e.getMessage());
        }
    }

    @GetMapping("/checkPassword/{login};{password}")
    public ResponseEntity<String> checkPassword(@PathVariable String login, @PathVariable String password) throws EntityDoesnotExistException {
        if (userService.findUserByLogin(login).isPresent()) {
            if (userService.checkPasswordByLogin(login, password)) {
                return ResponseEntity.ok("Success");
            } else {
                return ResponseEntity.badRequest().body("That's not user's password");
            }
        } else return ResponseEntity.badRequest().body("No such user at all...");
    }
}
