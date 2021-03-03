package com.atguigu.gmall.pms.controller;

import java.util.List;

import com.atguigu.gmall.pms.vo.ItemGroupVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.common.bean.PageParamVo;

/**
 * 属性分组
 *
 * @author hehao
 * @email hehao@hehao.com
 * @date 2021-01-18 18:30:53
 */
@Api(tags = "属性分组 管理")
@RestController
@RequestMapping("pms/attrgroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @GetMapping("withattrs/{catId}")
    @ApiOperation("参数规格分组及属性查询")
    public ResponseVo<List<AttrGroupEntity>> queryWithAttrsByCid(@PathVariable("catId") long cid) {
        List<AttrGroupEntity> attrGroupEntities = attrGroupService.queryWithAttrsByCid(cid);
        return ResponseVo.ok(attrGroupEntities);
    }


    @GetMapping("category/{cid}")
    @ApiOperation("参数规格分组查询")
    public ResponseVo<List<AttrGroupEntity>> queryAttrGroupByCid(@PathVariable("cid") Long cid) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", cid);
        List<AttrGroupEntity> groupEntities = attrGroupService.list(wrapper);
        return ResponseVo.ok(groupEntities);
    }

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseVo<PageResultVo> queryAttrGroupByPage(PageParamVo paramVo) {
        PageResultVo pageResultVo = attrGroupService.queryPage(paramVo);

        return ResponseVo.ok(pageResultVo);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseVo<AttrGroupEntity> queryAttrGroupById(@PathVariable("id") Long id) {
        AttrGroupEntity attrGroup = attrGroupService.getById(id);

        return ResponseVo.ok(attrGroup);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseVo<Object> save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return ResponseVo.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseVo update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseVo delete(@RequestBody List<Long> ids) {
        attrGroupService.removeByIds(ids);

        return ResponseVo.ok();
    }

    /**
     * 根据categoryId获取分组信息，再根据spuId和skuId获取对应的规格参数和值
     */
    @GetMapping("spu/sku/{categoryId}")
    @ApiOperation("详情查询")
    public ResponseVo<List<ItemGroupVo>> queryAttrGroupValueByCidAndSpuIdAndSkuId(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam("spuId") Long spuId,
            @RequestParam("skuId") Long skuId){
        List<ItemGroupVo> groups = attrGroupService.queryAttrGroupValueByCidAndSpuIdAndSkuId(categoryId,spuId,skuId);
        return ResponseVo.ok(groups);
    }

}
