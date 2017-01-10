package com.nexters.shootingstar.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by yoon on 2017. 1. 9..
 */
public interface SqlDao {
    @SqlUpdate("insert into :something :field values :value where id = :id")
    void insert(@Bind("something") String table_name,
                @Bind("field") String field_name,
                @Bind("value") String value,
                @Bind("id") int id);

    @SqlQuery("select :field from :something where id = :id")
    String findNameById(@Bind("something") String table_name,
                        @Bind("field") String field_name,
                        @Bind("id") int id);
}
