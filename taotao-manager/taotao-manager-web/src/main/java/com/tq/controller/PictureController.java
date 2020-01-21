package com.tq.controller;
import com.tq.service.PictureService;
import com.tq.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 上传图片处理
 * 图片服务器搭建失败。。。。。。。
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) {
        Map result = pictureService.uploadPicture(uploadFile);
        //为保证功能的兼容性，需要把result转换成json格式的字符串
        String jsonResult = JsonUtils.objectToJson(result);
        return jsonResult;
    }

}