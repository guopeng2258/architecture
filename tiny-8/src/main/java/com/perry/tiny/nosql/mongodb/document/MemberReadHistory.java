package com.perry.tiny.nosql.mongodb.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author perry
 * @description 用户商品浏览记录
 * @date 2025/8/7 18:02
 */
@Data
@EqualsAndHashCode
@Document
public class MemberReadHistory {
    @Id
    private String id; // 主键ID
    @Indexed
    private Long memberId; // 用户ID
    private String memberNickname; // 用户昵称
    private String memberIcon; // 用户头像
    @Indexed
    private Long productId; // 商品ID
    private String productName; // 商品名称
    private String productSubTitle; // 商品副标题
    private String productPrice; // 商品价格
    private String productPic; // 商品图片
    private Date createTime; // 创建时间
}
