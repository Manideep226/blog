package com.manideep.blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExpertsDto {
    private Integer userId;
    private List<Integer> techId;
}
