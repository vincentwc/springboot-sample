package com.vincent.vo;

import lombok.Data;

import java.util.List;

@Data
public class FieldInfoVo {

    private Integer fieldId;

    private List<FieldInfoVo> vos;
}
