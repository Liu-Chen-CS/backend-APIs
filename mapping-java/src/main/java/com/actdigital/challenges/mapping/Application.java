package com.actdigital.challenges.mapping;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: Application
 * Package: com.actdigital.challenges.mapping
 * Description: To enable a spring boot project
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/1/2024 - 12:16 PM
 * @Version: v1.0
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args); // To create IOC container, enable tomcat
    }
}
