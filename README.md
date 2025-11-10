# ShoppingByJAVA

> 基于 Java 微服务架构的模拟购物商城

[![GitHub Stars](https://img.shields.io/github/stars/sudongx/shoppingByJAVA?style=social)](https://github.com/sudongx/shoppingByJAVA/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/sudongx/shoppingByJAVA?style=social)](https://github.com/sudongx/shoppingByJAVA/network/members)
[![License](https://img.shields.io/github/license/sudongx/shoppingByJAVA?color=blue)](LICENSE)

---

## 📖 项目简介

**以 **Java 技术栈** 为核心开发的模拟购物商城系统，主要用于提供 **交流与学习 Web 后端开发思路**。  
项目模拟了电商平台的基本业务流程，包括用户登录注册、商品展示、购物车管理、订单结算等功能模块。  

该项目旨在帮助初学者理解：
- Web 后端系统架构设计；
- 前后端数据交互流程；
- Java 与数据库的集成开发；
- Nginx、Tomcat 等部署流程。

---

## 🧩 技术栈

| 模块 | 技术 |
|:--:|:--|
| 后端 | Java 11、Spring Boot / Servlet |
| 数据库 | MySQL / JDBC |
| 前端 | HTML、CSS、JavaScript、Bootstrap |
| 部署 | Debian + Nginx + nacos |
| 工具 | Maven、Git、IntelliJ IDEA |

---

## 🛠️ 功能模块

- 👤 **用户模块**：注册、登录、个人信息管理  
- 🛍️ **商品模块**：商品浏览、分类、搜索  
- 🛒 **购物车模块**：添加、修改、删除购物项  
- 💳 **订单模块**：下单、查看订单、支付模拟  
- ⚙️ **后台管理**（可选）：商品与用户的基础管理功能

---

## 🧠 学习价值

本项目适合以下学习方向的开发者：

- 想熟悉 **Java Web 后端开发流程**；
- 希望理解 **电商系统的基本架构与业务逻辑**；
- 学习如何将 **前端与后端进行数据联调**；
- 练习 **Linux 环境下的部署与调试**；
- 探索 **Nginx + Tomcat 多层部署结构**。

> 💡 **注意：** 本项目仅用于技术学习与个人练习，不作为商业用途。

---

## 🚀 快速开始

### 1️⃣ 克隆项目
```bash
git clone https://github.com/sudongx/shoppingByJAVA.git
cd shoppingByJAVA
```
### 前端访问地址（需要启动文件夹内的nginx）
http://localhost:18080/

### 项目结构
shoppingByJAVA/
├── src/
│   ├── main/
│   │   ├── java/         # 后端源代码
│   │   ├── resources/    # 配置文件与静态资源
│   └── test/             # 单元测试
├── web/                  # 前端网页与静态文件
├── shopping.sql          # 数据库脚本
└── README.md

