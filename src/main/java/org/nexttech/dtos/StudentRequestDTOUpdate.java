package org.nexttech.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRequestDTOUpdate {
    private Integer id;
    @NotNull(message = "CNP cannot be null")
    @Digits(integer = 13, fraction = 0, message = "Invalid CNP format")
    private Long cnp;
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "First name cannot be blank")
    private String lastName;
}