#cafebabe
spring boot 搭建的一个企业级快速开发脚手架。
###技术栈
1. Spring Boot <p>
2. MySQL<p>
3. Shiro  <p>
4. Bootstrap <p>
5. mybatis、mybatisPlus <p>
6. redis <p>
7. SiteMesh <p>
8. Activiti <p>
#编码约定
系统分为controller、service、dao层。
controller主要负责转发、service主要负责业务逻辑、dao主要是数据库的操作。

###文件名称约定
在页面文件夹中，按照功能模块分别建立不同的文件夹存放页面，如用户的页面就放在user文件夹中，而角色的就放在role文件夹中。
1. 页面如果是列表类型的。页面的文件名用list.ftl命名。
2. 页面如果是详情类型的。页面的文件名用detail.ftl命名。

###controller、service、dao方法名称约定



###RESTful风格
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
#JDK版本 1.8
```

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                    <compilerArgs>
                        <arg>-parameters</arg>
                    </compilerArgs>
                    <useIncrementalCompilation>false</useIncrementalCompilation>
                </configuration>
            </plugin>
        </plugins>
    </build>

```

#新建一个功能模块
1、创建数据库

2、创建entity类

3、创建service类

4、创建controller类

5、创建list界面
```

5.1 到其他list复制代码过


5.2 修改
 <script>
        var url = "${base}/sys/user/";
 </script>

 中的 url 为你刚刚创建的 controller的类
 @Controller
 @RequestMapping(value = "/sys/user")
 public class SysUserController extends BaseController {

 的  @RequestMapping(value = "/sys/user") 值

5.3 修改搜索条件
目前的搜索条件有
    /**
     * 等于
     */
    public static final String SEARCH_EQ="search_eq_";

    /**
     * 左模糊
     */
    public static final String SEARCH_LLIKE="search_llike_";

    /**
     * 右模糊
     */
    public static final String SEARCH_RLIKE="search_rlike_";

    /***
     * 全模糊
     */
    public static final String SEARCH_LIKE="search_like_";



     <input type="text" class="form-filter input-sm _search" name="search_eq_login_name">

     只要在  input中 的 name 加入 search_eq_ 前缀 再加数据库中的字段名称即可



5.4 修改表格的字段名称

```






# 项目截图介绍

## 系统用户管理
![](https://github.com/javanan/slife/blob/master/dec/1.jpg?raw=true)
![](https://github.com/javanan/slife/blob/master/dec/1-1.jpg?raw=true)


## 系统菜单管理
![](https://github.com/javanan/slife/blob/master/dec/2.jpg?raw=true)
![](https://github.com/javanan/slife/blob/master/dec/2-2.jpg?raw=true)


## 系统角色管理

    RBAC权限管理模型

![](https://github.com/javanan/slife/blob/master/dec/3.jpg?raw=true)


## 日志监控

    系统自定义注解，结合AOP，监控用户操作行为

![](https://github.com/javanan/slife/blob/master/dec/4.jpg?raw=true)


## API文档

    swaggerUi接口文档展示

![](https://github.com/javanan/slife/blob/master/dec/5.jpg?raw=true)


## 数据库监控

    使用druid监控数据库健康。本来这里是三个数据源的，使用aop动态的书写切换。没上传到git，需要的同学可以私我

![](https://github.com/javanan/slife/blob/master/dec/6.jpg?raw=true)



## maven构建 多模块开发

    根据不同的业务，不在不同的业务模块中开发，如果基本的用户、组织等的管理在 sys模块
    日志的业务逻辑在 log模块

![](https://github.com/javanan/slife/blob/master/dec/7.jpg?raw=true)

**可插拔式部署**
    把不同的模块打包成jar，对应的freemark文件也打包在对应的模块jar中。实现了功能模块的可插拔式部署。

![](https://github.com/javanan/slife/blob/master/dec/8.jpg?raw=true)



## 联系方式
微信0
qq群 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=3d00028ad6bec03e99d0491e6fb055b3edbd5be3ef9ab5adbafb8a13851ba7eb"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="SLife" title="SLife"></a>


# **[点我获取阿里云优惠券](https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=vf2b5zld&utm_source=vf2b5zld)**





















