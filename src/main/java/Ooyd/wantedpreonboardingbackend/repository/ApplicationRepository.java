package Ooyd.wantedpreonboardingbackend.repository;

import Ooyd.wantedpreonboardingbackend.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
