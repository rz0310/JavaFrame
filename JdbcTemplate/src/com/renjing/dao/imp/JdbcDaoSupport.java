package com.renjing.dao.imp;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSouurce){
        if (jdbcTemplate == null) {
            createJdbcTemplate(dataSouurce);
        }
    }

    private void createJdbcTemplate(DataSource dataSouurce) {
        jdbcTemplate = new JdbcTemplate(dataSouurce);
    }
}
