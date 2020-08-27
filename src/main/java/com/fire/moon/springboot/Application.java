package com.fire.moon.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing // JPA Auditing 활성화 -> config.JpaConfig 로 이동
@SpringBootApplication
public class Application { public static void main(String[] args) { SpringApplication.run(Application.class, args); } }
