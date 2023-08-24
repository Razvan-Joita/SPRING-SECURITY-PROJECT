package org.nexttech.dtos;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponseDTOFind {
    private Integer id;
    private Long cnp;
    private String firstName;
    private String lastName;
    private LocalDate createdAt;
    private LocalDate updateAt;
}