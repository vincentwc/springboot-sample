package com.vincent.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.google.gson.Gson;
import com.vincent.entity.DemoField;
import com.vincent.entity.FieldUseInfo;
import com.vincent.mapper.FieldUseInfoMapper;
import com.vincent.service.IDemoFieldService;
import com.vincent.service.IFieldUseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.vo.DelVo;
import com.vincent.vo.LikeReqVo;
import com.vincent.vo.UpdateVo;
import com.vincent.vo.UseInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author vincent
 */
@Service
public class FieldUseInfoServiceImpl extends ServiceImpl<FieldUseInfoMapper, FieldUseInfo> implements IFieldUseInfoService {

    @Resource
    private IDemoFieldService demoFieldService;

    @Override
    public Boolean create(FieldUseInfo useInfo) {
        List<UseInfo> vos = useInfo.getVos();
        Map<Integer, String> useInfoMap = new HashMap<>();
        vos.forEach(vo -> useInfoMap.put(vo.getId(), vo.getValue()));
        String json = new Gson()
                .toJson(useInfoMap);
        useInfo.setExtraInfo(json);
        return save(useInfo);
    }

    @Override
    public List<FieldUseInfo> getAnd(List<Integer> fieldIds) {
        // 获取字段信息
        List<DemoField> demoFields = demoFieldService.listByIds(fieldIds);
        // 获取字段使用信息
        LambdaQueryChainWrapper<FieldUseInfo> chainWrapper = new LambdaQueryChainWrapper<>(baseMapper);
        chainWrapper.notIn(FieldUseInfo::getId, 10);
        if (!CollectionUtils.isEmpty(fieldIds)) {
            chainWrapper.and(wrapper -> {
                String value;
                for (Integer fieldId : fieldIds) {
                    if (fieldId.equals(2)) {
                        value = "222";
                    } else if (fieldId.equals(3)) {
                        value = "333";
                    } else {
                        value = "";
                    }
                    // and条件查询
                    wrapper.apply(!StringUtils.isEmpty(fieldId), "JSON_CONTAINS(extra_info,JSON_OBJECT('" + fieldId + "',{0}))", value);
                }
            });
        }
        return chainWrapper.list();
    }

    @Override
    public List<FieldUseInfo> getOr(List<Integer> fieldIds) {
        // 获取字段信息
        List<DemoField> demoFields = demoFieldService.listByIds(fieldIds);
        // 获取字段使用信息
        LambdaQueryChainWrapper<FieldUseInfo> chainWrapper = new LambdaQueryChainWrapper<>(baseMapper);
        if (!CollectionUtils.isEmpty(fieldIds)) {
            chainWrapper.and(wrapper -> {
                String value;
                for (Integer fieldId : fieldIds) {
                    if (fieldId.equals(2)) {
                        value = "222";
                    } else if (fieldId.equals(3)) {
                        value = "333";
                    } else {
                        value = "";
                    }
                    // and条件查询
                    wrapper.or().apply(!StringUtils.isEmpty(fieldId), "JSON_CONTAINS(extra_info,JSON_OBJECT('" + fieldId + "',{0}))", value);
                }
            });
        }
        chainWrapper.notIn(FieldUseInfo::getId, 10);
        return chainWrapper.list();
    }

    @Override
    public List<FieldUseInfo> getOrder(Integer fieldId) {
        // 获取字段信息
        DemoField demoField = demoFieldService.getById(fieldId);
        // 获取字段使用信息
        LambdaQueryChainWrapper<FieldUseInfo> chainWrapper = new LambdaQueryChainWrapper<>(baseMapper);
        chainWrapper.notIn(FieldUseInfo::getId, 10);
//        chainWrapper.last(!StringUtils.isEmpty(fieldId), "ORDER BY extra_info->'$.\""+fieldId+"\"' desc");
        List<Integer> fieldIds = new ArrayList<>();
        fieldIds.add(2);
        fieldIds.add(3);
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < fieldIds.size(); i++) {
            if (0 == i) {
                sBuffer.append("ORDER BY extra_info->'$.\"" + fieldIds.get(i) + "\"'").append("desc");
            }
            sBuffer.append(",").append("extra_info->'$.\"" + fieldIds.get(i) + "\"'").append("asc");
        }
        chainWrapper.last(sBuffer.toString());
        return chainWrapper.list();
    }

    @Override
    public List<FieldUseInfo> getLike(List<LikeReqVo> reqVos) {
        Set<Integer> ids = reqVos.stream().map(vo -> vo.getId()).collect(Collectors.toSet());
        LambdaQueryChainWrapper<FieldUseInfo> chainWrapper = new LambdaQueryChainWrapper<>(baseMapper);

        chainWrapper.in(FieldUseInfo::getId, ids);
        if (CollUtil.isNotEmpty(reqVos)) {
            chainWrapper.and(wrapper -> {
                String value;
                for (LikeReqVo vo : reqVos) {
                    // and条件查询
                    wrapper.apply(ObjectUtil.isNotNull(vo), "extra_info ->> '$.\"" + vo.getId() + "\"' LIKE CONCAT('%',{0},'%')", vo.getValue());
                }
            });
        }
        return chainWrapper.list();
    }

    @Override
    public Boolean update(UpdateVo updateVo) {
        Integer id = updateVo.getId();
        List<LikeReqVo> vos = updateVo.getVos();
        if (CollUtil.isEmpty(vos)) {
            return true;
        }
        LambdaUpdateChainWrapper<FieldUseInfo> chainWrapper = new LambdaUpdateChainWrapper<>(baseMapper);
        chainWrapper.eq(FieldUseInfo::getId, id);
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("extra_info = (JSON_SET(extra_info");
        vos.forEach(vo ->
                sBuffer
                        .append(", '$.\"")
                        .append(vo.getId())
                        .append("\"'")
                        .append(",")
                        .append("'")
                        .append(vo.getValue())
                        .append("'")
        );
//        for (int i = 0; i < vos.size(); i++) {
//            LikeReqVo vo = vos.get(i);
//            Integer jsonId = vo.getId();
//            String jsonValue = vo.getValue();
//            if (0 == i) {
//                sBuffer.append(", '$.\"" + jsonId + "\"', '" + jsonValue + "'");
//            }
//            sBuffer.append(",").append("'$.\"" + jsonId + "\"'").append(",").append("'" + jsonValue + "'");
//        }
        sBuffer.append("))");
        String sqlStr = sBuffer.toString();
        chainWrapper.setSql(sqlStr);
        return chainWrapper.update();
    }

    @Override
    public Boolean del(DelVo delVo) {
        Integer id = delVo.getId();
        List<Integer> jsonIds = delVo.getJsonIds();
        if (CollUtil.isEmpty(jsonIds)) {
            return true;
        }
        LambdaUpdateChainWrapper<FieldUseInfo> chainWrapper = new LambdaUpdateChainWrapper<>(baseMapper);
        chainWrapper.eq(FieldUseInfo::getId, id);
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("extra_info = (json_remove(extra_info");
        jsonIds.forEach(jsonId ->
                sBuffer
                        .append(", '$.\"")
                        .append(jsonId)
                        .append("\"'"));
        sBuffer.append("))");
        String sqlStr = sBuffer.toString();
        chainWrapper.setSql(sqlStr);
        return chainWrapper.update();
    }
}
