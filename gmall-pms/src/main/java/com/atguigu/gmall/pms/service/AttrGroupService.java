package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.ItemGroupVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author hehao
 * @email hehao@hehao.com
 * @date 2021-01-18 18:30:53
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    List<AttrGroupEntity> queryWithAttrsByCid(long cid);

    List<ItemGroupVo> queryAttrGroupValueByCidAndSpuIdAndSkuId(Long categoryId, Long spuId, Long skuId);
}

