package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.SpuVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SpuEntity;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * spu信息
 *
 * @author hehao
 * @email hehao@hehao.com
 * @date 2021-01-18 18:30:53
 */
public interface SpuService extends IService<SpuEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    PageResultVo querySpuPageByKey(Long cid, PageParamVo paramVo);

    void bigSave(SpuVo spuVo) ;

    SpuEntity querySpuBySkuId(Long skuId);
}

