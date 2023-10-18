package Ooyd.wantedpreonboardingbackend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@Table(name = "application")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 지원서의 고유 ID

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user; // 지원한 사용자

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "recruitment_notice_id", nullable = false)
  private RecruitmentNotice recruitmentNotice; // 사용자가 지원한 채용 공고

}