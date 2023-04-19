package com.test_api.hello_workd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String postCaption;
    private String imageUrl;
    private String postedBy;
    private LocalDate postedAt;
}
