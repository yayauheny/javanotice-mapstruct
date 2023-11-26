package by.yayauheny.mapstruct.mapper;

import by.yayauheny.mapstruct.dto.UserCreateDto;
import by.yayauheny.mapstruct.dto.UserResponse;
import by.yayauheny.mapstruct.entity.User;
import by.yayauheny.mapstruct.utils.mapper.UserMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                UserMapperUtil.class
        },
        imports = {
                LocalDate.class
        })
public interface UserMapper {

    @Mapping(target = "email", ignore = true)
    UserResponse toUserResponse(User user); //map User to UserResponse

    List<UserResponse> toUserResponseList(List<User> users); //map list of User to list of UserResponse

    @Mapping(target = "password", qualifiedByName = {"UserMapperUtil", "getPasswordFromUsername"}, source = "username")
    User fromUserCreateDto(UserCreateDto userCreateDto);

//    @Named("getPasswordFromUsername")
//    default String getPasswordFromUsername(String username) {
//        return username + " generatedPassword222";
//    }
}
