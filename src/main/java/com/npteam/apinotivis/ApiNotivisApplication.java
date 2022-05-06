package com.npteam.apinotivis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApiNotivisApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiNotivisApplication.class, args);
  }

}
