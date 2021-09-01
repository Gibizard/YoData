package ru.lanit.bpm.demo.adapter.telegram.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.User;

import java.util.Optional;

@RequiredArgsConstructor
@Component("updatePasswordTelegramCommandHandler")
public class UpdatePasswordCommandHandler implements CommandHandler {
    private final UserService userService;
    @Override
    public void handleMessage(Update update, Optional<User> user, SendMessage response) {
        String login = user.orElseThrow().getLogin();
        String password = update.getMessage().getText();

        try {
            userService.updatePassword(login, password);
            response.setText("Вы молодец!");
        } catch (EntityDoesnotExistException e) {
            response.setText("Пользователя с таким логином не существует");
        }
    }
}
