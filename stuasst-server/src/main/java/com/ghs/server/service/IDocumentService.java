package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.Document;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.RespPageBean;
import org.csource.fastdfs.FileInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
public interface IDocumentService extends IService<Document> {

    /**
     * 根据用户id获取文件
     * @return
     */
    List<Document> getDocumentsByAdminId();


    /**
     * 根据用户id上传文件
     * @param url
     * @param name
     * @param info
     * @return
     */
    RespBean uploadDocument(String url, String name, FileInfo info);

    /**
     * 分页获取所有文件
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getDocumentByPage(Integer currentPage, Integer size, String keywords);
}
