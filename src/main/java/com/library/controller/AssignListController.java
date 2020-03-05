package com.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.bean.*;
import com.library.service.*;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/5
 * @Description: com.library.controller
 * 分派图片
 * @version: 1.0
 */

@RestController
@RequestMapping("/api/v1.0/pic")
public class AssignListController {
    @Autowired
    AssignListService AssignListService;

    @Autowired
    PlotSizeService plotSizeService;

    @Autowired
    PlotService plotService;

    @Autowired
    private IImgUploadService iImgUploadService;

    //查询任务分页信息
    @RequestMapping(value = "/pictureManagement", method = RequestMethod.GET)
    public Result<AssignList> AssignList() {
        System.out.println("开始查询.........");
        public static Logger logger = Logger.getLogger("AssignListController.class");
        int filterCount = AssignListService.countAllList();
        return ResultUtil.pagesuccess(AssignListService.AssignList(), filterCount);
    }


    //标图人员任务查询
    @RequestMapping(value = "/pictureManagement", method = RequestMethod.GET, params = {"checkMember"})
    public Result<PageInfo> accountAssignList(HttpServletRequest request) {
        String checkMember = request.getParameter("checkMember");
        return ResultUtil.success(AssignListService.accountAssignList(checkMember));
    }
    //http://localhost:8080/api/dl/v1/sample/pictureManagement?checkMember=1&currentPage=2&pageSize=2

    //根据任务ID uapId 删除图片
    @RequestMapping(value = "/pictureManagement", method = RequestMethod.DELETE)
    public Result deletePicture(@RequestBody Plot plot) {
        String uapId = plot.getUapId();

        List list = plotService.picList(uapId);
        for (int i = 0; i < list.size(); i++) {
            PlotSize plotSize = new PlotSize();
            HashMap mapPlotSize = (HashMap) list.get(i);
            int uardId = (int) mapPlotSize.get("uardId");
            plotSize.setUardId(uardId);
            plotSizeService.deletePicture(plotSize);
        }
        return ResultUtil.success(plotService.deleteUapId(plot));
    }

//    //根据图片ID uardId 删除图片
//    @RequestMapping(value = "/pictureManagement", method = RequestMethod.DELETE, params = {"uardId"})
//    public Result deletePicture(@RequestBody PlotSize plotSize) {
//        return ResultUtil.success(plotSizeService.deletePicture(plotSize));
//    }


    //插入样本库数据
    /*
     * {"sampleName":"输电线路/五种类型，备份/相序牌	","checkMember":"zhouli",
     * "pictureNumber":20,"acceptedList":"null"}
     *
     * {"sampleName":"001","checkMember":"admin","pictureNumber":"2","acceptedList":"[D:\idea_woekspace_zl\library\src\main\resources\c210378c-12bc-4e57-981b-87e685b4d877\111.jpg, D:\idea_woekspace_zl\library\src\main\resources\c210378c-12bc-4e57-981b-87e685b4d877\222.png]"}

     * */
    //
    @RequestMapping(value = "/pictureManagement", method = RequestMethod.POST)
    public Result createPictureLibrary(@RequestParam("file") MultipartFile file,
                                       HttpServletRequest request, AssignList assignList) {
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
            Charset gbk = Charset.forName("GBK");
            ZipFile zipFile = new ZipFile(uploadFile.toString(), gbk);
            Enumeration<?> entries = zipFile.entries();
            try {
                int i = 0;
                while (entries.hasMoreElements()) {
                    i++;
                    ZipEntry entry = (ZipEntry) entries.nextElement();
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
                        jpgList.add(targetFile.toString());

                        //新增图片
                        String picPth = targetFile.toString();
                        Picture picture = new Picture();//图片对象
                        picture.setFileName(picPth);
                        picture.setFinalPicturePath(picPth);
                        picture.setPicturePath(picPth);
                        picture.setThumbnailPath(picPth);
                        picture.setCheckMember(assignList.getCheckMember());
//                        picture.setUapId(assignList.getId());
                        picture.setPlotData("");
//                        picture.setStatus("1");//未标注
                        picture.setUuid(uuid.toString());
                        AssignListService.insertPicture(picture);
                        // 关流顺序，先打开的后关闭
                        fos.close();
                        is.close();

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
//        UUID uardid = UUID.randomUUID();
        System.out.println(jpgList.toString());
        assignList.setImgPath(path + dFileName);
        assignList.setSampleName(assignList.getSampleName());
        assignList.setPictureNumber(String.valueOf(jpgList.size()));
        assignList.setCheckMember(assignList.getCheckMember());
        assignList.setAcceptedList(jpgList.toString());
        assignList.setUuid(uuid.toString());
//        return "上传" + dFileName + "成功请到上传路径查看!" + imgService.insertImg(zip);
        return ResultUtil.success(AssignListService.insertAssign(assignList));
    }

    //    @RequestMapping(value = "/download", method = RequestMethod.GET, params = {"id"})
    @GetMapping(value = "/download/{id}")

    public String downFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        //存储后文件名称
        String fileName = "myfile_" + System.currentTimeMillis() + ".zip";
        if (fileName != null) {
            //获取当前路径下的文件
            //String realPath = "D:/idea_woekspace_zl/library/src/main/resources/-e3aa2f0e-7f84-44a3-a24b-2f743c94215d111.zip";
//            String id = request.getParameter("");
            List<AssignList> list = AssignListService.getDownPath(id);
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
//                    return ResultUtil.success("下载成功！");
                    return "下载成功";
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
//        return ResultUtil.success("下载失败！");
        return "下载失败！";
    }
}
