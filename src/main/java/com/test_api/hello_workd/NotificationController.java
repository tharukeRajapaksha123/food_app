package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notification createNotification(@RequestBody Notification Notification){
        return service.addNotification(Notification);
    }

    @GetMapping
    public List<Notification> getNotifications() {
        return service.findAllNotifications();
    }


    @GetMapping("/{NotificationId}")
    public Notification getNotification(@PathVariable String NotificationId){
        return service.getNotificationByNotificationId(NotificationId);
    }

    

    @PutMapping
    public Notification modifyNotification(@RequestBody Notification Notification){
        return service.updateNotification(Notification);
    }

    @DeleteMapping("/{NotificationId}")
    public String deleteNotification(@PathVariable String NotificationId){
        return service.deleteNotification(NotificationId);
    }
}
