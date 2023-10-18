package Ooyd.wantedpreonboardingbackend.service;

import Ooyd.wantedpreonboardingbackend.domain.Company;
import Ooyd.wantedpreonboardingbackend.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
  private final CompanyRepository repository;

  public void save(Company company) {
    repository.save(company);
  }


}
