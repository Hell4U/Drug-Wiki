package com.promition.drugwiki;

import com.promition.drugwiki.entity.User;
import com.promition.drugwiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrugWikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugWikiApplication.class, args);

    }

}
