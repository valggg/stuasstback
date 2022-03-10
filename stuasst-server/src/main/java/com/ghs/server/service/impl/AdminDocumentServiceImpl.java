package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminDocumentMapper;
import com.ghs.server.pojo.AdminDocument;
import com.ghs.server.service.IAdminDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@Service
public class AdminDocumentServiceImpl extends ServiceImpl<AdminDocumentMapper, AdminDocument> implements IAdminDocumentService {


    @Autowired
    private AdminDocumentMapper adminDocumentMapper;

    @Override
    public void delAdminDocumentByDid(Integer did) {
        adminDocumentMapper.delAdminDocumentByDid(did);
    }
}
