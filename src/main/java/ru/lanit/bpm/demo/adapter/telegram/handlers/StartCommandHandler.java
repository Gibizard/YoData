package ru.lanit.bpm.demo.adapter.telegram.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lanit.bpm.demo.domain.User;

import java.util.Optional;

@Component("startTelegramCommandHandler")
public class StartCommandHandler implements CommandHandler {
    @Override
    public void handleMessage(Update update, Optional<User> user, SendMessage response) {
        if (user.isPresent()) {
            response.setText("Введите пароль");
        } else {
            response.setText("Введите логин");
        }
    }
}
