package com.web.backend.service;

import com.web.backend.entity.UserEntity;
import com.web.backend.response.UserDto;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Named("objectIdToString")
    public String objectIdToString(ObjectId objectId) {
        return objectId.toString();
    }

    @Named("StringToObjectId")
    public ObjectId StringToObjectId(String stringValue) {

        if (stringValue == null || stringValue.length() == 0)
            return null;

        return new ObjectId(stringValue);
    }

    public abstract UserDto userEntityToUserDto(UserEntity userEntity);
}
