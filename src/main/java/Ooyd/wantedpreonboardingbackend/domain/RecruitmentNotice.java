package Ooyd.wantedpreonboardingbackend.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "recruitment_notice")

public class RecruitmentNotice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 채용 공고의 고유 ID

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "company_id", nullable = false)
  private Company company; // 이 채용 공고를 게시한 회사

  @Column
  private String title; // 채용 제목

  @Column
  private String country; // 회사 국가

  @Column
  private String region; // 회사 지역

  @Column
  private String position; // 채용 포지션

  @Column
  private Integer salary; // 제안된 연봉

  @Column
  private String skill; // 필요 기술

  @Column(length = 1000)
  private String description; // 채용 공고 설명

  public void update(RecruitmentNotice updatedRecruitmentNotice) {
    this.title = updatedRecruitmentNotice.getTitle();
    this.country = updatedRecruitmentNotice.getCountry();
    this.region = updatedRecruitmentNotice.getRegion();
    this.position = updatedRecruitmentNotice.getPosition();
    this.salary = updatedRecruitmentNotice.getSalary();
    this.skill = updatedRecruitmentNotice.getSkill();
    this.description = updatedRecruitmentNotice.getDescription();
  }
}
