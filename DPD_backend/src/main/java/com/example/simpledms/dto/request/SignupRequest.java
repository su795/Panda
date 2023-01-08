package com.example.simpledms.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@ToString
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  private String address;

  private String nick;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  private boolean changePwd; // 패스워드 변경시 사용할 속성
}
