package cn.mrcsh.Util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class OSSUtil {
    public static final String ALI_DOMAIN = "https://csh-test1.oss-cn-beijing.aliyuncs.com/";

    public static String uploadImage(MultipartFile file) throws IOException {
        // 生成文件名
        String originalFilename = file.getOriginalFilename();
        String ext = "."+ FilenameUtils.getExtension(originalFilename); // 后缀
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String fileName = uuid+ext;
        // 地域节点
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5tSBckxE55TNAunCkNdv";
        String accessKeySecret = "4VJ2wIDYecCd7VNolmiLb3F9rysQNy";
        // OSS 客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(
                "csh-test1",
                fileName,
                file.getInputStream()
        );
        ossClient.shutdown();
        return ALI_DOMAIN+fileName;
    }


}