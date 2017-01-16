package com.nexters.shootingstar.db.mapper;

import com.nexters.shootingstar.models.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by yoon on 2017. 1. 16..
 */
public class UserMapper implements ResultSetMapper<Optional<User>> {
    @Override
    public Optional<User> map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return Optional.of(new User(r.getString("email")));
    }
}