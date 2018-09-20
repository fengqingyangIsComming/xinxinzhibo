### FEBS后台权限管理系统
![https://img.shields.io/badge/build-success-brightgreen.svg?longCache=true&style=flat-square](https://img.shields.io/badge/build-success-brightgreen.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/license-Apache%202-blue.svg?longCache=true&style=flat-square](https://img.shields.io/badge/license-Apache%202-blue.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/download-1k-green.svg?longCache=true&style=flat-square](https://img.shields.io/badge/download-1k-green.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/springboot-2.0.4-yellow.svg?longCache=true&style=popout-square](https://img.shields.io/badge/springboot-2.0.4-yellow.svg?longCache=true&style=popout-square)
![https://img.shields.io/badge/apache%20shiro-1.4.0-green.svg?longCache=true&style=flat-square](https://img.shields.io/badge/apache%20shiro-1.4.0-green.svg?longCache=true&style=flat-square)

FEBS是一个简单高效的后台权限管理系统。项目基础框架采用全新的Java Web开发框架 —— Spring Boot2.0.4，消除了繁杂的XML配置，使得二次开发更为简单；数据访问层采用Mybatis，同时引入了通用Mapper和PageHelper插件，可快速高效的对单表进行增删改查操作，消除了大量传统XML配置SQL的代码；安全框架采用时下流行的Apache Shiro，可实现对按钮级别的权限控制；前端页面使用Bootstrap构建，主题风格为时下Google最新设计语言Material Design，并提供多套配色以供选择。FEBS意指：Fast，Easy use，Beautiful和Safe。

注：精力有限，Oracle分支于2018年8月21日停止更新并删除，如有需要可到群里获取。
<!--more-->
### 功能模块
系统功能模块组成如下所示：
```
|-------------------------------------------|
|    ______ ______ ____   _____             |
|   |  ____|  ____|  _ \ / ____|            |
|   | |__  | |__  | |_) | (___              |
|   |  __| |  __| |  _ < \___ \             |
|   | |    | |____| |_) |____) |            |
|   |_|    |______|____/|_____/             |
|   Spring-Boot-Version: 2.0.4.RELEASE      |
|-------------------------------------------|
|
├─系统管理
│  ├─字典管理
│  ├─用户管理
│  ├─菜单管理
│  ├─角色管理
│  └─部门管理
├─系统监控
│  ├─在线用户
│  ├─系统日志
│  ├─Redis监控
│  └─Redis终端
│─网络资源
│  ├─One一个
│  │  ├─散文
│  │  ├─绘画
│  │  └─语文
│  ├─天气查询
│  ├─影视资讯
│  │  ├─即将上映
│  │  └─正在热映
│  └─每日一文
└─任务调度
   ├─定时任务
   └─调度日志
```
### 技术选型
#### 后端
- 基础框架：Spring Boot 2.0.4.RELEASE

- 持久层框架：Mybatis 3.4.5

- 安全框架：Apache Shiro 1.4.0

- 摸板引擎：Thymeleaf 3.0.9.RELEASE

- 数据库连接池：阿里巴巴Druid 1.1.10

- 缓存框架：Redis

- 日志打印：logback

- 其他：fastjson，poi，javacsv，quartz等。

#### 前端
 
- 基础框架：Bootstrap 4

- JavaScript框架：jQuery

- 消息组件：Bootstrap notify

- 提示框插件：SweetAlert2

- 树形插件：jsTree

- 树形表格插件：jqTreeGrid

- 表格插件：BootstrapTable

- 表单校验插件：jQuery-validate

- 多选下拉框插件：multiple-select

- 图表插件：Highcharts

- 时间插件：daterangepicker

#### 开发环境

- 语言：Java 8

- IDE：Eclipse Oxygen & IDEA 2018.1.4(Ultimate Edition)

- 依赖管理：Maven

- 数据库：MySQL5.7

- 版本管理：SVN，git

## 系统预览

![f47c1606680527619bc462afea4d068f.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/64420208.jpg)

![e3d9fc443686ec84003496d742c783ad.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/50183418.jpg)

![2911d8fa7bbe2b6674854a5c7f59de7a.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/57316459.jpg)

![48a18207aa79b0e75cfd7258d61dab1e.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/31072514.jpg)

![155af0ed234a7fe040666b1b7818d42e.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/38600911.jpg)

![57a6c25f7b616fcf4e452da673154960.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/5832650.jpg)

![d4973ba38ff475543eab95839b5314dc.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/99045302.jpg)

![](http://olwqftdzl.bkt.clouddn.com/18-6-29/66445963.jpg)

![](http://olwqftdzl.bkt.clouddn.com/18-6-29/18024225.jpg)

### 主题预览

![2bbae66a0cc36ea96ca1ffe66951921d.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/21305793.jpg)

![a9f57431583b8ed9a5d18b7cf37bd053.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/22217970.jpg)

![d8cb6313fd2ee8eb793d443b83a78ce4.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/6580523.jpg)

![2bd554ce2511cd1e7e3e7b3b56216ed6.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/86512301.jpg)

![5e6d35e4390cf7f0752d7864ad701e2b.png](http://olwqftdzl.bkt.clouddn.com/18-4-18/81830531.jpg)

### 开发与部署

码云地址： https://gitee.com/github-16661027/project 

GitHub 地址： https://github.com/wuyouzhuguli/FEBS

下载后以Maven项目的方式导入Eclipse或者IDEA。

开发时直接使用Spring Boot的入口类`cc.mrbird.Application`启动即可，访问地址[localhost:8080](localhost:8080)，账号mrbird，密码123456。

部署时，使用Maven将项目打包成febs.jar，然后使用命令`java -jar febs.jar`启动即可。在Linux下部署Spring Boot jar，并编写启停脚本可参考链接[https://mrbird.cc/Linux%20Spring-Boot-jar.html](https://mrbird.cc/Linux%20Spring-Boot-jar.html)。

### docker 支持
下载安装好 docker 后，用命令`docker run -d -p 5000:5000 registry` 拉取 registry镜像并运行，并执行`mvn clean package docker:build`命令即可将应用创建到私有个人docker registry中
` <dockerHost>http://<HOST yours >:2375</dockerHost>`  or `  set DOCKER_HOST=tcp://<HOST yours >:2375 `

### 关于配置文件切换问题以及数据库加密配置
#### 自定义`application.yml` 
由于本地开发所用数据库并不与项目默认配置数据库链接参数相同，所以可采用在`application.yml`文件中加入如下属性
```bash
spring
    profiles:
       active: local
``` 
然后在`application.yml`同级目录建立`application-local.yml`文件，里面可以自定义自己的数据库配置， 这样在spring boot启动时，优先加载 `local`配置文件里的属性配置。
`local`名称自定义。
#### jasypt 加密数据库用户名密码
在 `pom.xml`中引入
```xml
        <!-- jasypt-->
        <dependency>
            <groupId>com.github.ulisesbocchio</groupId>
            <artifactId>jasypt-spring-boot-starter</artifactId>
            <version>2.1.0</version>
        </dependency>
```
在`application.yml`或`application-local.yml`中配置用于加密的密码

```yaml
jasypt:
  encryptor:
    password: jyao
```
建立个util工具类：
```java_holder_method_tree
 public void jasyptTest() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("jyao");//application.yml配置的jasypt.encryptor.password
        String encrypted = encryptor.encrypt("root");//要加密的数据（数据库连接的用户名或密码）
        System.out.println(encrypted);
    }
```
把生成的密钥加上 ENC(密钥)，例如
```cmd
ENC(YiYjVwTulDGN//YaB3KbuA==) #明文root
以上替换原来的数据库用户名或密码

```
如图所示：
![jasypt_config](screenshots/jasypt_config.png)
![jasypt_config11](screenshots/Inkedjasypt_config_LI.jpg)
### 常见问题
[https://mrbird.cc/基于Spring Boot和Shiro的后台管理系统FEBS.html#常见问题](https://mrbird.cc/Spring-Boot%20Shiro%20FEBS.html)

### 反馈交流

对于想通过此项目来学习Spring Boot及Shiro的同学可以结合个人Spring Boot系列教程一起学习，效果更佳[https://github.com/wuyouzhuguli/Spring-Boot-Demos](https://github.com/wuyouzhuguli/Spring-Boot-Demos)。

此外，也欢迎加入Q群一起探讨交流。

![http://olwqftdzl.bkt.clouddn.com/18-3-23/40328650.jpg](http://olwqftdzl.bkt.clouddn.com/18-3-23/40328650.jpg)