package com.linging.controller;


import com.linging.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileController {

    /**
     * 同步文件一个上传和异步上传一个文件，共同使用这一个控制器方法
     * @param request
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/testUpload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile upload) throws IOException {
        //获取文件的保存路径
        String path = request.getServletContext().getRealPath("/uploads");
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //获取随机字符串
        String prefix = UUID.randomUUID().toString().replaceAll("-", "");
        filename = prefix + "_" + filename;
        //创建文件对象
        File file = new File(path);
        //判断路径是否存在，不存在则创建
        if(!file.exists()){
            file.mkdir();
        }
        //上传文件
        upload.transferTo(new File(file,filename));
        return "success";
    }



    /**
     * 异步文件上传和表单数据
     * @param request
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/testUpload2",method = RequestMethod.POST)
    public @ResponseBody Account upload2(HttpServletRequest request, MultipartFile upload, Account account) throws IOException {
        //获取文件的保存路径
        String path = request.getServletContext().getRealPath("/uploads");
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //获取随机字符串
        String prefix = UUID.randomUUID().toString().replaceAll("-", "");
        filename = prefix + "_" + filename;
        //创建文件对象
        File file = new File(path);
        //判断路径是否存在，不存在则创建
        if(!file.exists()){
            file.mkdir();
        }
        //上传文件
        upload.transferTo(new File(file,filename));
        return account;
    }


    /**
     * 异步多个文件上传和表单数据
     * @param request
     * @param upload 采用数组接收
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/testUpload3",method = RequestMethod.POST)
    public @ResponseBody Account upload3(HttpServletRequest request, MultipartFile[] upload, Account account) throws IOException {
        //获取文件的保存路径
        String path = request.getServletContext().getRealPath("/uploads");
        //创建文件对象
        File file = new File(path);
        //判断路径是否存在，不存在则创建
        if(!file.exists()){
            file.mkdir();
        }

        for (MultipartFile multipartFile : upload) {
            //获取上传文件的名称
            String filename = multipartFile.getOriginalFilename();
            //获取随机字符串
            String prefix = UUID.randomUUID().toString().replaceAll("-", "");
            filename = prefix + "_" + filename;
            //上传文件
            multipartFile.transferTo(new File(file,filename));
        }
        return account;
    }


}
