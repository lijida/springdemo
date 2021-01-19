package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 中央厨房表
 * 
 * @author 
 * @email xxx@gtland.cn
 * @date 2020-08-03 10:57:32
 */
@Data
@TableName("kanisa_central_kitchen")
public class CentralKitchen implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 所在省份
	 */
	private String province;
	/**
	 * 所在城市
	 */
	private String city;
	/**
	 * 所在区县
	 */
	private String district;
	/**
	 * 联系人
	 */
	private String contactPerson;
	/**
	 * 联系人电话
	 */
	private String contactNumber;
	/**
	 * 状态(0:启用,1:禁用)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
	private Date createTime;
	/**
	 * 创建者
	 */
	private String creator;

}
