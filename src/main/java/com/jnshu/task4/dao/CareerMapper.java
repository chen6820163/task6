package com.jnshu.task4.dao;

import com.jnshu.task4.common.bean.Career;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerMapper {

    Career selectByPrimaryKey(Integer id);
    List<Career> selectAll();
}