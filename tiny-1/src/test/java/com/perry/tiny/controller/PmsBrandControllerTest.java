package com.perry.tiny.controller;

import com.perry.tiny.common.api.CommonPage;
import com.perry.tiny.common.api.CommonResult;
import com.perry.tiny.mbg.model.PmsBrand;
import com.perry.tiny.service.PmsBrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PmsBrandControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PmsBrandService brandService;

    @InjectMocks
    private PmsBrandController brandController;

    private PmsBrand testBrand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(brandController).build();
        
        testBrand = new PmsBrand();
        testBrand.setId(1L);
        testBrand.setName("测试品牌");
        testBrand.setFirstLetter("C");
        testBrand.setSort(1);
        testBrand.setFactoryStatus(1);
        testBrand.setShowStatus(1);
        testBrand.setProductCount(100);
        testBrand.setProductCommentCount(50);
        testBrand.setLogo("logo.jpg");
        testBrand.setBigPic("bigpic.jpg");
        testBrand.setBrandStory("品牌故事");
        
        System.out.println("测试环境初始化完成");
    }

    @Test
    void listAll() throws Exception {
        // Given
        List<PmsBrand> brandList = Arrays.asList(testBrand);
        when(brandService.listAllBrand()).thenReturn(brandList);
        System.out.println("准备测试listAll方法，模拟brandService.listAllBrand返回包含1个品牌的列表");

        // When & Then
        mockMvc.perform(get("/brand/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].name").value("测试品牌"));
        
        verify(brandService, times(1)).listAllBrand();
        System.out.println("执行listAll方法测试，验证返回结果和brandService.listAllBrand方法被调用1次");
    }

    @Test
    void createBrand() throws Exception {
        // Given
        when(brandService.createBrand(any(PmsBrand.class))).thenReturn(1);
        System.out.println("准备测试createBrand方法，模拟brandService.createBrand返回值为1");

        // When & Then
        mockMvc.perform(post("/brand/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"测试品牌\",\"firstLetter\":\"C\",\"sort\":1,\"factoryStatus\":1,\"showStatus\":1,\"productCount\":100,\"productCommentCount\":50,\"logo\":\"logo.jpg\",\"bigPic\":\"bigpic.jpg\",\"brandStory\":\"品牌故事\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.name").value("测试品牌"));

        verify(brandService, times(1)).createBrand(any(PmsBrand.class));
        System.out.println("执行createBrand方法测试，验证返回结果和brandService.createBrand方法被调用1次");
    }

    @Test
    void updateBrand() throws Exception {
        // Given
        when(brandService.updateBrand(anyLong(), any(PmsBrand.class))).thenReturn(1);
        System.out.println("准备测试updateBrand方法，模拟brandService.updateBrand返回值为1");

        // When & Then
        mockMvc.perform(post("/brand/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"更新品牌\",\"firstLetter\":\"G\",\"sort\":2,\"factoryStatus\":1,\"showStatus\":1,\"productCount\":200,\"productCommentCount\":100,\"logo\":\"logo2.jpg\",\"bigPic\":\"bigpic2.jpg\",\"brandStory\":\"更新的品牌故事\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        verify(brandService, times(1)).updateBrand(anyLong(), any(PmsBrand.class));
        System.out.println("执行updateBrand方法测试，验证返回结果和brandService.updateBrand方法被调用1次");
    }

    @Test
    void deleteBrand() throws Exception {
        // Given
        when(brandService.deleteBrand(anyLong())).thenReturn(1);
        System.out.println("准备测试deleteBrand方法，模拟brandService.deleteBrand返回值为1");

        // When & Then
        mockMvc.perform(get("/brand/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        verify(brandService, times(1)).deleteBrand(1L);
        System.out.println("执行deleteBrand方法测试，验证返回结果和brandService.deleteBrand方法被调用1次");
    }

    @Test
    void listBrand() throws Exception {
        // Given
        List<PmsBrand> brandList = Arrays.asList(testBrand);
        when(brandService.listBrand(anyInt(), anyInt())).thenReturn(brandList);
        System.out.println("准备测试listBrand方法，模拟brandService.listBrand返回包含1个品牌的列表");

        // When & Then
        mockMvc.perform(get("/brand/list")
                .param("pageNum", "1")
                .param("pageSize", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list[0].id").value(1))
                .andExpect(jsonPath("$.data.list[0].name").value("测试品牌"));

        verify(brandService, times(1)).listBrand(1, 3);
        System.out.println("执行listBrand方法测试，验证返回结果和brandService.listBrand方法被调用1次");
    }

    @Test
    void brand() throws Exception {
        // Given
        when(brandService.getBrand(anyLong())).thenReturn(testBrand);
        System.out.println("准备测试brand方法，模拟brandService.getBrand返回测试品牌");

        // When & Then
        mockMvc.perform(get("/brand/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.name").value("测试品牌"));

        verify(brandService, times(1)).getBrand(1L);
        System.out.println("执行brand方法测试，验证返回结果和brandService.getBrand方法被调用1次");
    }
}