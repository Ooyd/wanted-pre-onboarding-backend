package Ooyd.wantedpreonboardingbackend.controller;

import Ooyd.wantedpreonboardingbackend.domain.RecruitmentNotice;
import Ooyd.wantedpreonboardingbackend.dto.RecruitmentNoticeDTO;
import Ooyd.wantedpreonboardingbackend.service.RecruitmentNoticeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruitment-notice")
public class RecruitmentNoticeController {

  private final RecruitmentNoticeService recruitmentNoticeService;

  private final ModelMapper modelMapper;


  // 채용 공고 등록
  @PostMapping
  public ResponseEntity<RecruitmentNoticeDTO> createRecruitmentNotice(@RequestBody RecruitmentNoticeDTO recruitmentNoticeDTO) {
    RecruitmentNotice recruitmentNotice = modelMapper.map(recruitmentNoticeDTO, RecruitmentNotice.class);
    recruitmentNoticeService.save(recruitmentNotice);
    return ResponseEntity.status(HttpStatus.CREATED).body(recruitmentNoticeDTO);
  }

  // 채용 공고 수정
  @PutMapping("/{id}")
  public ResponseEntity<RecruitmentNoticeDTO> updateRecruitmentNotice(@PathVariable Long id, @RequestBody RecruitmentNoticeDTO updatedRecruitmentNoticeDTO) {
    RecruitmentNotice updatedRecruitmentNotice = modelMapper.map(updatedRecruitmentNoticeDTO, RecruitmentNotice.class);
    recruitmentNoticeService.update(id, updatedRecruitmentNotice);
    return ResponseEntity.ok(updatedRecruitmentNoticeDTO);
  }

  // 채용 공고 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteRecruitmentNotice(@PathVariable Long id) {
    recruitmentNoticeService.delete(id);
    return ResponseEntity.ok("삭제가 완료되었습니다.");
  }

  // 채용 공고 목록 조회
  @GetMapping
  public ResponseEntity<List<RecruitmentNoticeDTO>> getAllRecruitmentNotices() {
    List<RecruitmentNotice> recruitmentNotices = recruitmentNoticeService.findAll();

    List<RecruitmentNoticeDTO> recruitmentNoticeDTOs = recruitmentNotices.stream()
            .map(entity -> modelMapper.map(entity, RecruitmentNoticeDTO.class))
            .collect(Collectors.toList());

    return ResponseEntity.ok(recruitmentNoticeDTOs);
  }

  // 채용 공고 상세 조회
  @GetMapping("/{id}")
  public ResponseEntity<RecruitmentNoticeDTO> getRecruitmentNotice(@PathVariable Long id) {
    RecruitmentNotice recruitmentNotice = recruitmentNoticeService.findById(id);
    RecruitmentNoticeDTO recruitmentNoticeDTO = modelMapper.map(recruitmentNotice, RecruitmentNoticeDTO.class);
    return ResponseEntity.ok(recruitmentNoticeDTO);
  }

  // 채용 공고 검색
  @GetMapping("/search")
  public ResponseEntity<List<RecruitmentNoticeDTO>> searchRecruitmentNotices(@RequestParam String keyword) {
    List<RecruitmentNotice> recruitmentNotices = recruitmentNoticeService.search(keyword);
    List<RecruitmentNoticeDTO> recruitmentNoticeDTOs = recruitmentNotices.stream()
            .map(entity -> modelMapper.map(entity, RecruitmentNoticeDTO.class))
            .collect(Collectors.toList());

    return ResponseEntity.ok(recruitmentNoticeDTOs);
  }
}
