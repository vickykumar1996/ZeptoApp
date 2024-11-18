package com.zepto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    private long id;
    private String name;
    private String email;
    private String role;
    private String mobile;
}
