package com.jnshu.task4.service.impl;

import com.jnshu.task4.common.bean.Career;
import com.jnshu.task4.common.utils.MemCachedManager;
import com.jnshu.task4.dao.CareerMapper;
import com.jnshu.task4.service.interfaces.ICareerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-20 17:59
 * @contact:938738637@qq.com
 **/
@Service
public class CareerServiceImpl implements ICareerService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    MemCachedManager memCachedManager;
    @Autowired
    CareerMapper careerMapper;
    @Override
    public Career selectCareerById(Integer id) {
        if (memCachedManager.get("career_"+id)==null) {
            Career career = careerMapper.selectByPrimaryKey(id);
            boolean b = memCachedManager.set("career_" + id, career);
            if (b==true) {
                logger.info("缓存写入成功");
                return (Career) memCachedManager.get("career_"+id);
            } else {
                logger.info("缓存写入失败");
                return career;
            }
        }
        return (Career) memCachedManager.get("career_"+id);
    }

    @Override
    public List<Career> selectALl() {

        if (memCachedManager.get("careers")==null) {
            List<Career> careers = careerMapper.selectAll();
            boolean b = memCachedManager.set("careers", careers);
            if (b==true) {
                logger.info("缓存写入成功");
                return (List<Career>) memCachedManager.get("careers");
            } else {
                logger.info("缓存写入失败");
                return careers;
            }
        }
        logger.info("缓存读取成功");
        return (List<Career>) memCachedManager.get("careers");
    }
}
