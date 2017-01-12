package com.nexters.shootingstar.db.mapper;

import com.nexters.shootingstar.models.AccessToken;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoon on 2017. 1. 12..
 */
public class AccessTokenMapper implements ResultSetMapper<AccessToken> {
    @Override
    public AccessToken map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new AccessToken(r.getString("email"), r.getString("token"));
    }
}
