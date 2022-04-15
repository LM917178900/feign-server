feign server trouble record
1. 添加依赖后无法启动
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-openfeign-core</artifactId>
            <version>2.2.0.RELEASE</version>
        </dependency>
2. 添加的依赖正确，但还是无法启动
spring boot 版本也使用
<version>2.2.0.RELEASE</version>

3. 生成的包无法被调用
需要使用自定义打包配置
            <!-- 打包插件 -->
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <finalName>${project.build.finalName}</finalName>
                    <descriptors>
                        <descriptor>src/main/assembly/assembly.xml</descriptor>
                        <descriptor>src/main/assembly/upgrade-assembly.xml</descriptor>
                    </descriptors>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>install</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

4. 调用 feign 接口报错
默认 使用 post 方法；

5.  Service id not legal hostname (feign_server)
服务名称不能有下划线

6. url 命名需要如此
url = "${metadata.service.url}"

7. post api 无法传 json 
重写序列、反序列方法 WebMvcConfigurer

8.新增模块install 失败
repackage failed: Unable to find main class
去除打包插件 spring-boot-maven-plugin

9. feign 调用返回字符串有转义符；
实例：http://localhost:8083/consumer/get?label=hello,who are you
返回： "\"hello,who are you:,i am leimin\""


