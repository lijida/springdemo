package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 品牌管理表
 * 
 * @author Jinpeng.Bu
 * @email bujinpeng@utopa.com.cn
 * @date 2020-09-04 10:53:58
 */
@Data
@TableName("kanisa_brand")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 品牌名称
	 */
	@NotBlank(message = "品牌名称不能为空")
	@Length(max = 30 ,message = "品牌名称长度不能超过30")
	private String brandName;
	/**
	 * 商标申请/注册号
	 */
	@NotBlank(message = "商标申请/注册号不能为空")
	@Length(max = 16 ,message = "商标申请/注册号长度不能超过16")
	private String brandRegiste;
	/**
	 * 商标国际分类
	 */
	@NotNull(message = "商标国际分类不能为空")
	@Max(value = 99 ,message = "商标国际分类长度不能超过16")
	private Integer brandClass;
	/**
	 * 商标logo图片key
	 */
//	@NotBlank(message = "商标logo不能为空", groups = {Add.class, Update.class})
	private String brandLogo;
	@TableField(exist = false)
	private String brandLogoUrl;
	/**
	 * 品牌状态,0禁用/1启用
	 */
	private Integer brandStatus;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最近修改人
	 */
	private String updator;
	/**
	 * 最近修改时间
	 */
	private Date updateTime;

}
