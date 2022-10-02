package com.web.backend.entity;

import com.web.backend.constants.Role;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "users")
public class UserEntity {

    @Id
    private ObjectId id;

    private String username;
    private String password;

    private String role;

}
