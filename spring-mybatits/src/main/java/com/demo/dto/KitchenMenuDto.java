package com.demo.dto;


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
public class KitchenMenuDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
		//@NotBlank(message = id+"不能为空", groups = Add.class)
	private Long id;
	/**
	 * 厨房id
	 */
	//@NotBlank(message = kitchenId+"不能为空", groups = Add.class)
	private Long kitchenId;
	/**
	 * 商家id
	 */
	//@NotBlank(message = merchantId+"不能为空", groups = Add.class)
	private String merchantId;
	/**
	 * 菜谱id
	 */
	//@NotBlank(message = menuId+"不能为空", groups = Add.class)
	private Long menuId;
	/**
	 * 状态(0:启用,1:禁用)
	 */
	//@NotBlank(message = status+"不能为空", groups = Add.class)
	private Integer status;
	/**
	 * 菜谱名称
	 */
	private String menuName;
	/**
	 * 商家名称
	 */
	private String merchantName;
	/**
	 * 菜谱状态
	 */
	private Integer lockState;
	}
