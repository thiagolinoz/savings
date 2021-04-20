package com.linoz.savings.mapper;

import com.linoz.savings.dto.UserPostDTO;
import com.linoz.savings.dto.UserPutDTO;
import com.linoz.savings.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by linoz on 4/13/21
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserPostDTO userPostDTO);

    User toUser(UserPutDTO userPutDTO);
}
