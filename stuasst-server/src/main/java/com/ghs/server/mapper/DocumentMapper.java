package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ghs.server.pojo.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface DocumentMapper extends BaseMapper<Document> {

    /**
     * 通过用户id查询文件
     * @param adminId
     * @return
     */
    List<Document> getDocuments(Integer adminId);

    /**
     * 添加文件
     * @param document
     * @return
     */
    void addDocument(Document document);

    /**
     * 分页获取所有文件
     * @param adminId
     * @param page
     * @return
     */
    IPage<Document> getDocumentByPage(@Param("adminId") Integer adminId, Page<Document> page, @Param("keywords") String keywords);
}
