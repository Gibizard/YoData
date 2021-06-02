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
 * UserService$
 */
package ru.lanit.bpm.demo.app;

import lombok.NonNull;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * todo Document type UserService
 */
public interface UserService {

    User findUserByLogin(String userLogin) throws EntityDoesnotExistException;

    Optional<User> getUserByTelegramId(String telegramId);

    void addUser(String text, String s, @NonNull String firstName, String lastName, String toString) throws DuplicateEntityException;

    void updatePassword(String login, String text) throws EntityDoesnotExistException;

    List<User> getAllUsers();
}