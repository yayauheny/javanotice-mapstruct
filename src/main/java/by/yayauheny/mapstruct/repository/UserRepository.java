package by.yayauheny.mapstruct.repository;

import by.yayauheny.mapstruct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
