package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.FileMapper;
import com.ghs.server.pojo.Admin;
import com.ghs.server.pojo.File;
import com.ghs.server.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired FileMapper fileMapper;
    /**
     * 根据用户id获取文件
     * @return
     */
    @Override
    public List<File> getFilesByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return fileMapper.getFiles(adminId);
    }
}
