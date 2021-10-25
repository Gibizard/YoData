package ru.lanit.bpm.demo.adapter.telegram.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.domain.User;

import java.util.Optional;


@Component("createUserTelegramCommandHandler")
@RequiredArgsConstructor
public class CreateUserCommandHandler implements CommandHandler{
    private final UserService userService;

    @Override
    public void handleMessage(Update update, Optional<User> user, SendMessage response) {
        String id = update.getMessage().getFrom().getId().toString();
        String firstName = update.getMessage().getFrom().getFirstName();
        String lastName = update.getMessage().getFrom().getLastName();
        String login = update.getMessage().getText();
        String role = "USER";

        try {
            userService.addUser(login, "", firstName, lastName, id, role);
            response.setText("Введите пароль");
        } catch (DuplicateEntityException e) {
            response.setText("Пользователь с таким логином уже существует");
        }
    }
}
