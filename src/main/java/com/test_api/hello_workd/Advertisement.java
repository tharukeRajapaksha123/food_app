package com.test_api.hello_workd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Advertisement {
    @Id 
    private String advertisementId;
    private String imageUrl;
    private String description;
    private LocalDate publishedAt;
    private String visitLink;
}
