package com.SmartDev.Jdbc.demodatabase;

import com.SmartDev.Jdbc.demodatabase.entity.Person;
import com.SmartDev.Jdbc.demodatabase.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//SpringBootApplication
public class JpaDatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //logger.info("User id 1001 -> {}", repository.findById(1001));
        logger.info("Insert id 1009 -> {}", repository.insert(new Person("Le Huy", "Da Nang", new Date())));
        logger.info("Insert id 1009 -> {}", repository.insert(new Person("Le Khang", "Da Nang", new Date())));
        //logger.info("Update id 1003 -> {}", repository.update(new Person(1003,"Viet Trinh","Da Nang", new Date())));
//        logger.info("Update id 1003 -> {}", repository.update(new Person(1009,"Viet Trinh","Quang Nam", new Date())));
        repository.deleteById(2);
        logger.info("All users -> {}", repository.findAll());
    }
}
