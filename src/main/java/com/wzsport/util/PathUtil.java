package com.wzsport.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kouga on 2017/8/19.
 */
public class PathUtil {
	public static final String HOST_NAME = "api.guangyangyundong.com";
	public static final String ORIGIN = "http://" + HOST_NAME;

	public static final String WEBSERVER_PATH = System.getProperty("catalina.base");
	public static final String WEBAPP_PATH  = WEBSERVER_PATH + File.separator +"webapps" + File.separator;

	public static final String IMG_FOLDER_PATH = "images" + File.separator;
	public static final String IMG_STORAGE_PATH = WEBAPP_PATH + File.separator + IMG_FOLDER_PATH + File.separator;

    /**
     * 获取到classes目录
     *
     * @return path
     */
    public static String getClassPath() {
        String systemName = System.getProperty("os.name");

        //判断当前环境，如果是Windows 要截取路径的第一个 '/'
        if (!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") != -1) {
            return PathUtil.class.getResource("/").getFile().toString().substring(1);
        } else {
            return PathUtil.class.getResource("/").getFile().toString();
        }
    }

    public static String getImagesPath() {
    	String path = PathUtil.getWebRootPath() + File.separator +"images";
    	return path;
    }

    /**
     * 获取到项目的路径
     *
     * @return path
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取 root目录
     *
     * @return path
     */
    public static String getWebRootPath() {
        File file = new File(getClassPath());
        File parent = file.getParentFile().getParentFile();
        return parent.getPath();
    }

    /**
     * 文本换行，因为Linux  和 Windows 的换行符不一样
     *
     * @return
     */
    public static String nextLine() {
        String nextLine = System.getProperty("line.separator");
        return nextLine;
    }

    /**
     * 获取images 路径
     *
     * @return
     */
    public static String getImagePath() {
        return getWebRootPath() + File.separator + "images" + File.separator;
    }


}
