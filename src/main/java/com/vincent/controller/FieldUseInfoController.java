package com.vincent.controller;


import com.vincent.entity.FieldUseInfo;
import com.vincent.service.IFieldUseInfoService;
import com.vincent.vo.DelVo;
import com.vincent.vo.FieldInfoVo;
import com.vincent.vo.LikeReqVo;
import com.vincent.vo.UpdateVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@RestController
@RequestMapping("/field-use-info")
public class FieldUseInfoController {

    @Resource
    private IFieldUseInfoService useInfoService;

    /**
     * 創建
     * @param useInfo
     * @return
     */
    @PostMapping("/create")
    public Boolean create(@RequestBody FieldUseInfo useInfo) {
        return useInfoService.create(useInfo);
    }

    /**
     * and条件查询
     * @param fieldIds
     * @return
     */
    @GetMapping("/get-and")
    public List<FieldUseInfo> getAnd(@RequestParam List<Integer> fieldIds) {
        return useInfoService.getAnd(fieldIds);
    }

    /**
     * or条件查询
     * @param fieldIds
     * @return
     */
    @GetMapping("/get-or")
    public List<FieldUseInfo> getOr(@RequestParam List<Integer> fieldIds) {
        return useInfoService.getOr(fieldIds);
    }

    /**
     * 多字段排序
     * @param fieldId
     * @return
     */
    @GetMapping("/get-order")
    public List<FieldUseInfo> getOrder(@RequestParam Integer fieldId) {
        return useInfoService.getOrder(fieldId);
    }

    /**
     * 模糊查询
     * @param reqVos
     * @return
     */
    @PostMapping("/get-like")
    public List<FieldUseInfo> getLike(@RequestBody List<LikeReqVo> reqVos) {
        return useInfoService.getLike(reqVos);
    }



    /**
     * 更新扩展信息--支持多字段
     * @param updateVo
     * @return
     */
    @PostMapping("/update")
    public Boolean update(@RequestBody UpdateVo updateVo) {
        return useInfoService.update(updateVo);
    }

    /**
     * 删除扩展信息
     * @param delVo
     * @return
     */
    @PostMapping("/del")
    public Boolean del(@RequestBody DelVo delVo) {
        return useInfoService.del(delVo);
    }
}
