package com.chushi.study.mpj.mapper;


import com.chushi.study.mpj.pojo.TStudent;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 学生表(TStudent)表数据库访问层
 *
 * @author 初时
 * @since 2024-01-20 18:40:11
 */
@Repository
@Mapper
public interface TStudentMapper extends MPJBaseMapper<TStudent> {

}

