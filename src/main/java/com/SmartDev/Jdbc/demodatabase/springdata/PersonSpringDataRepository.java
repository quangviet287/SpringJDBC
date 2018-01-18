package com.SmartDev.Jdbc.demodatabase.springdata;

import com.SmartDev.Jdbc.demodatabase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.name = :name and p.location = :location")
    List<Person> getPerson(@Param("name") String name, @Param("location") String location);

}
