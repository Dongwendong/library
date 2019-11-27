package edu.nf.library.util;

import java.io.*;
import java.util.UUID;

/**
 * @author dwd
 * @date 2019/11/21
 */
public class FilesUploadUtil {
    public static void createUploadDir(String uploadPath){
        //构建上传目录
        File uploadDir = new File(uploadPath);
        //如果不存在此目录则创建
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }
    }

    public static File createUploadFile(String uploadPath, String fileName){
        //构建一个完整的文件上传对象
        File uploadFile = new File(uploadPath + File.separator + fileName);
        return uploadFile;
    }

    public static String newFileName(String old){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String[] split = old.split("\\.");
        if(split.length > 1){
            String ext = split[split.length - 1];
            return uuid + "." + ext;
        }
        return uuid;
    }
    public static void  copyFile(String srcPath, String destPath) throws IOException {
        //打开输入流；
        FileInputStream fis= new FileInputStream(srcPath);
        //打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        int len=0;
        byte[]bytes=new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}