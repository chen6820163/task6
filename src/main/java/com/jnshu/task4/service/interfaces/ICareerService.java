package com.jnshu.task4.service.interfaces;

import com.jnshu.task4.common.bean.Career;

import java.util.List;

public interface ICareerService {
    Career selectCareerById(Integer id);
    List<Career> selectALl();
}
