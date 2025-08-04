package com.perry.archmbg;

import com.perry.archmbg.dao.UmsAdminDao;
import com.perry.archmbg.domain.AdminRoleDto;
import com.perry.archmbg.domain.ResourceWithCateDto;
import com.perry.archmbg.domain.RoleStatDto;
import com.perry.archmbg.mbg.mapper.UmsAdminMapper;
import com.perry.archmbg.mbg.model.UmsAdmin;
import com.perry.archmbg.mbg.model.UmsAdminExample;
import com.perry.archmbg.service.impl.UmsAdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class UmsAdminServiceImplTest {

    @Mock
    private UmsAdminMapper adminMapper;

    @Mock
    private UmsAdminDao adminDao;

    @InjectMocks
    private UmsAdminServiceImpl adminService;

    private UmsAdmin testAdmin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        testAdmin = new UmsAdmin();
        testAdmin.setId(1L);
        testAdmin.setUsername("testuser");
        testAdmin.setPassword("password");
        testAdmin.setCreateTime(LocalDateTime.now());
        testAdmin.setStatus(1);
        
        System.out.println("测试环境初始化完成");
    }

    @Test
    void create() {
        // Given
        when(adminMapper.insert(any(UmsAdmin.class))).thenReturn(1);
        System.out.println("准备测试create方法，模拟adminMapper.insert返回值为1");

        // When
        adminService.create(testAdmin);
        System.out.println("执行create方法，传入测试管理员信息: " + testAdmin);

        // Then
        verify(adminMapper, times(1)).insert(testAdmin);
        System.out.println("验证adminMapper.insert方法被调用1次");
    }

    @Test
    void update() {
        // Given
        when(adminMapper.updateByPrimaryKeySelective(any(UmsAdmin.class))).thenReturn(1);
        System.out.println("准备测试update方法，模拟adminMapper.updateByPrimaryKeySelective返回值为1");

        // When
        adminService.update(testAdmin);
        System.out.println("执行update方法，传入测试管理员信息: " + testAdmin);

        // Then
        verify(adminMapper, times(1)).updateByPrimaryKeySelective(testAdmin);
        System.out.println("验证adminMapper.updateByPrimaryKeySelective方法被调用1次");
    }

    @Test
    void delete() {
        // Given
        when(adminMapper.deleteByPrimaryKey(anyLong())).thenReturn(1);
        System.out.println("准备测试delete方法，模拟adminMapper.deleteByPrimaryKey返回值为1");

        // When
        adminService.delete(1L);
        System.out.println("执行delete方法，删除ID为1的管理员");

        // Then
        verify(adminMapper, times(1)).deleteByPrimaryKey(1L);
        System.out.println("验证adminMapper.deleteByPrimaryKey方法被调用1次，参数为1L");
    }

    @Test
    void select() {
        // Given
        when(adminMapper.selectByPrimaryKey(anyLong())).thenReturn(testAdmin);
        System.out.println("准备测试select方法，模拟adminMapper.selectByPrimaryKey返回测试管理员");

        // When
        UmsAdmin result = adminService.select(1L);
        System.out.println("执行select方法，查询ID为1的管理员，返回结果: " + result);

        // Then
        assertNotNull(result);
        assertEquals(testAdmin.getId(), result.getId());
        verify(adminMapper, times(1)).selectByPrimaryKey(1L);
        System.out.println("验证查询结果非空，ID匹配，且adminMapper.selectByPrimaryKey方法被调用1次");
    }

    @Test
    void listAll() {
        // Given
        List<UmsAdmin> adminList = Arrays.asList(testAdmin);
        when(adminMapper.selectByExample(any(UmsAdminExample.class))).thenReturn(adminList);
        System.out.println("准备测试listAll方法，模拟adminMapper.selectByExample返回包含1个管理员的列表");

        // When
        List<UmsAdmin> result = adminService.listAll(1, 10);
        System.out.println("执行listAll方法，分页参数: page=1, size=10，返回结果数量: " + result.size());

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(adminMapper, times(1)).selectByExample(any(UmsAdminExample.class));
        System.out.println("验证查询结果非空且包含1个元素，adminMapper.selectByExample方法被调用1次");
    }

    @Test
    void list() {
        // Given
        List<UmsAdmin> adminList = Arrays.asList(testAdmin);
        List<Integer> statusList = Arrays.asList(1, 2);
        when(adminMapper.selectByExample(any(UmsAdminExample.class))).thenReturn(adminList);
        System.out.println("准备测试list方法，模拟adminMapper.selectByExample返回包含1个管理员的列表");

        // When
        List<UmsAdmin> result = adminService.list(1, 10, "testuser", statusList);
        System.out.println("执行list方法，分页参数: page=1, size=10，查询条件: username=testuser, statusList=" + statusList + "，返回结果数量: " + result.size());

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(adminMapper, times(1)).selectByExample(any(UmsAdminExample.class));
        System.out.println("验证查询结果非空且包含1个元素，adminMapper.selectByExample方法被调用1次");
    }

    @Test
    void subList() {
        // Given
        List<UmsAdmin> adminList = Arrays.asList(testAdmin);
        when(adminDao.subList(anyLong())).thenReturn(adminList);
        System.out.println("准备测试subList方法，模拟adminDao.subList返回包含1个管理员的列表");

        // When
        List<UmsAdmin> result = adminService.subList(1L);
        System.out.println("执行subList方法，查询角色ID为1的管理员列表，返回结果数量: " + result.size());

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(adminDao, times(1)).subList(1L);
        System.out.println("验证查询结果非空且包含1个元素，adminDao.subList方法被调用1次，参数为1L");
    }

    @Test
    void groupList() {
        // Given
        RoleStatDto roleStatDto = new RoleStatDto();
        List<RoleStatDto> roleStatList = Arrays.asList(roleStatDto);
        when(adminDao.groupList()).thenReturn(roleStatList);
        System.out.println("准备测试groupList方法，模拟adminDao.groupList返回包含1个RoleStatDto的列表");

        // When
        List<RoleStatDto> result = adminService.groupList();
        System.out.println("执行groupList方法，返回结果数量: " + result.size());

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(adminDao, times(1)).groupList();
        System.out.println("验证查询结果非空且包含1个元素，adminDao.groupList方法被调用1次");
    }

    @Test
    void deleteByUsername() {
        // Given
        when(adminMapper.deleteByExample(any(UmsAdminExample.class))).thenReturn(1);
        System.out.println("准备测试deleteByUsername方法，模拟adminMapper.deleteByExample返回值为1");

        // When
        adminService.deleteByUsername("testuser");
        System.out.println("执行deleteByUsername方法，删除用户名为testuser的管理员");

        // Then
        verify(adminMapper, times(1)).deleteByExample(any(UmsAdminExample.class));
        System.out.println("验证adminMapper.deleteByExample方法被调用1次");
    }

    @Test
    void updateByIds() {
        // Given
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        when(adminMapper.updateByExampleSelective(any(), any(UmsAdminExample.class))).thenReturn(1);
        System.out.println("准备测试updateByIds方法，模拟adminMapper.updateByExampleSelective返回值为1");

        // When
        adminService.updateByIds(ids, 1);
        System.out.println("执行updateByIds方法，更新ID列表: " + ids + "，状态设置为: 1");

        // Then
        verify(adminMapper, times(1)).updateByExampleSelective(any(), any(UmsAdminExample.class));
        System.out.println("验证adminMapper.updateByExampleSelective方法被调用1次");
    }

    @Test
    void selectWithRoleList() {
        // Given
        AdminRoleDto adminRoleDto = new AdminRoleDto();
        when(adminDao.selectWithRoleList(anyLong())).thenReturn(adminRoleDto);
        System.out.println("准备测试selectWithRoleList方法，模拟adminDao.selectWithRoleList返回AdminRoleDto对象");

        // When
        AdminRoleDto result = adminService.selectWithRoleList(1L);
        System.out.println("执行selectWithRoleList方法，查询ID为1的管理员及其角色列表，返回结果: " + result);

        // Then
        assertNotNull(result);
        verify(adminDao, times(1)).selectWithRoleList(1L);
        System.out.println("验证查询结果非空，adminDao.selectWithRoleList方法被调用1次，参数为1L");
    }

    @Test
    void selectResourceWithCate() {
        // Given
        ResourceWithCateDto resourceWithCateDto = new ResourceWithCateDto();
        when(adminDao.selectResourceWithCate(anyLong())).thenReturn(resourceWithCateDto);
        System.out.println("准备测试selectResourceWithCate方法，模拟adminDao.selectResourceWithCate返回ResourceWithCateDto对象");

        // When
        ResourceWithCateDto result = adminService.selectResourceWithCate(1L);
        System.out.println("执行selectResourceWithCate方法，查询ID为1的资源及其分类信息，返回结果: " + result);

        // Then
        assertNotNull(result);
        verify(adminDao, times(1)).selectResourceWithCate(1L);
        System.out.println("验证查询结果非空，adminDao.selectResourceWithCate方法被调用1次，参数为1L");
    }
}