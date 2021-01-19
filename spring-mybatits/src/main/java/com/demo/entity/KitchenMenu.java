package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 厨房菜谱关联表
 * 
 * @author 
 * @email xxx@gtland.cn
 * @date 2020-08-03 10:57:32
 */
@Data
@TableName("kanisa_kitchen_menu")
public class KitchenMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 厨房id
	 */
	private Long kitchenId;
	/**
	 * 商家id
	 */
	private String merchantId;
	/**
	 * 菜谱id
	 */
	private Long menuId;
	/**
	 * 状态(0:启用,1:禁用)
	 */
	private Integer status;

}
