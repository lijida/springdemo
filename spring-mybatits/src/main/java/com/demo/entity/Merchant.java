package com.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 商家表
 * 
 * @author 
 * @email xxx@gtland.cn
 * @date 2020-04-08 19:23:45
 */
@Data
@TableName("kanisa_merchant")
public class Merchant implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * UUID
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 注册时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;
	/**
	 * 商户名称
	 */
	//@NotBlank(message = "商户名称不能为空", groups = {Add.class, Update.class})
	//@Length(max = 32 ,message = "商户名称长度不能超过32", groups = {Add.class,Update.class})
	private String name;
	/**
	 * 自营 0.否 1.是
	 */
	//@NotNull(message = "自营信息不能为空", groups = {Add.class, Update.class})
	private Integer isSop;
	/**
	 * 商家编号
	 */
	private String code;
	/**
	 * 商家所在省份
	 */
	//@NotBlank(message = "商家所在省份不能为空", groups = {Add.class, Update.class})
	private String province;
	/**
	 * 商家所在城市
	 */
	/**@NotBlank(message = "商家所在城市不能为空", groups = {Add.class, Update.class})*/
	private String city;
	/**
	 * 商家所在区县
	 */
	/**@NotBlank(message = "商家所在区县不能为空", groups = {Add.class, Update.class})*/
	private String district;
	/**
	 * 商家所在区域编码
	 */
	/**@NotBlank(message = "商家所在区域编码不能为空", groups = {Add.class, Update.class})*/
	private String districtCode;
	/**
	 * 商家详细地址
	 */
	//@NotBlank(message = "商家详细地址不能为空", groups = {Add.class, Update.class})
	//@Length(max = 40 ,message = "商家详细地址长度不能超过40", groups = {Add.class,Update.class})
	private String address;
	/**
	 * 商家联系人
	 */
	//@NotBlank(message = "商家联系人不能为空", groups = {Add.class, Update.class})
	//@Length(max = 40 ,message = "商家联系人长度不能超过40", groups = {Add.class,Update.class})
	private String contactPerson;
	/**
	 * 商家联系电话
	 */
	//@NotBlank(message = "商家联系电话不能为空", groups = {Add.class, Update.class})
	private String contactNumber;
	/**
	 * 商家备注
	 */
	//@Length(max = 100 ,message = "商家备注长度不能超过100", groups = {Add.class,Update.class})
	private String remark;
	/**
	 * 商家状态，0冻结、1解冻
	 */
	private Integer state;
	/**
	 * 是否删除 0.可用 1.删除/禁用
	 */
	@TableLogic(value = "0",delval = "1")
	private Integer isDel;

	/**
	 * 商户Logo
	 */
	private String logo;
	@TableField(exist = false)
	private String logoUrl;
	@TableField(exist = false)
	private Long brandId;

}
