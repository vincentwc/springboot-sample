package com.vincent.vo;

import lombok.Data;

import java.util.List;

@Data
public class UpdateVo {

    private Integer id;

    private List<LikeReqVo> vos;
}
