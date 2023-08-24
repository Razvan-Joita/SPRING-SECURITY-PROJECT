package org.nexttech.payload.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
