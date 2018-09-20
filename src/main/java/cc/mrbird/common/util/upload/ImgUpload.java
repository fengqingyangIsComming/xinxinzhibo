package cc.mrbird.common.util.upload;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.UploadUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static cc.mrbird.common.util.upload.FtpUtil.uploadFile;

//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;

/**
 * @author Yxy
 * @date 2018/8/1 17:55
 */
@Controller
public class ImgUpload extends BaseController {
    @PostMapping(value = "imgUpload/upload")
    @ResponseBody
    public ResponseBo imgUpload(@RequestParam(required = false)MultipartFile file){

        try {

            String originalFilename = file.getOriginalFilename();//获取文件名

            String fileName = UploadUtils.subFileName(originalFilename);//获取真实的文件名
            String randonFileName = UploadUtils.generateRandonFileName(fileName);//生成随机的文件名
            String randomDir = UploadUtils.generateRandomDir(randonFileName);//生成一个二级目录

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte [] buf = null;

            Thumbnails.of(file.getInputStream()).size(100,100).toOutputStream(outputStream);//变为400*300,遵循原图比例缩或放到400*某个高度
            buf= outputStream.toByteArray();
            InputStream sbs = new ByteArrayInputStream( buf);

           boolean flag = uploadFile("45.250.42.254", 21, "ftpuser", "Gaimima..!!88", "",randomDir, randonFileName, sbs);

            String bigpic=null;
            String smallpic=null;
           if (file!=null){
                bigpic="http://fileup.ickapay.com/file"+randomDir+"/"+randonFileName;
                smallpic="http://fileup.ickapay.com/file"+randomDir+"/"+randonFileName;
            }
            return ResponseBo.ok(smallpic);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("图片上传失败，请联系网站管理员！");
        }
    }
}
