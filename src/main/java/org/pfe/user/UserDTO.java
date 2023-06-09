package org.pfe.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int cin;
    private int phone;
    private Role role;

    public UserDTO() {
        super();
    }

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
