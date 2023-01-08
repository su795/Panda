package com.example.simpledms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(
        name = "SQ_USER_GENERATOR"
        , sequenceName = "SQ_USER"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_USER",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE
          , generator = "SQ_USER_GENERATOR"
  )
  private Long id;

  //  로그인 ID 임
//  @NotBlank
  @Size(max = 20)
  private String username;

  public User(Long id, String username, String email, String password, String address, String nick) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.address = address;
    this.nick = nick;
  }

  //  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  //  @NotBlank
  @Size(max = 120)
  private String password;

  private String address;

  private String nick;

  @Column(columnDefinition = "VARCHAR2(30)")
  private String mobileNumber;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "TB_USER_ROLE",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(String username, String email, String password, String address, String nick) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.address = address;
    this.nick = nick;
  }

  @Builder
  public User(String username, String email, String password, String address, String nick, Set<Role> roles) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.address = address;
    this.nick = nick;
    this.roles = roles;
  }

  public User update(String name) {
    this.username = username;

    return this;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }
}
