package com.nexters.shootingstar.db.dao;

import com.nexters.shootingstar.db.mapper.UserMapper;
import com.nexters.shootingstar.models.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import java.util.Optional;

/**
 * Created by yoon on 2017. 1. 7..
 */
public interface UserDao extends Transactional<UserDao> {
    @SqlQuery("SELECT * FROM users WHERE email = :email")
    @Mapper(UserMapper.class)
    Optional<User> findUserByEmail(@Bind("email") String email);

    @SqlUpdate("INSERT INTO users (email) VALUES (:email)")
    void create(@Bind("email") String email);
}
