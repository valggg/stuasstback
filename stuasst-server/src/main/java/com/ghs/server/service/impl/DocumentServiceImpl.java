package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminDocumentMapper;
import com.ghs.server.mapper.DocumentMapper;
import com.ghs.server.pojo.*;
import com.ghs.server.service.IDocumentService;
import javassist.compiler.ast.Keyword;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements IDocumentService {

    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private AdminDocumentMapper adminDocumentMapper;

    /**
     * 根据用户id获取文件
     * @return
     */
    @Override
    public List<Document> getDocumentsByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return documentMapper.getDocuments(adminId);
    }

    /**
     * 根据用户id上传文件
     * @param url
     * @param name
     * @param info
     * @return
     */
    @Override
    public RespBean uploadDocument(String url,String name, FileInfo info) {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String size = decimalFormat.format((float)info.getFileSize()/1024/1024)+"MB";

        Document document = new Document();
        document.setName(name);
        document.setType(name.substring(name.lastIndexOf('.')));
        document.setPath(url);
        document.setSize(size);
        document.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getCreateTimestamp()));

        documentMapper.addDocument(document);

        if (1 == document.getResult()){
            AdminDocument adminDocument = new AdminDocument();
            adminDocument.setAdminId(adminId);
            adminDocument.setDid(document.getReId());
            adminDocumentMapper.insert(adminDocument);
            return RespBean.success("上传成功!");
        }else {
            return RespBean.error("上传失败!");
        }
    }

    /**
     * 分页获取所有文件
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public RespPageBean getDocumentByPage(Integer currentPage, Integer size,String keywords) {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Page<Document> page = new Page<>(currentPage, size);
        IPage<Document> documentIPage = documentMapper.getDocumentByPage(adminId,page, keywords);
        RespPageBean respPageBean = new RespPageBean(documentIPage.getTotal(), documentIPage.getRecords());
        return respPageBean;
    }
}
