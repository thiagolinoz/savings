package com.linoz.savings.dto;

import lombok.Data;

/**
 * Created by linoz on 4/7/21
 */
@Data
public class UserPutDTO {
    private long id;
    private String name;
    private String email;
    private Long cellphone;
}
