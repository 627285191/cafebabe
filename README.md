## 前言 
cafebabe是spring boot 搭建的一个企业级快速开发脚手架。
## 目录

* [技术栈](#技术栈)

* [编码约定](#命名规范)

* [文件名称约定](#文件名称约定)

* [controller、service、dao方法名称约定](#controller、service、dao方法名称约定)

### 技术栈
1. Spring Boot <p>
2. MySQL<p>
3. Shiro  <p>
4. Bootstrap <p>
5. mybatis <p>

## 编码约定
系统分为controller、service、dao层。
controller主要负责转发、service主要负责业务逻辑、dao主要是数据库的操作。

## 文件名称约定


## controller、service、dao方法名称约定



##RESTful风格
GET /zoos：列出所有动物园

POST /zoos：新建一个动物园

GET /zoos/ID：获取某个指定动物园的信息

PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）

PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）

DELETE /zoos/ID：删除某个动物园

GET /zoos/ID/animals：列出某个指定动物园的所有动物

DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物

####安全性和幂等性
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
#数据库读写分离




#缓存ecache、redis




#新建模块
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

