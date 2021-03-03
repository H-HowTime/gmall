package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.CouponSpuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author hehao
 * @email hehao@hehao.com
 * @date 2021-01-18 23:15:04
 */
@Mapper
public interface CouponSpuMapper extends BaseMapper<CouponSpuEntity> {
	
}
