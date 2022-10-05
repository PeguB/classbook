package com.web.backend.service;

import com.web.backend.entity.UserEntity;
import com.web.backend.response.UserDto;
import org.bson.types.ObjectId;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Named("objectIdToString")
    public String objectIdToString(ObjectId objectId) {
        return objectId.toString();
    }

    @Named("stringToObjectId")
    public ObjectId stringToObjectId(String stringValue) {

        if (stringValue == null || stringValue.length() == 0)
            return null;

        return new ObjectId(stringValue);
    }

    public abstract UserEntity userDtoToUserEntity(UserDto userDto);

    public abstract UserDto userEntityToUserDto(UserEntity userEntity);
}
