package com.manideep.blog.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BlogDTO {
    private String title;
    private String blogContent;
    private Integer technology;
    private Integer expert;
    private Integer createdBy;
}
