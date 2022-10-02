package com.web.backend.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "data")
public class UserEntity {

    @Id
    private ObjectId id;

    private String username;
    private String password;

}
