package Ooyd.wantedpreonboardingbackend.repository;

import Ooyd.wantedpreonboardingbackend.domain.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {

  //특정 회사 공고 조회
  @Query("SELECT r FROM RecruitmentNotice r WHERE r.company.id = :companyId")
  List<RecruitmentNotice> findByCompanyId(@Param("companyId") Long companyId);

  //내용,기술,포지션중 특정 키워드 조회
  @Query("SELECT r FROM RecruitmentNotice r WHERE " +
          "r.description LIKE %:keyword% OR " +
          "r.position LIKE %:keyword% OR " +
          "r.skill LIKE %:keyword%")
  List<RecruitmentNotice> findByKeyword(@Param("keyword") String keyword);

  // 회사별 다른 채용공고 ID 목록
  @Query("SELECT r.id FROM RecruitmentNotice r WHERE r.company.id = :companyId")
  List<Long> findOtherRecruitmentsByCompanyId(@Param("companyId") Long companyId);
}