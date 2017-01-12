package com.nexters.shootingstar.db.dao;

import com.nexters.shootingstar.db.mapper.AccessTokenMapper;
import com.nexters.shootingstar.models.AccessToken;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

/**
 * Created by yoon on 2017. 1. 12..
 */
public interface AccessTokenDao extends Transactional<AccessTokenDao> {
    @SqlQuery("SELECT * FROM access_tokens WHERE email = :email")
    @Mapper(AccessTokenMapper.class)
    AccessToken findTokenByEmail(@Bind("email") String email);

    @SqlUpdate("INSERT INTO access_tokens (email, token) VALUES (:email, :token)")
    void create(@Bind("email") String email, @Bind("token") String token);
}
