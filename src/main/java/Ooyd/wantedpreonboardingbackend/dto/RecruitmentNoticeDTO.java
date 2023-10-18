package Ooyd.wantedpreonboardingbackend.dto;

import Ooyd.wantedpreonboardingbackend.domain.Company;
import lombok.*;


@Data
public class RecruitmentNoticeDTO {
  private long companyId;
  private String title;
  private String country;
  private String region;
  private String position;
  private Integer salary;
  private String skill;
  private String description;

}
