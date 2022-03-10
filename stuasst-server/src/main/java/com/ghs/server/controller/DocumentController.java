package com.ghs.server.controller;



import com.ghs.server.pojo.Document;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.RespPageBean;
import com.ghs.server.service.IAdminDocumentService;
import com.ghs.server.service.IDocumentService;
import com.ghs.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiOperation;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private IDocumentService documentService;
    @Autowired
    private IAdminDocumentService adminDocumentService;

    @ApiOperation(value = "通过用户id查询文件")
    @GetMapping("/documentList")
    public List<Document> getDocumentsByAdminId() {
        return documentService.getDocumentsByAdminId();
    }

    @ApiOperation(value = "分页获取所有文件")
    @GetMapping("/")
    public RespPageBean getDocumentByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "10") Integer size) {
        return documentService.getDocumentByPage(currentPage, size);
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("/upload")
    public RespBean uploadDocument(MultipartFile file) {
        String[] filePath = FastDFSUtils.upload(file);
        String url = FastDFSUtils.getTrackerUrl() + filePath[0] + "/" + filePath[1];
        FileInfo info = FastDFSUtils.getFileInfo(filePath[0], filePath[1]);
        String name = file.getOriginalFilename();
        return documentService.uploadDocument(url, name, info);
    }

    @ApiOperation(value = "删除文件")
    @DeleteMapping("/{id}")
    public RespBean deleteDocument(@PathVariable Integer id) {
        String path = documentService.getById(id).getPath();

        String[] pathStr = path.split("/");
        String groupName = pathStr[3];
        String remoteFileName = path.substring(pathStr[0].length() + pathStr[1].length() + pathStr[2].length() + pathStr[3].length() + 4);

        if (documentService.removeById(id)) {
            adminDocumentService.delAdminDocumentByDid(id);
            FastDFSUtils.deletedFile(groupName, remoteFileName);
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除文件")
    @DeleteMapping("/")
    public RespBean deleteTalliesByIds(Integer[] ids) {
        if(documentService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除文件成功！");
        }
        return RespBean.error("批量删除文件 失败，请稍后再试！");
    }

    @ApiOperation(value = "下载文件")
    @GetMapping("/{id}")
    public RespBean downLoadDocument(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
        String path = documentService.getById(id).getPath();
//        response.setHeader("Content-Type", "application/octet-stream");
//        response.setHeader("Content-Disposition","attachment;filename="+path);
        return null;
    }
}