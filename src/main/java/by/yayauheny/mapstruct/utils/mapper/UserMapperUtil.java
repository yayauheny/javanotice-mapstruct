package by.yayauheny.mapstruct.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Random;

@Named("UserMapperUtil")
@Component
@RequiredArgsConstructor
public class UserMapperUtil {

    private final Random randomGenerator;

    @Named("getPasswordFromUsername")
    public String getPasswordFromUsername(String username) {
        return username + randomGenerator.nextInt(5000) + 2222;
    }
}
