local
=====
											使用Maven构建的SpringMVC+Hibernate框架
	1、框架简介
		1）、搭建之初：最初怀着学习的心态使用Maven构建一个框架。于是趁着国庆放假，用三天时间搭建这个SpringMVC+Hibernate框架，并实现基于log4j的日志记录功能。
		2）、搭建过程：学习使用Maven；
					搭建SpringMVC+Hibernate；
					基于log4j的日志记录功能实现。
		3）、感触：学习使用Maven搭建SpringMVC+Hibernate框架并不难，归功于开源带来的遍历，时间主要集中在log4j日志记录功能上。
		4）、源码说明：源码文件编码格式为 UTF-8
		5）、项目首页：http://127.0.0.1:8080/common
		6）、部分文件介绍（详细参见文件内部注释）：
			[1]dao（数据连接层）
				src/main/java/com/rogue/frame/common/dao/CommonDao.java 通用数据连接层(DAO)接口, 放置一些常用的数据库操作方法 可以继承该接口来扩展自己的DAO
				src/main/java/com/rogue/frame/common/dao/impl/CommonDaoImpl.java 通用数据连接层(DAO)实现类, 放置一些常用的数据库操作方法的具体实现  可以继承该实现类来扩展自己的DAO实现
			[2]dynamicDataSource（动态切换数据源）
				src/main/java/com/rogue/frame/dynamicDataSource/DataSourceConstant.java 数据源常量类，放置与动态切换数据源相关的一些常量
				src/main/java/com/rogue/frame/dynamicDataSource/DataSourceContextHolder.java 数据源上下文句柄，通过setDataSourceType方法设置数据源
				src/main/java/com/rogue/frame/dynamicDataSource/DynamicDataSource.java 继承AbstractRoutingDataSource 实现determineCurrentLookupKey方法
				src/main/java/com/rogue/frame/dynamicDataSource/DynamicDataSourceAspect.java 基于Spring Aop，根据具体的境况通过DataSourceContextHolder.setDataSourceType(dataSourceType) 切换数据源，也可以直接在需要切换数据源的代码中使用DataSourceContextHolder的setDataSourceType方法
			[3]filter（过滤器）
				src/main/java/com/rogue/frame/filter/HttpSessionFilter.java 过滤器(Filter)
			[4]log（日志）
				src/main/java/com/rogue/frame/log/Log4jEventEvaluator.java  Log4j的SMTP的级别默认是ERROR级别 ，默认是ERROR级别，那就是说，只有程序出错了，才可以收到邮件。不过可以自定义的级别，实现TriggeringEventEvaluator接口
				src/main/java/com/rogue/frame/log/Log4jHTMLLayOut.java 自定义log4j的layout参数
				src/main/java/com/rogue/frame/log/Log4jIMSMTPAppender.java log4j发送邮件时需要用到的自定义SMTPAppender 
				src/main/java/com/rogue/frame/log/LogInterceptor.java 基于Spring Aop，使用log4j实现日志记录
				src/main/resources/log4j.properties log4j配置文件
			[5]test（测试）
				src/test/java/com/rogue/business/login/LoginController.java 测试用的系统登录部分的前端控制器
				src/test/java/com/rogue/module/SysUser.java 测试用的描述系统用户的实体类
			[6]WEB-INF
    			src/main/webapp/WEB-INF/web.xml web项目配置文件
    			src/main/webapp/WEB-INF/springMVC-servlet.xml SpringMVC配置文件（其中配置两项重要的MVC特性）
    			src/main/webapp/WEB-INF/applicationContext.xml Spring容器配置文件（这里可以初始化一些bean）
    		[7]maven
    			pom.xml maven配置文件（比如在其中配置项目依赖的jar包）
	2、附：Maven项目标准目录结构：
		src
			-main
				–bin 脚本库
		      	–java java源代码文件
		      	–resources 资源库，会自动复制到classes目录里
		      	–filters 资源过滤文件
		      	–assembly 组件的描述配置（如何打包）
		      	–config 配置文件
		      	–webapp web应用的目录。WEB-INF、css、js等
		  	-test
		       	–java 单元测试java源代码文件
		      	–resources 测试需要用的资源库
		      	–filters 测试资源过滤库
		  	-site Site（一些文档）
		target
		 	LICENSE.txt Project’s license
		 	README.txt Project’s readme
		
		工程根目录下就只有src和target两个目录
		target是有存放项目构建后的文件和目录，jar包、war包、编译的class文件等。
		target里的所有内容都是maven构建的时候生成的
	3、现将此框架交由GitHub管理。此文件主要是为了记录项目整体工作日志。若有改动请在这里留下你的痕迹。在此感谢GitHub，感谢开源。
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

