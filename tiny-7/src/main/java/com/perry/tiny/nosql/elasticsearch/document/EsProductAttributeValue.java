package com.perry.tiny.nosql.elasticsearch.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author perry
 * @description
 * @date 2025/8/6 13:03
 */
@Data
@EqualsAndHashCode
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long productAttributeId;
    // 属性值
    @Field(type = FieldType.Keyword)
    private String value;
    // 属性参数：0->规格；1->参数
    private String type;
    // 属性名称
    @Field(type = FieldType.Keyword)
    private String name;


}
