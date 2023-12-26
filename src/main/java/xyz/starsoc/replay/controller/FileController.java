package xyz.starsoc.replay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thciwei.x.file.storage.core.FileInfo;
import org.thciwei.x.file.storage.core.FileStorageService;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;//注入实列

    /**
     * 上传文件
     * @param file  文件
     * @param fileType  文件类型
     * @return 上传结果
     */
    @PostMapping("/upload/{fileType}")
    public String upload(MultipartFile file,
                                 Long username,
                                 @PathVariable String fileType) {
        // 调用文件存储服务，上传文件
        FileInfo fileInfo = fileStorageService.of(file)
                .setPath(fileType + "/") // 保存到相对路径下，为了方便管理，不需要可以不写
                .setObjectId(username)   // 关联对象ID，为了方便管理，不需要可以不写
                .upload(); // 将文件上传到对应地方

        // 返回上传结果
        return fileInfo == null ? "上传失败！" : fileInfo.getUrl();
    }

}
