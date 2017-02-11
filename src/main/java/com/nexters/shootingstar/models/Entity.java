package com.nexters.shootingstar.models;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
public interface Entity {
    default String getEntityName(){
        return this.getClass().getSimpleName();
    }
}