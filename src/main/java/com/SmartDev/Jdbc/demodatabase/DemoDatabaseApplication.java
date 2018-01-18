package com.SmartDev.Jdbc.demodatabase;

import com.SmartDev.Jdbc.demodatabase.entity.Person;
import com.SmartDev.Jdbc.demodatabase.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
public class DemoDatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {
        SpringApplication.run(DemoDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 1001 -> {}", dao.findById(1001));
        logger.info("Delete id 1002 -> No of rows deleted - {}", dao.deleteById(1002));
        logger.info("Insert id 1005 -> {}", dao.insert(new Person(1006, "Diem", "Da Nang", new Date())));
        logger.info("Update id 1001 -> {}", dao.update(new Person(1003, "Quang Viet", "Quang Nam", new Date())));
        logger.info("Insert id 1007 -> {}", dao.insert(new Person(1007, "Linh", "Da Nang", new Date())));
        logger.info("Update id 1005 -> {}", dao.update(new Person(1005, "Viet", "Quang Nam", new Date())));
    }
}
