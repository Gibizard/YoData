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
 * $
 */
package ru.lanit.bpm.demo.adapter.telegram;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.User;

import java.util.Optional;

/**
 * todo Document type BotTelegramAdapterImpl
 */

@RequiredArgsConstructor
@Slf4j
public class BotTelegramAdapterImpl extends TelegramLongPollingBot implements TelegramAdapter {
    private static final String START_COMMAND = "/start";

    private final UserService userService;

    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.token}")
    private String botUsername;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("UpdateRecieved: {}", update);
        SendMessage response = new SendMessage();
        if (update.hasMessage()) {
            Long telegramId = update.getMessage().getFrom().getId();
            response.setChatId(telegramId.toString());
            Optional<User> user = userService.getUserByTelegramId(telegramId.toString());
            if (START_COMMAND.equals(update.getMessage().getText())) {
                // предлагаем зарегаться
                handleStartCommand(response, update, user);
            } else {
                // обрабатываем инфу
                if (user.isPresent()) {
                    handleNewPassword(response, update, user);
                } else {
                    createUser(update, response);
                }
            }
            try {
                execute(response);
            } catch (TelegramApiException e) {
                log.error("Unable to send response", e);
            }
        }

    }

    private void createUser(Update update, SendMessage response) {
        Long telegramId = update.getMessage().getFrom().getId();
        try {
            userService.addUser(
                    update.getMessage().getText(),
                    "",
                    update.getMessage().getFrom().getFirstName(),
                    update.getMessage().getFrom().getLastName(),
                    telegramId.toString()
            );
            response.setText("User added. Enter password");
        } catch (DuplicateEntityException e) {
            response.setText("This login already exists");
        }
    }

    private void handleNewPassword(SendMessage response, Update update, Optional<User> user) {
        try {
            userService.updatePassword(user.orElseThrow().getLogin(), update.getMessage().getText());
            response.setText("Password changed, send another if you want to change it");
        } catch (EntityDoesnotExistException e) {
            log.error("Unexpected error");
        }
    }

    private void handleStartCommand(SendMessage response, Update update, Optional<User> user) {
        if (user.isPresent()) {
            response.setText("Введите пароль");
        } else {
            response.setText("Введите логин");
        }
    }

    @Override
    public void sendMessage(String telegramId, String message) {
        SendMessage newMessage = new SendMessage();
        newMessage.setChatId(telegramId);
        newMessage.setText(message);

        try {
            execute(newMessage);
        } catch (TelegramApiException e) {
            log.error("Unable to send message", e);
        }
    }
}
