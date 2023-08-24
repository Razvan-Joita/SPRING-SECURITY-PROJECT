package org.nexttech.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> role;

}
