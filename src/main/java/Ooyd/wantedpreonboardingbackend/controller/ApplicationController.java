package Ooyd.wantedpreonboardingbackend.controller;

import Ooyd.wantedpreonboardingbackend.domain.Application;
import Ooyd.wantedpreonboardingbackend.domain.RecruitmentNotice;
import Ooyd.wantedpreonboardingbackend.domain.User;
import Ooyd.wantedpreonboardingbackend.dto.ApplicationDTO;
import Ooyd.wantedpreonboardingbackend.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("application")
public class ApplicationController {
  private final ApplicationService applicationService;
  private final ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<String> applyRecruitment(@RequestBody ApplicationDTO applicationDTO) {
    try {
      Application application = convertToEntity(applicationDTO);
      applicationService.save(application);
      return ResponseEntity.ok("정상적으로 저장되었습니다.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예상치 못한 오류가 발생했습니다.\n 잠시 후 시도해주세요.");
    }
  }

  private Application convertToEntity(ApplicationDTO applicationDTO) {
    Application application = modelMapper.map(applicationDTO, Application.class);

    User user = new User();
    user.setId(applicationDTO.getUserId()); // userId를 User 엔터티에 설정

    RecruitmentNotice recruitmentNotice = new RecruitmentNotice();
    recruitmentNotice.setId(applicationDTO.getRecruitmentNotice()); // 여기서는 ID만 설정하고 있습니다.

    application.setUser(user); // User 엔터티를 Application에 설정
    application.setRecruitmentNotice(recruitmentNotice);  // 생성된 RecruitmentNotice를 Application에 설정


    return application;
  }

}
