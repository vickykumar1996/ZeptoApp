package com.zepto.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private String msg;
    private Date date;
    private String url;
}
