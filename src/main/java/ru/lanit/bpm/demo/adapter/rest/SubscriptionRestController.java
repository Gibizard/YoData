package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.bpm.demo.app.SubscriptionService;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.Subscription;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/subscriptions")
public class SubscriptionRestController {
    private final SubscriptionService subscriptionService;

    @GetMapping("/{login}")
    public List<Subscription> getUserSubscriptions(@PathVariable String login) {
        return subscriptionService.findSubscriptionByUser(login);
    }

    @PutMapping("/put")
    public ResponseEntity<String> createSubscription(@RequestBody Subscription subscription) {
        try {
            subscriptionService.addSubscription(subscription.getUser().getLogin(), subscription.getPage().getId());
            return ResponseEntity.ok("Success");
        } catch (EntityDoesnotExistException e) {
            return ResponseEntity.badRequest().body("Unable to create subscription: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePage(@PathVariable Long id) {

        if (subscriptionService.findSubscriptionById(id).isPresent()) {
            subscriptionService.deleteSubscription(id);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.badRequest().body("No such subscription");
        }
    }
}
