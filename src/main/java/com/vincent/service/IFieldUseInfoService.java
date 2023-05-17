package com.vincent.service;

import com.vincent.entity.FieldUseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.vo.DelVo;
import com.vincent.vo.LikeReqVo;
import com.vincent.vo.UpdateVo;

import java.util.List;

/**
 * @author vincent
 */
public interface IFieldUseInfoService extends IService<FieldUseInfo> {

    Boolean create(FieldUseInfo useInfo);

    List<FieldUseInfo> getAnd(List<Integer> fieldIds);

    List<FieldUseInfo> getOr(List<Integer> fieldIds);

    List<FieldUseInfo> getOrder(Integer fieldId);

    List<FieldUseInfo> getLike(List<LikeReqVo> reqVos);

    Boolean update(UpdateVo updateVo);

    Boolean del(DelVo delVo);
}
