package com.zhu.blog.controller;

import com.zhu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

   /* @Autowired
    private QiniuUtils qiniuUtils;*/
    @Value("${file.upload-dir}")
    private String uploadPath;
    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return Result.fail(999,"文件为空");

        }

        try {
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 获取文件扩展名
            String newFileName = UUID.randomUUID().toString() + fileExtension; // 生成唯一文件名
            File destDir = new File(uploadPath);
            if (!destDir.exists()) {
                destDir.mkdirs(); // 创建目录及其父目录
            }
            File dest = new File(uploadPath + File.separator + newFileName);
            file.transferTo(dest);

            // 构建文件的相对路径（可根据需要修改为绝对路径）
            String relativeFilePath = "http://111.229.247.36/static/images/" + newFileName;

            // 返回文件的路径给前端
            return Result.success(relativeFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(999,"文件上传出错");
        }
    }


}
