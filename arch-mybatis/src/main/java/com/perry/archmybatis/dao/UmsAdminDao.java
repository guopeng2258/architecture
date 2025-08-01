package com.perry.archmybatis.dao;

import com.perry.archmybatis.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户DAO接口
 */
@Repository
public interface UmsAdminDao {

    /**
     * 根据ID查询后台用户
     * @param id 用户ID
     * @return 后台用户信息
     */
    UmsAdmin selectById(@Param("id") Long id);

    /**
     * 根据ID列表查询后台用户
     * @param ids ID列表
     * @return 后台用户列表
     */
    List<UmsAdmin> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 插入后台用户
     * @param umsAdmin 后台用户信息
     * @return 插入记录数
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 批量插入后台用户
     * @param list 后台用户列表
     * @return 插入记录数
     */
    int insertBatch(@Param("list") List<UmsAdmin> list);

    /**
     * 更新后台用户信息
     * @param umsAdmin 后台用户信息
     * @return 更新记录数
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 更新后台用户信息
     * @param umsAdmin 后台用户信息
     * @return 更新记录数
     */
    int updateBySelective(UmsAdmin umsAdmin);

    /**
     * 根据ID删除后台用户
     * @param id 用户ID
     * @return 删除记录数
     */
    int deleteById(@Param("id") Long id);

    /**
     * 根据用户数名和Email模糊匹配 if标签
     * 不输入查询所有
     */
    List<UmsAdmin> selectByUsernameAndEmailLike(@Param("username") String username, @Param("email") String email);

    /**
     * 根据用户数名和Email模糊匹配 choose标签
     * 不输入不返回数据
     */
    List<UmsAdmin> selectByUsernameAndEmailLike2(@Param("username") String username, @Param("email") String email);

    /**
     * 根据用户数名和Email模糊匹配 where标签
     * 不输入查询所有
     */
    List<UmsAdmin> selectByUsernameAndEmailLike3(@Param("username") String username, @Param("email") String email);


    /**
     * 查询所有后台用户
     * @return 后台用户列表
     */
    List<UmsAdmin> selectAll();
    
    /**
     * 根据用户名查询后台用户
     * @param username 用户名
     * @return 后台用户信息
     */
    UmsAdmin selectByUsername(@Param("username") String username);
}