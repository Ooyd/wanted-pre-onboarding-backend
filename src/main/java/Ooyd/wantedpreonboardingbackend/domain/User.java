package Ooyd.wantedpreonboardingbackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter @Setter
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 사용자의 고유 ID


  @Column(unique = true)
  private String username; // 사용자 이름

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Application> applications = new ArrayList<>(); // 사용자가 제출한 지원서 리스트


  public void addApplication(Application application) {
    applications.add(application);
    application.setUser(this);
  }

  public void removeApplication(Application application) {
    applications.remove(application);
    application.setUser(null);
  }
}
