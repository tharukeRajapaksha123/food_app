package com.test_api.hello_workd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id 
    private String id;
    private String notificationId;
    private String message;
    private String notificatedTo;
    private LocalDate notificatedAt;
}
