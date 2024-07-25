package com.folder.app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private int no;
    private String name;
    private String email;
    private String pwd;
    private Boolean gender;
    private Boolean del;
    private LocalDateTime regDate;
}