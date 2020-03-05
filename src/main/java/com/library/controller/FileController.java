package com.library.controller;

import com.library.bean.AssignList;
import com.library.bean.ImageUpload;
import com.library.service.IImgUploadService;
import com.library.service.ImgService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Author: 周黎
 * @Date: 2019/11/6
 * @Description: com.library.controller
 * @version: 1.0
 */
@Controller
@MapperScan("com.library")
//@RestController
//@RequestMapping("/file")
public class FileController {
    private final ResourceLoader resourceLoader;
    private static final Logger logger = LoggerFactory.getLogger("FileController.class");

    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private IImgUploadService iImgUploadService;
    @Autowired
    private ImgService imgService;
    @Autowired
    private com.library.service.AssignListService AssignListService;

    /**
     * 跳转到文件上传页面
     *
     * @return
     */
    @RequestMapping("test")
    public String toUpload() {
        return "test";
    }

    @Value("${web.upload-path}")
    private String path;

    @Value("${server.port}")
    private String port;

    //要上传的文件
    @RequestMapping(value = {"/fileUpload"}, method = RequestMethod.POST)
    public @ResponseBody
    boolean upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, ImageUpload zip,AssignList assignList) {
        //获取上传文件名,包含后缀
        String fileName = file.getOriginalFilename();
        //获取后缀
//        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存的文件名
        UUID uuid = UUID.randomUUID();
        String dFileName = uuid + fileName;
        //保存路径
        //springboot 默认情况下只能加载 resource文件夹下静态资源文件
        String path = "D:/idea_woekspace_zl/library/src/main/resources/";//D:\idea_woekspace_zl\library\src\main\resources
        String filePath = request.getSession().getServletContext().getRealPath(path);

        File uploadFile = new File(path + dFileName);
        System.out.println(uploadFile);
        //将上传文件保存到路径
        ArrayList jpgList = new ArrayList();
        try {
            file.transferTo(uploadFile);//上传
            //uploadFile解压
            long start = System.currentTimeMillis();
            System.out.println("开始解压.............");
            // 判断源文件是否存在
            if (!uploadFile.exists()) {
                throw new RuntimeException(uploadFile.getPath() + "所指文件不存在");
            }
            // 开始解压
//            ZipFile filetmp = new ZipFile(uploadFile.toString());
            ZipFile zipFile = new ZipFile(uploadFile.toString());
            Enumeration<?> entries = zipFile.entries();
            try {
                int i = 0;
                while (entries.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    i++;//图片个数
                    System.out.println("解压+++++++++++++++++++++" + entry.getName() + "一共几张图片+++++++:" + i);
                    // 如果是文件夹，就创建个文件夹
                    if (entry.isDirectory()) {
                        String dirPath = path + uuid + "/" + entry.getName();
                        File dir = new File(dirPath);
                        dir.mkdirs();
                    } else {
                        // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                        File targetFile = new File(path + uuid + "/" + entry.getName());
//                        iImgUploadService.imgUpload(targetFile.toString());
                        // 保证这个文件的父文件夹必须要存在
                        if (!targetFile.getParentFile().exists()) {
                            targetFile.getParentFile().mkdirs();
                        }
                        targetFile.createNewFile();
                        // 将压缩文件内容写入到这个文件中
                        InputStream is = zipFile.getInputStream(entry);
                        FileOutputStream fos = new FileOutputStream(targetFile);
                        int len;
                        byte[] buf = new byte[120];
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0, len);
                        }
                        // 关流顺序，先打开的后关闭
                        fos.close();
                        is.close();
                        jpgList.add(targetFile.toString());
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("unzip error from ZipUtils", e);
            } finally {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jpgList.toString());
        zip.setImgpath(path+dFileName);
        zip.setSampleName("test01");
        zip.setPictureNumber(String.valueOf(jpgList.size()));
        zip.setCheckMember("guanguan");
        zip.setAcceptedList(jpgList.toString());

        assignList.setImgPath(path+dFileName);
        assignList.setSampleName("test02");
        assignList.setPictureNumber(String.valueOf(jpgList.size()));
        assignList.setCheckMember("guanguan");
        assignList.setAcceptedList(jpgList.toString());
//        return "上传" + dFileName + "成功请到上传路径查看!" + imgService.insertImg(zip);
        return AssignListService.insertAssign(assignList);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public Result downFile2(HttpServletRequest request, HttpServletResponse response) {
        //存储后文件名称
        String fileName = "myfile_"+System.currentTimeMillis()+".zip";
        if (fileName != null) {
            //获取当前路径下的文件
            //String realPath = "D:/idea_woekspace_zl/library/src/main/resources/-e3aa2f0e-7f84-44a3-a24b-2f743c94215d111.zip";
            String id = request.getParameter("");
            List<AssignList> list = AssignListService.getDownPath("70");
//            String realPath = list.get(0).getImgPath();
            String realPath = list.get(0).getImgPath();
//            AssignList tmp;
//            for(int i = 0;i< list.size();i++){
//                realPath = list.get(0).getImgPath();
////                System.out.println("==============="+realPath);
//            }
            File file = new File(realPath);
            //判断文件的对否存在
            if (file.exists()) {
                //设置强制下载，不打开
                response.setContentType("application/x-msdownload");
                //设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte[] bytes = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;

                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int b = bis.read(bytes);
                    while (b != -1) {
                        os.write(bytes, 0, b);
                        b = bis.read(bytes);
                    }
                    os.close();
                    return ResultUtil.success("下载成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return ResultUtil.success("下载失败！");
    }
}
