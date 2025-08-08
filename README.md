# Architecture Project

## 项目简介

这是一个基于Spring Boot的多模块企业级应用架构项目，提供了完整的后端开发基础框架。项目集成了多种常用技术组件，可以作为企业级应用开发的基础模板。

## 技术栈

- **核心框架**: Spring Boot 2.7.5
- **ORM框架**: MyBatis 3.5.10 + MyBatis Generator 1.4.1
- **数据库**: MySQL 8.0
- **分页插件**: PageHelper 5.3.2
- **连接池**: Druid 1.2.14
- **文档工具**: SpringFox Swagger 3.0.0
- **安全框架**: Spring Security + JWT 0.9.1
- **工具类库**: Hutool 5.8.9
- **对象存储**: MinIO 8.4.5
- **消息队列**: RabbitMQ
- **缓存**: Redis
- **数据库**: MongoDB
- **搜索引擎**: Elasticsearch
- **其他**: Lombok, Actuator

## 模块说明

### 基础架构模块
- **arch-mybatis**: MyBatis基础配置模块
- **arch-mbg**: MyBatis Generator代码生成模块
- **arch-swagger**: Swagger文档配置模块

### 应用模块
- **tiny-1**: 基础Spring Boot + MyBatis应用
- **tiny-2**: 集成Redis的应用模块
- **tiny-3**: 集成MongoDB的应用模块
- **tiny-4**: 集成Elasticsearch的应用模块
- **tiny-5**: 集成RabbitMQ的应用模块
- **tiny-6**: 集成安全框架的应用模块
- **tiny-7**: 集成多种技术的综合应用模块
- **tiny-8**: 集成所有技术的完整应用模块，包含Lombok、MyBatis、Swagger、Redis、Spring Security、JWT、Hutool、Spring Data Redis、MongoDB、RabbitMQ、MinIO等

## 环境要求

- JDK 1.8 或更高版本
- Maven 3.x
- MySQL 8.0
- Redis
- MongoDB
- Elasticsearch
- RabbitMQ
- MinIO

## 快速开始

1. 克隆项目到本地
```bash
git clone <repository-url>
```

2. 导入数据库脚本
```bash
# 在doc/msyql/目录下有数据库脚本
mysql -u root -p < doc/msyql/mail_tiny.sql
```

3. 修改配置文件
根据实际环境修改各模块`src/main/resources/application.yml`中的数据库连接、Redis连接等配置。

4. 编译项目
```bash
mvn clean install
```

5. 启动应用
```bash
# 启动指定模块，例如tiny-8
cd tiny-8
mvn spring-boot:run
```

## 功能特性

- **统一响应格式**: 提供统一的API响应结构
- **异常处理**: 全局异常处理机制
- **JWT认证**: 基于JWT的用户认证和授权
- **接口文档**: 集成Swagger生成接口文档
- **分页支持**: 集成分页插件，支持统一的分页查询
- **代码生成**: 集成MyBatis Generator，支持代码自动生成
- **多数据源**: 支持多种数据库和NoSQL存储
- **缓存支持**: 集成Redis缓存
- **消息队列**: 集成RabbitMQ消息队列
- **文件存储**: 集成MinIO对象存储
- **监控端点**: 集成Spring Boot Actuator监控端点

## 配置说明

各模块的配置文件位于`src/main/resources/application.yml`，主要配置项包括：

- 数据库连接配置
- Redis连接配置
- RabbitMQ连接配置
- MinIO连接配置
- JWT密钥配置
- Swagger配置

## 开发规范

- 遵循RESTful API设计规范
- 使用统一的响应格式
- 使用Lombok简化Java Bean代码
- 使用Hutool工具库提高开发效率
- 使用Swagger编写接口文档

## 许可证

[查看LICENSE文件](LICENSE)