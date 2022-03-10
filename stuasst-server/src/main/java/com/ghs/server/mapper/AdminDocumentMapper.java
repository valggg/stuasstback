package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.AdminDocument;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@Mapper
public interface AdminDocumentMapper extends BaseMapper<AdminDocument> {

    void delAdminDocumentByDid(Integer did);
}
