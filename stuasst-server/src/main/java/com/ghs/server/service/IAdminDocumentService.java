package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.AdminDocument;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
public interface IAdminDocumentService extends IService<AdminDocument> {

    /**
     * 通过tid删除用户-文件关系表
     * @param did
     */
    void delAdminDocumentByDid(Integer did);
}
