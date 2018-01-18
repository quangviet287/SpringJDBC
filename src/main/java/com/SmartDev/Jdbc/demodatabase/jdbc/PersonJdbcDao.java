package com.SmartDev.Jdbc.demodatabase.jdbc;

import com.SmartDev.Jdbc.demodatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        //define rowmapper
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDay(resultSet.getTimestamp("birth_day"));
            return person;
        }
    }

    //select * from person
    public List<Person> findAll(){
      //  return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }
    //select from person where
    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] {id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }
    //delete from person where
    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
    }
    //insert
    public int insert(Person person){
        return jdbcTemplate.update("insert into person (id, name, location, birth_day) values (?,?,?,?)",
                new Object[] {person.getId(),person.getName(),person.getLocation(), new Timestamp(person.getBirthDay().getTime())} );
    }
    //update
    public int update(Person person){
        return jdbcTemplate.update("update person set name=?,location=?,birth_day=? where id=?",
                new Object[] {person.getName(),person.getLocation(), new Timestamp(person.getBirthDay().getTime()),person.getId()} );
    }
}
