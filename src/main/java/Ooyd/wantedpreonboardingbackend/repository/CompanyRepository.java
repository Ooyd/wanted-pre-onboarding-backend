package Ooyd.wantedpreonboardingbackend.repository;

import Ooyd.wantedpreonboardingbackend.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
