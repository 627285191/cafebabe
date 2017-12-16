## 前言 
cafebabe是spring boot 搭建的一个企业级快速开发脚手架。
## 目录
* [技术栈](#技术栈)
* [编码约定](#编码约定)
* [文件名称约定](#文件名称约定)
* [controller、service、dao方法名称约定](#controller、service、dao方法名称约定)

### 编码约定
系统分为controller、service、dao层。
controller主要负责转发、service主要负责业务逻辑、dao主要是数据库的操作。

### 命名约定
* 数据库命名约定
   * 命名前缀约定(类型名)：
   
   类型|说明|前缀规范
   ---|:---:|---
   表|TABLE|`T_`
   视图|VIEW|`V_(与普通变量相同)`
   索引|INDEX|`IDX_`
   主键约束|PRIMARY KEY|`PK_`
   外键约束|FOREIGN KEY|`FK_`
   唯一约束|UNIQUE KEY|`UK_`
   序列(oracle)|SEQUENCE|`SEQ_`
   存储过程|STORE PROCEDURE|`PROC_`
   包(oracle)|PACKAGE|`PKG_`
   触发器|TRIGGER|`TRG_`
   普通变量|VARIABLE|`V_`
   游标变量|CURSOR|`CUR_`
   输入参数|PARAMETER|`P_`
   输出参数|OUT|`O_`
   
   * 数据库表命名均遵循以下约定：
      * 类型名_模块名_存储信息名词，全部小写，例如：t_ch_message
   * 视图命名均遵循以下约定：
      * 前缀V_
   * 数据库字段命名遵循以下约定：
      * 存储信息名词(多个单词用下划线分隔)，全部小写，例如：message_id。
     1. 创建者id、创建时间
     2. 字段必须填写描述信息（注释）
   * 存储过程、函数、触发器命名遵循以下约定：
      存储过程前缀proc，函数前缀fun，触发器前缀trigger

   
* Java源码命名约定
   * 部分约定节选自阿里巴巴Java开发手册，如下是阿里巴巴编码规约扫描插件的安装方法：
      * 采用idea作为开发工具的，Settings >> Plugins >> Browse repositories… 搜索`Alibaba Java Coding Guidelines`插件。
      * 采用eclipse作为开发工具的，Help >> Install New Software 然后在框中输入URL：`https://p3c.alibaba.com/plugin/eclipse/update`。
   * 包的命名
      * 包名统一使用小写，且只能用一个英语单词来表示，不可出现复数形式。包的命名一般都是按照域名+公司名+项目名+具体反映包内容的名字。例如：com.cafebabe.xxx。 
      * 此外，对于包名我们做如下约定:
        1. 控制层的包名为.controller
        2. 业务逻辑层的包名为.service，实现类放在.service.impl包下
        3. 数据操作层的包名为.dao
        4. 实体类的包名为.eneity
        5. 工具函数类包名为.util
        6. spring配置以及注册bean的包名为.autoconfigure
        7. 常量类的包名为.constant
        8. 定时任务的包名为.job
        9. 拦截器的包名为.interceptor
   * 类的命名
      * 类名采用`大驼峰命名法(UpperCamelCase)`，例如CafebabeApplication。
      * 抽象类命名使用 Abstract 或 Base 开头 ； 异常类命名使用 Exception 结尾 ； 测试类命名以它要测试的类的名称开始，以 Test 结尾。
      * 对于 Service 和 DAO 类，内部的实现类用 Impl 的后缀与接口区别。
      * 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
   * 成员变量、方法名、参数名、局部变量
      * 成员变量、方法名、参数名、局部变量都统一采用`小驼峰命名法(lowerCamelCase)`，例如：localValue /  getHttpMessage() /  inputUserId
      * 接口类中的方法和属性不要加任何修饰符号（public 也不要加 ），并加上有效的javadoc注释。
   * 常量的命名
      * 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。正例：  MAX _ STOCK _ COUNT反例：  MAX _ COUNT


### RESTful风格的请求约定
GET /zoos：列出所有动物园

POST /zoos：新建一个动物园

GET /zoos/ID：获取某个指定动物园的信息

PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）

PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）

DELETE /zoos/ID：删除某个动物园

GET /zoos/ID/animals：列出某个指定动物园的所有动物

DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物

#### 安全性和幂等性
安全性：不会使服务器资源状态发生改变的请求，即是安全的。

幂等性：对同一个请求的多次访问，得到的资源是相同的。

GET:安全、幂等，用来读取资源（get）。

PUT：幂等，用来更新资源（update）；媒体类型，要消费的（请求）媒体类型（用Content Type定义）与要生产的（返回）媒体类型（用Accept定义），MediaType是JAX-RS2提供的媒体类型定义类。

POST：用来创建资源（inset）。例外是相同数据的创建请求总能提供唯一主键值，满足幂等性，那么这时候用PUT。

DELETE：幂等，用来删除资源（delete），返回值可定义为void，http状态码为204（No Content）。

媒体类型，http状态码来确定方法信息。

资源定位：北京/动物园/狮虎园/老虎

一个资源可以有多个uri地址，但一个uri地址唯一对应一个资源。

当http方法无法满足业务需求时，可以考虑用动词作为查询参数或使用RPC风格的post方法。



### 新建模块
1. new Module <br>
2. GroupId --->com.cafebabe  <br>
3. ArtifactId---> cafebabe-模块名称   如  cafebabe-blog     <br>
4. Version --> 版本号   如 1.0SNAPSHOT <br>
5. Module-Name--> cafebabe-模块名称   如  cafebabe-blog     <br>
6. 提交新建模块  <br>
7. pom 文件引入
```
    <name>cafebabe-模块名称</name>

    <dependencies>
        <dependency>
            <groupId>com.cafebabe</groupId>
            <artifactId>cafebabe-blog</artifactId>
        </dependency>
        ......其他的依赖
    </dependencies>
```
8. 子模块是web项目，并且需要使用jsp时，pom 文件引入
```
            <!--为spring boot增加jsp支持，web相关的子模块需要引入-->
            <!-- 增加jstl支持 -->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
            </dependency>
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
            </dependency>

            <!--以下两个部署到外部tomcat时，scope要改成provided的-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </dependency>
            <dependency>
                <groupId>org.apache.tomcat.embed</groupId>
                <artifactId>tomcat-embed-jasper</artifactId>
            </dependency>
```
### 技术栈
* Spring Boot 

* MySQL

* Shiro

* Bootstrap

* mybatis

### 项目进展 TODO
- [x] 前台展示 :smile:
- [ ] 后台管理 :dizzy_face:
- [ ] 登陆界面 :dizzy_face:
