package Ooyd.wantedpreonboardingbackend.repository;

import Ooyd.wantedpreonboardingbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
