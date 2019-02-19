package com.chang.controller;

import com.google.common.collect.ImmutableBiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 文件上传的接口
 * Created by ANdady on 2019/2/15.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private final static String lantern_img_path = "/attachment/";

    /**
     * 上传灯谜图片(题目图片)
     *
     * @param file 图片文件
     * @return {Map} 返回数据
     */
    @PostMapping(value = "/lantern_image")
    public Map<String, String> lanternImageUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        Map<String, String> result; //返回结果

        try {
            String filename = System.currentTimeMillis() + ".jpg"; //自定义文件名

            File path = new File(request.getSession().getServletContext().getRealPath("/attachment/"));
            if (!path.exists())
                path.mkdir();

            File lanternImage = new File(path, filename);
            file.transferTo(lanternImage); //文件传输

            logger.info("灯谜图片上传成功 filepath: {}", lanternImage.getPath());
            result = ImmutableBiMap.of("code", "1", "msg", "上传成功", "filename", filename);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            result = ImmutableBiMap.of("code", "-1", "msg", e.getMessage());
        } catch (IOException | IllegalStateException e) {
            logger.error(e.getMessage(), e);
            return ImmutableBiMap.of("code", "-1", "msg", "上传文件出错 " + e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = ImmutableBiMap.of("code", "-2", "msg", "上传图片异常 throw new Exception");
        }

        return result;
    }
}
