package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {

    /**
     * 通过用户id查询文件
     * @param adminId
     * @return
     */
    List<File> getFiles(Integer adminId);
}
