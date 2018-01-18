package com.SmartDev.Jdbc.demodatabase;

import com.SmartDev.Jdbc.demodatabase.entity.Person;
import com.SmartDev.Jdbc.demodatabase.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringDataDemo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Insert id 1 -> {}", repository.save(new Person("Le Khang Huy", "Da Nang", new Date())));
        /*logger.info("Update id 2 -> {}", repository.save(new Person("Le Khang","Da Nang", new Date())));
        repository.deleteById(2);
        logger.info("All users -> {}", repository.findAll());*/
        logger.info("List {}",repository.getPerson("Le Khang Huy","Da Nang"));
    }
}
