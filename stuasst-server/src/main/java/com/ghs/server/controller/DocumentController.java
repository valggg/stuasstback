package com.ghs.server.controller;



import com.ghs.server.pojo.*;
import com.ghs.server.service.IAdminDocumentService;
import com.ghs.server.service.IDocumentService;
import com.ghs.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiOperation;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
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
                                       @RequestParam(defaultValue = "10") Integer size,
                                          @RequestParam  String keywords) {
        return documentService.getDocumentByPage(currentPage, size, keywords);
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
    public RespBean deleteTalliesByIds(Integer[] ids){
        String path;
        String[] pathStr;
        String groupName;
        String remoteFileName;

        for (int i = 0;i <= ids.length-1;i++){
            path = documentService.getById(ids[i]).getPath();
            pathStr = path.split("/");
            groupName = pathStr[3];
            remoteFileName = path.substring(pathStr[0].length() + pathStr[1].length() + pathStr[2].length() + pathStr[3].length() + 4);
            adminDocumentService.delAdminDocumentByDid(ids[i]);
            FastDFSUtils.deletedFile(groupName, remoteFileName);
        }

        if(documentService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除文件成功！");
        }

        return RespBean.error("批量删除文件 失败，请稍后再试！");
    }

    @ApiOperation(value = "下载文件")
    @GetMapping(value = "/download/{id}",produces = "application/octet-stream")
    public void downLoadDocument(@PathVariable Integer id,HttpServletResponse response) throws IOException {
        Document document = documentService.getById(id);
        String path = document.getPath();
        String name = document.getName();
        String[] pathStr = path.split("/");
        String groupName = pathStr[3];
        String remoteFileName = path.substring(pathStr[0].length() + pathStr[1].length() + pathStr[2].length() + pathStr[3].length() + 4);

        ServletOutputStream outputStream = null;
        InputStream inputStream = FastDFSUtils.downFile(groupName,remoteFileName);;

        try {
            // 流形式
            response.setHeader("content-type", "application/octet-stream");
            // 防止中文乱码
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
            outputStream = response.getOutputStream();

            int n;
            while ((n = inputStream.read()) != -1) { // 读取到缓冲区
                outputStream.write(n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }
}