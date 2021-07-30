package com.example.springexamples;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class myRepository {

    private JdbcTemplate jdbcTemplate;

    public void performQueries(String untrusted) {
        String sql = "select * from db_table where col = ";
        Object[] args = {};
        int[] types = {};
        List<Object[]> batchArgs = new ArrayList<>();

        // With PreparedStatementSetter
        this.jdbcTemplate.query(sql + untrusted, (PreparedStatementSetter) null, (ResultSetExtractor<? extends Object>) null);
        this.jdbcTemplate.query(sql + untrusted, (PreparedStatementSetter) null, (RowMapper<? extends Object>) null);
        this.jdbcTemplate.query(sql + untrusted, (PreparedStatementSetter) null, (RowCallbackHandler) null);
        this.jdbcTemplate.queryForStream(sql + untrusted, (PreparedStatementSetter) null, (RowMapper<? extends Object>) null);
        this.jdbcTemplate.update(sql + untrusted, (PreparedStatementSetter) null);
        this.jdbcTemplate.batchUpdate(sql + untrusted, (BatchPreparedStatementSetter) null);
        this.jdbcTemplate.batchUpdate(sql + untrusted, null, 0, (ParameterizedPreparedStatementSetter<? extends Object>) null);

        // With StatementCallback
        this.jdbcTemplate.execute(sql + untrusted, (PreparedStatementCallback<? extends Object>) null);
        this.jdbcTemplate.execute(sql + untrusted, (CallableStatementCallback<? extends Object>) null);

        // With types array
        this.jdbcTemplate.query(sql+untrusted, args, types, (ResultSetExtractor<? extends List<Object>>) null);
        this.jdbcTemplate.query(sql+untrusted, args, types, (RowCallbackHandler) null);
        this.jdbcTemplate.query(sql+untrusted, args, types, (RowMapper<Object>) null);
        this.jdbcTemplate.queryForObject(sql+untrusted, args, types, (RowMapper<Object>) null);

        this.jdbcTemplate.queryForObject(sql+untrusted, args, types, (Class<? extends Object>) null);
        this.jdbcTemplate.queryForList(sql+untrusted, args, types, (Class<? extends Object>) null);

        this.jdbcTemplate.queryForMap(sql+untrusted, args, types);
        this.jdbcTemplate.queryForList(sql+untrusted, args, types);
        this.jdbcTemplate.queryForRowSet(sql+untrusted, args, types);
        this.jdbcTemplate.update(sql+untrusted, args, types);
        this.jdbcTemplate.batchUpdate(sql+untrusted, batchArgs, types);

        // Case when arguments can be appended
        this.jdbcTemplate.query(sql+untrusted, (ResultSetExtractor<? extends Object>) null);
        this.jdbcTemplate.query(sql+untrusted, (RowMapper<Object>) null);
        this.jdbcTemplate.query(sql+untrusted, (RowCallbackHandler) null);

        this.jdbcTemplate.queryForStream(sql+untrusted, (RowMapper<Object>) null);
        this.jdbcTemplate.queryForObject(sql+untrusted, (RowMapper<Object>) null);

        this.jdbcTemplate.queryForObject(sql+untrusted, (Class<? extends Object>) null);
        this.jdbcTemplate.queryForList(sql+untrusted, (Class<? extends Object>) null);

        // Single argument
        this.jdbcTemplate.queryForMap(sql+untrusted);
        this.jdbcTemplate.queryForList(sql+untrusted);
        this.jdbcTemplate.queryForRowSet(sql+untrusted);
        this.jdbcTemplate.update(sql+untrusted);
        this.jdbcTemplate.batchUpdate(sql+untrusted);

    }
}
