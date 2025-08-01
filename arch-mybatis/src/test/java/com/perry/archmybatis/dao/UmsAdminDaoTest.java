package com.perry.archmybatis.dao;

import com.perry.archmybatis.ArchMybatisApplication;
import com.perry.archmybatis.model.UmsAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * UmsAdminDao测试类
 */
@SpringBootTest(classes = ArchMybatisApplication.class)
@Transactional
public class UmsAdminDaoTest {

    @Autowired
    private UmsAdminDao umsAdminDao;

    @Test
    public void testInsertAndSelectById() {
        // 准备测试数据
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("testuser");
        admin.setPassword("password");
        admin.setEmail("test@example.com");
        admin.setNickName("Test User");
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);
        
        // 插入测试数据
        int result = umsAdminDao.insert(admin);
        assertEquals(1, result, "应该插入1条记录");
        assertNotNull(admin.getId(), "插入后应该生成ID");
        
        // 测试selectById方法
        UmsAdmin foundAdmin = umsAdminDao.selectById(admin.getId());
        
        // 验证结果
        assertNotNull(foundAdmin, "应该找到对应的用户");
        assertEquals(admin.getId(), foundAdmin.getId(), "ID应该匹配");
        assertEquals(admin.getUsername(), foundAdmin.getUsername(), "用户名应该匹配");
        assertEquals(admin.getEmail(), foundAdmin.getEmail(), "邮箱应该匹配");
        assertEquals(admin.getNickName(), foundAdmin.getNickName(), "昵称应该匹配");
        assertEquals(admin.getStatus(), foundAdmin.getStatus(), "状态应该匹配");
        assertNotNull(foundAdmin.getCreateTime(), "创建时间不应该为空");
    }

    @Test
    public void testSelectByIds() {
        // 准备测试数据
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("testuser");
        admin.setPassword("password");
        admin.setEmail("test@example.com");
        admin.setNickName("Test User");
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);

        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("testuser1");
        admin1.setPassword("password1");
        admin1.setEmail("test1@example.com");
        admin1.setNickName("Test User1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);

        int result = umsAdminDao.insert(admin);
        int result1 = umsAdminDao.insert(admin1);

        // 测试testSelectByIds
        List<Long> ids = new ArrayList<>();
        ids.add(admin.getId());
        ids.add(admin1.getId());
        List<UmsAdmin> admins = umsAdminDao.selectByIds(ids);

        for (UmsAdmin umsAdmin : admins) {
            System.out.println(umsAdmin.toString());
        }

        assertNotNull(admins,"查找结果不为空");
        assertEquals(2,admins.size(),"查找结果数量正确");

    }

    @Test
    public void testInsertBatch() {
        // 准备测试数据
        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("batchuser1");
        admin1.setPassword("password1");
        admin1.setEmail("batch1@example.com");
        admin1.setNickName("Batch User 1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);

        UmsAdmin admin2 = new UmsAdmin();
        admin2.setUsername("batchuser2");
        admin2.setPassword("password2");
        admin2.setEmail("batch2@example.com");
        admin2.setNickName("Batch User 2");
        admin2.setCreateTime(LocalDateTime.now());
        admin2.setStatus(1);

        List<UmsAdmin> adminList = new ArrayList<>();
        adminList.add(admin1);
        adminList.add(admin2);

        // 批量插入测试数据
        int result = umsAdminDao.insertBatch(adminList);
        assertEquals(2, result, "应该插入2条记录");

        // 验证插入结果
        assertNotNull(admin1.getId(), "第一条记录应该生成ID");
        assertNotNull(admin2.getId(), "第二条记录应该生成ID");

        UmsAdmin foundAdmin1 = umsAdminDao.selectById(admin1.getId());
        UmsAdmin foundAdmin2 = umsAdminDao.selectById(admin2.getId());

        assertNotNull(foundAdmin1, "应该能找到第一条插入的用户");
        assertNotNull(foundAdmin2, "应该能找到第二条插入的用户");

        assertEquals(admin1.getUsername(), foundAdmin1.getUsername(), "第一条用户名应该匹配");
        assertEquals(admin2.getUsername(), foundAdmin2.getUsername(), "第二条用户名应该匹配");
    }
    
    @Test
    public void testUpdate() {
        // 准备测试数据
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("testuser");
        admin.setPassword("password");
        admin.setEmail("test@example.com");
        admin.setNickName("Test User");
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);
        
        // 插入测试数据
        umsAdminDao.insert(admin);
        
        // 修改数据
        admin.setNickName("Updated User");
        admin.setEmail("updated@example.com");
        admin.setStatus(0);
        
        // 更新数据
        int result = umsAdminDao.updateBySelective(admin);
        assertEquals(1, result, "应该更新1条记录");
        
        // 验证更新结果
        UmsAdmin updatedAdmin = umsAdminDao.selectById(admin.getId());
        assertEquals("Updated User", updatedAdmin.getNickName(), "昵称应该已更新");
        assertEquals("updated@example.com", updatedAdmin.getEmail(), "邮箱应该已更新");
        assertEquals(Integer.valueOf(0), updatedAdmin.getStatus(), "状态应该已更新");
    }
    
    @Test
    public void testDeleteById() {
        // 准备测试数据
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("testuser");
        admin.setPassword("password");
        admin.setEmail("test@example.com");
        admin.setNickName("Test User");
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);
        
        // 插入测试数据
        umsAdminDao.insert(admin);
        
        // 删除数据
        int result = umsAdminDao.deleteById(admin.getId());
        assertEquals(1, result, "应该删除1条记录");
        
        // 验证删除结果
        UmsAdmin deletedAdmin = umsAdminDao.selectById(admin.getId());
        assertNull(deletedAdmin, "应该找不到已删除的用户");
    }


    @Test
    public void testSelectByUsernameAndEmailLike() {
        // 准备测试数据
        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("likeuser1");
        admin1.setPassword("password");
        admin1.setEmail("like1@example.com");
        admin1.setNickName("Like User 1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);
        umsAdminDao.insert(admin1);

        UmsAdmin admin2 = new UmsAdmin();
        admin2.setUsername("likeuser2");
        admin2.setPassword("password");
        admin2.setEmail("like2@example.com");
        admin2.setNickName("Like User 2");
        admin2.setCreateTime(LocalDateTime.now());
        admin2.setStatus(1);
        umsAdminDao.insert(admin2);

        // 测试用户名模糊查询
        List<UmsAdmin> result1 = umsAdminDao.selectByUsernameAndEmailLike("likeuser", null);
        assertTrue(result1.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试邮箱模糊查询
        List<UmsAdmin> result2 = umsAdminDao.selectByUsernameAndEmailLike(null, "like");
        assertTrue(result2.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试用户名和邮箱同时模糊查询
        List<UmsAdmin> result3 = umsAdminDao.selectByUsernameAndEmailLike("likeuser", "like");
        assertTrue(result3.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试不输入参数查询所有
        List<UmsAdmin> result4 = umsAdminDao.selectByUsernameAndEmailLike(null, null);
        assertNotNull(result4, "应该返回所有用户列表");
        assertTrue(result4.size() >= 2, "应该至少有2条记录");
    }

    @Test
    public void testSelectByUsernameAndEmailLike2() {
        // 准备测试数据
        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("chooseuser1");
        admin1.setPassword("password");
        admin1.setEmail("choose1@example.com");
        admin1.setNickName("Choose User 1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);
        umsAdminDao.insert(admin1);

        UmsAdmin admin2 = new UmsAdmin();
        admin2.setUsername("chooseuser2");
        admin2.setPassword("password");
        admin2.setEmail("choose2@example.com");
        admin2.setNickName("Choose User 2");
        admin2.setCreateTime(LocalDateTime.now());
        admin2.setStatus(1);
        umsAdminDao.insert(admin2);

        // 测试用户名模糊查询
        List<UmsAdmin> result1 = umsAdminDao.selectByUsernameAndEmailLike2("chooseuser", null);
        assertTrue(result1.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试邮箱模糊查询
        List<UmsAdmin> result2 = umsAdminDao.selectByUsernameAndEmailLike2(null, "choose");
        assertTrue(result2.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试用户名和邮箱同时模糊查询
        List<UmsAdmin> result3 = umsAdminDao.selectByUsernameAndEmailLike2("chooseuser", "choose");
        assertTrue(result3.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试不输入参数不返回数据
        List<UmsAdmin> result4 = umsAdminDao.selectByUsernameAndEmailLike2(null, null);
        assertNotNull(result4, "应该返回空列表");
        assertEquals(0, result4.size(), "应该没有记录");
    }

    @Test
    public void testSelectByUsernameAndEmailLike3() {
        // 准备测试数据
        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("whereuser1");
        admin1.setPassword("password");
        admin1.setEmail("where1@example.com");
        admin1.setNickName("Where User 1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);
        umsAdminDao.insert(admin1);

        UmsAdmin admin2 = new UmsAdmin();
        admin2.setUsername("whereuser2");
        admin2.setPassword("password");
        admin2.setEmail("where2@example.com");
        admin2.setNickName("Where User 2");
        admin2.setCreateTime(LocalDateTime.now());
        admin2.setStatus(1);
        umsAdminDao.insert(admin2);

        // 测试用户名模糊查询
        List<UmsAdmin> result1 = umsAdminDao.selectByUsernameAndEmailLike3("whereuser", null);
        assertTrue(result1.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试邮箱模糊查询
        List<UmsAdmin> result2 = umsAdminDao.selectByUsernameAndEmailLike3(null, "where");
        assertTrue(result2.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试用户名和邮箱同时模糊查询
        List<UmsAdmin> result3 = umsAdminDao.selectByUsernameAndEmailLike3("whereuser", "where");
        assertTrue(result3.size() >= 2, "应该至少找到2个匹配的用户");

        // 测试不输入参数查询所有
        List<UmsAdmin> result4 = umsAdminDao.selectByUsernameAndEmailLike3(null, null);
        assertNotNull(result4, "应该返回所有用户列表");
        assertTrue(result4.size() >= 2, "应该至少有2条记录");
    }
    
    @Test
    public void testSelectAll() {
        // 准备测试数据
        UmsAdmin admin1 = new UmsAdmin();
        admin1.setUsername("testuser1");
        admin1.setPassword("password");
        admin1.setEmail("test1@example.com");
        admin1.setNickName("Test User 1");
        admin1.setCreateTime(LocalDateTime.now());
        admin1.setStatus(1);
        umsAdminDao.insert(admin1);
        
        UmsAdmin admin2 = new UmsAdmin();
        admin2.setUsername("testuser2");
        admin2.setPassword("password");
        admin2.setEmail("test2@example.com");
        admin2.setNickName("Test User 2");
        admin2.setCreateTime(LocalDateTime.now());
        admin2.setStatus(1);
        umsAdminDao.insert(admin2);
        
        // 查询所有数据
        List<UmsAdmin> admins = umsAdminDao.selectAll();
        assertNotNull(admins, "应该返回用户列表");
        assertTrue(admins.size() >= 2, "应该至少有2条记录");
    }
    
    @Test
    public void testSelectByUsername() {
        // 准备测试数据
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("unique_testuser");
        admin.setPassword("password");
        admin.setEmail("test@example.com");
        admin.setNickName("Test User");
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);
        
        // 插入测试数据
        umsAdminDao.insert(admin);
        
        // 根据用户名查询
        UmsAdmin foundAdmin = umsAdminDao.selectByUsername("unique_testuser");
        
        // 验证结果
        assertNotNull(foundAdmin, "应该找到对应的用户");
        assertEquals("unique_testuser", foundAdmin.getUsername(), "用户名应该匹配");
    }
}