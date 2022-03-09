package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.File;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
public interface IFileService extends IService<File> {

    /**
     * 根据用户id获取文件
     * @return
     */
    List<File> getFilesByAdminId();
}
