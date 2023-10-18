package Ooyd.wantedpreonboardingbackend.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
@Table(name = "company", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 회사의 고유 ID


  @Column(unique = true)
  private String name; // 회사 이름

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RecruitmentNotice> recruitmentNotices = new ArrayList<>(); // 이 회사에 의해 게시된 채용 공고 리스트


  public void addRecruitmentNotice(RecruitmentNotice recruitmentNotice) {
    recruitmentNotices.add(recruitmentNotice);
    recruitmentNotice.setCompany(this);
  }

  public void removeRecruitmentNotice(RecruitmentNotice recruitmentNotice) {
    recruitmentNotices.remove(recruitmentNotice);
    recruitmentNotice.setCompany(null);
  }
}
