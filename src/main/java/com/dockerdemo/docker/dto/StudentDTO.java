package com.dockerdemo.docker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 10:27
 */
@Setter
@Getter
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    private Integer roll;
    private String name;
    private String address;
    private String appointedDate;
}
