package Ooyd.wantedpreonboardingbackend.service;

import Ooyd.wantedpreonboardingbackend.domain.User;
import Ooyd.wantedpreonboardingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  public void save(User user) {
    repository.save(user);
  }
}
