package Ooyd.wantedpreonboardingbackend.service;

import Ooyd.wantedpreonboardingbackend.domain.Application;
import Ooyd.wantedpreonboardingbackend.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationService {
  private final ApplicationRepository applicationRepository;

  public void save(Application application) {
    applicationRepository.save(application);
  }
}
