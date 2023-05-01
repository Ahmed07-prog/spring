package org.pfe.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.pfe.constat.models.Constat;
import org.pfe.constat.models.ExpertValidation;
import org.pfe.token.Token;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false,unique = true)
  private String email;
  @Column(nullable = false,unique = true)
  private String username;
  @Column(nullable = false)
  private int cin;
  @Column(nullable = false)
  private int phone;
  @Column(nullable = false)
  @JsonProperty(access = WRITE_ONLY)
  private String password;
  @JsonProperty(access = WRITE_ONLY)
  private String resetPasswordToken;
  @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private List<Constat> constats;
  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JsonProperty(access = WRITE_ONLY)
  private List<Token> tokens;

  @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private List<ExpertValidation> expertValidations;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getEmail() {
    return username;
  }


}
