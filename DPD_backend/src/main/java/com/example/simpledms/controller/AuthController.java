package com.example.simpledms.controller;

import com.example.simpledms.dto.request.LoginRequest;
import com.example.simpledms.dto.request.SignupRequest;
import com.example.simpledms.dto.response.JwtResponse;
import com.example.simpledms.dto.response.MessageResponse;
import com.example.simpledms.model.ERole;
import com.example.simpledms.model.Role;
import com.example.simpledms.model.User;
import com.example.simpledms.repository.RoleRepository;
import com.example.simpledms.repository.UserRepository;
import com.example.simpledms.security.jwt.JwtUtils;
import com.example.simpledms.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager; // 인증/권한체크 처리를 위한 객체

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

//  로그인 함수 : GET 방식 아닌 POST 방식으로 객체를 body 에 숨겨서 전송됨
//  @Valid 로 서버 유효성 체크
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

//    인증 시작
    Authentication authentication = authenticationManager.authenticate(
            // 아이디와 패스워드로, Security 가 알아 볼 수 있는 token 객체로 생성해서 인증처리
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

//    인증된 객체를 홀더에 저장
    SecurityContextHolder.getContext().setAuthentication(authentication);
//    JWT 토큰 발행
    String jwt = jwtUtils.generateJwtToken(authentication);

//    인증된 유저 정보를 userDetails 에 저장
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//    권한이 배열로 관리됨 : USER_ROLE, ADMIN_ROLE
//    권한 가져와서 roles 에 저장
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

//    클라이언트에 인증된 사용자 정보 전송(토큰 + 사용자 정보)
    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(),
                         userDetails.getAddress(),
                         userDetails.getNick(),
                         roles));
  }

//  새 사용자 등록 함수
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//    사용자가 DB 에 있는 지 확인
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

//    이메일이 DB 에 있는 지 확인
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()),
            signUpRequest.getAddress(),
            signUpRequest.getNick());

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("회원가입이 완료되었습니다!"));
  }
}
