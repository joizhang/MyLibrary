package com.joizhang.mylibrary.utils;

import java.io.File;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/5/4.
 */
public class FileUtils {

    /**
     * 目录不存在的情况下，创建目录。
     * @param filePath 文件目录
     * */
    public void creatFolder(String filePath) {
        File fp = new File(filePath);
        // 创建目录
        if (!fp.exists()) {
            fp.mkdirs();
        }
    }

    /**
     * 创建目录修改名称
     * @param targetFile
     * */
    public void creatBakFileForSingle(String bakFolder, String updatedname, File targetFile) {
        int year, month, day, hour, minute, second;
        // 文件重命名
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR);
        minute = cal.get(Calendar.MINUTE);
        second = cal.get(Calendar.SECOND);

        String str_y = String.valueOf(year);
        String str_m = String.valueOf(month + 1);
        String str_d = String.valueOf(day);
        String str_h = String.valueOf(hour);
        String str_mi = String.valueOf(minute);
        String str_s = String.valueOf(second);

        bakFolder = bakFolder + str_y + "\\" + str_m + str_d + "\\";
        creatFolder(bakFolder);
        String ext = updatedname.substring(updatedname.indexOf("."), updatedname.length());
        String fileName = updatedname.substring(0, updatedname.indexOf("."));
        updatedname = fileName + "_" + str_h + str_mi + str_s + ext;
        //System.out.println(bakFolder+" "+updatedname);
        targetFile.renameTo(new File(bakFolder, updatedname));
    }
}
