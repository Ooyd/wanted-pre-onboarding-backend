package Ooyd.wantedpreonboardingbackend.config;

import Ooyd.wantedpreonboardingbackend.domain.RecruitmentNotice;
import Ooyd.wantedpreonboardingbackend.dto.RecruitmentNoticeDTO;
import Ooyd.wantedpreonboardingbackend.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

  @Autowired
  private CompanyRepository companyRepository;

  //Model Mapper
  //DTO <-> Entity Type Change
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.addMappings(new PropertyMap<RecruitmentNoticeDTO, RecruitmentNotice>() {
      @Override
      protected void configure() {
        using(ctx -> companyRepository.findById(((RecruitmentNoticeDTO) ctx.getSource()).getCompanyId())
                .orElse(null))
                .map(source, destination.getCompany());
      }
    });

    return modelMapper;

  }
}
