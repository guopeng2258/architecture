package com.perry.archmybatis.model;

import java.io.Serializable;

/**
 * 存储产品参数信息的表
 */
public class PmsProductAttributeValue implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 商品ID
     */
    private Long productId;
    
    /**
     * 商品属性ID
     */
    private Long productAttributeId;
    
    /**
     * 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
     */
    private String value;
    
    // 无参构造函数
    public PmsProductAttributeValue() {
    }
    
    // 全参构造函数
    public PmsProductAttributeValue(Long id, Long productId, Long productAttributeId, String value) {
        this.id = id;
        this.productId = productId;
        this.productAttributeId = productAttributeId;
        this.value = value;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public Long getProductAttributeId() {
        return productAttributeId;
    }
    
    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "PmsProductAttributeValue{" +
               "id=" + id +
               ", productId=" + productId +
               ", productAttributeId=" + productAttributeId +
               ", value='" + value + '\'' +
               '}';
    }
}