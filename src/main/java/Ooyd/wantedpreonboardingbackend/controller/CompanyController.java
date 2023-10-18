package Ooyd.wantedpreonboardingbackend.controller;

import Ooyd.wantedpreonboardingbackend.domain.Company;
import Ooyd.wantedpreonboardingbackend.dto.CompanyDTO;
import Ooyd.wantedpreonboardingbackend.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {
  private final CompanyService companyService;
  private final ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<String> save(@RequestBody CompanyDTO companyDTO) {
    try {
      Company company = modelMapper.map(companyDTO, Company.class);
      companyService.save(company);
      return ResponseEntity.ok("'"+companyDTO.getName() + "' 명으로 가입이 완료 되었습니다.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예상치 못한 오류가 발생했습니다.\n 잠시 후 시도해주세요.");
    }
  }
}
