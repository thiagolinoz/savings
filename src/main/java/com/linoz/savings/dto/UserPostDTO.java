package com.linoz.savings.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * Created by linoz on 4/6/21
 */

@Data
public class UserPostDTO {
    private String name;
    @NotEmpty(message = "e-mail não pode ser nulo")
    private String email;
    private Long cellphone;
}
