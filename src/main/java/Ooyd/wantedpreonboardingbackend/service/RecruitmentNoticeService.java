package Ooyd.wantedpreonboardingbackend.service;

import Ooyd.wantedpreonboardingbackend.domain.Application;
import Ooyd.wantedpreonboardingbackend.domain.RecruitmentNotice;
import Ooyd.wantedpreonboardingbackend.domain.User;
import Ooyd.wantedpreonboardingbackend.repository.ApplicationRepository;
import Ooyd.wantedpreonboardingbackend.repository.RecruitmentNoticeRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecruitmentNoticeService {
  private final RecruitmentNoticeRepository recruitmentNoticeRepository;
  private final ApplicationRepository applicationRepository;

  // 채용 공고 저장
  public RecruitmentNotice save(RecruitmentNotice recruitmentNotice) {
    return recruitmentNoticeRepository.save(recruitmentNotice);
  }

  // 채용 공고 업데이트
  public RecruitmentNotice update(Long id, RecruitmentNotice updatedRecruitmentNotice) {
    RecruitmentNotice recruitmentNotice = recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid recruitment notice Id:" + id));
    recruitmentNotice.update(updatedRecruitmentNotice);
    return recruitmentNoticeRepository.save(recruitmentNotice); // 명시적으로 변경 사항을 저장
  }


  // 채용 공고 삭제
  public void delete(Long id) {
    recruitmentNoticeRepository.deleteById(id);
  }

  // 모든 채용 공고 조회
  @Transactional(readOnly = true)
  public List<RecruitmentNotice> findAll() {
    return recruitmentNoticeRepository.findAll();
  }


  // 채용 공고 상세 조회
  @Transactional(readOnly = true)
  public RecruitmentNotice findById(Long id) {
    return recruitmentNoticeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid recruitment notice Id:" + id));
  }

  // 채용 공고 검색
  @Transactional(readOnly = true)
  public List<RecruitmentNotice> search(String keyword) {
    return recruitmentNoticeRepository.findByKeyword(keyword);
  }

  // 채용 공고 지원
  public Application apply(Long recruitmentNoticeId, User user) {
    RecruitmentNotice recruitmentNotice = recruitmentNoticeRepository.findById(recruitmentNoticeId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid recruitment notice Id:" + recruitmentNoticeId));
    Application application = new Application();
    application.setUser(user);
    application.setRecruitmentNotice(recruitmentNotice);
    return applicationRepository.save(application);
  }
}