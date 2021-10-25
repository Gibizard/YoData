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
import org.springframework.data.repository.CrudRepository;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByLogin(String userLogin) throws EntityDoesnotExistException;

    Optional<User> getUserByTelegramId(String telegramId);

    void addUser(User newUser) throws DuplicateEntityException;

    void addUser(String login, String password, @NonNull String firstName, String lastName, String telegramId, String role) throws DuplicateEntityException;

    void updateUser(String login, String password, @NonNull String firstName, String lastName, String telegramId, String role) throws EntityDoesnotExistException;

    void updatePassword(String login, String text) throws EntityDoesnotExistException;

    List<User> getAllUsers();

    void deleteUser(String login) throws EntityDoesnotExistException;

    boolean checkPasswordByLogin(String login, String password);

    Map<ParsingResult, List<User>> fetchUnsentResults();
}
