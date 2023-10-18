package Ooyd.wantedpreonboardingbackend.controller;

import Ooyd.wantedpreonboardingbackend.domain.User;
import Ooyd.wantedpreonboardingbackend.dto.UserDTO;
import Ooyd.wantedpreonboardingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
  private final UserService userService;
  private final ModelMapper modelMapper;


  @PostMapping
  public ResponseEntity<String> save(@RequestBody UserDTO userDTO){
    try {
      User userEntity = modelMapper.map(userDTO, User.class);
      userService.save(userEntity);
      return ResponseEntity.ok(userDTO.getUsername() + "님 가입을 환영합니다.");
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body("중복된 유저입니다.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예상치 못한 오류가 발생했습니다.\n 잠시 후 시도해주세요.");
    }
  }
}
