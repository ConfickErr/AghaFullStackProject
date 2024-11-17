package com.agha.comp_store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agha.comp_store.dto.ProducerCount;

@Repository
public class CustomComputerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProducerCount> getComputerCountByProducer() {
        String sql = "SELECT producer.name AS producer, COUNT(*) AS count " +
                "FROM comp_store.computer " +
                "INNER JOIN comp_store.producer ON computer.producer_id = producer.id " +
                "GROUP BY producer.name";

        return jdbcTemplate.query(sql, new RowMapper<ProducerCount>() {
            @Override
            public ProducerCount mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ProducerCount(rs.getString("producer"), rs.getInt("count"));
            }
        });
    }
}
