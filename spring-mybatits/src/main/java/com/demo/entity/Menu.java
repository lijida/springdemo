package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家菜谱
 * 
 * @author 
 * @email xxx@gtland.cn
 * @date 2020-04-08 19:23:45
 */
@Data
@TableName("kanisa_menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 商家id
	 */
	private String merchantId;
	/**
	 * 分类code，采用数据字典分类下，子分类code
	 */
	private String typeCode;
	/**
	 * 价格(单位/分)
	 */
	private Integer price;
	/**
	 * 卡路里总和
	 */
	private Integer calorie;
	/**
	 * 状态 0.编辑中 1.未审核 2.审核通过 3.审核不通过
	 */
	private Integer state;
	/**
	 * 重量，单位 克
	 */
	private Integer weight;
	/**
	 * 菜谱编号
	 */
	private String code;
	/**
	 * 冻结状态，0冻结、1解冻
	 */
	private Integer lockState;
	/**
	 * 机器审核状态，0未提交、1通过、2否决
	 */
	private Integer autoState;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 是否删除 0.可用 1.删除/禁用
	 */
	@TableLogic(value = "0",delval = "1")
	private Integer isDel;

	/**
	 * 版本信息
	 */
	private Integer version;

	/**
	 * 菜谱主料
	 */
	private String material;

	/**
	 * 菜谱辅料
	 */
	private String excipient;

	/**
	 * 保质期
	 */
	private Integer expiration;

	/**
	 * 菜谱规格
	 */
	private String standard;

	/**
	 * 菜谱口味
	 */
	private String taste;

	/**
	 * 菜谱制作方法
	 */
	private String method;

	/**
	 * 菜谱荤素属性
	 */
	private String hunsu;

	/**
	 * 分类id
	 */
	private Long sortId;

	/**
	 * 品牌id
	 */
	private Long brandId;
	/**
	 * 品牌名称
	 */
	private String brandName;

}
