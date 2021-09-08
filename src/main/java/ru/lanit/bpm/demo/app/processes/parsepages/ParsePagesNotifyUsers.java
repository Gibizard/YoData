package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.lanit.bpm.demo.adapter.telegram.TelegramAdapter;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Map;

@Slf4j
@Component("notifyUsersDelegate")
@RequiredArgsConstructor
public class ParsePagesNotifyUsers implements JavaDelegate {
    private final UserService userService;
    private final ParsingResultService parsingResultService;
    private final TelegramAdapter telegramAdapter;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Parsing completed, now notify");
        Map<ParsingResult, List<User>> parsingResultListMap = userService.fetchUnsentResults();
        parsingResultListMap.forEach((parsingResult, users) -> {
            users.forEach(user -> {
                telegramAdapter.sendMessage(user.getTelegramId(), "Parsing results: " + parsingResult.getResult());
            });
            parsingResultService.markResultSent(parsingResult);
        });
    }
}
