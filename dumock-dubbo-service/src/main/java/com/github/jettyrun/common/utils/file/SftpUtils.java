package com.github.jettyrun.common.utils.file;

import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.jcraft.jsch.*;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Properties;

public class SftpUtils {

    /**
     * 链接到sftp服务
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public static ChannelSftp connect(String host, int port, String username, String password)
            throws Exception {
        ChannelSftp sftp = null;
        JSch jsch = new JSch();
        jsch.getSession(username, host, port);
        Session sshSession = jsch.getSession(username, host, port);
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
        return sftp;
    }


    /**
     * 上传文件
     *
     * @param directory 上传的目录位置
     * @param uploadFile 要上传的文件
     * @param sftp
     */
    public static void upload(String directory, String uploadFile, ChannelSftp sftp)
            throws Exception {
        sftp.cd("/");
        mkDir(directory, sftp);
        InputStream in = null;
        try {
            sftp.cd(directory);
            File file = new File(uploadFile);
            in = new FileInputStream(file);
            sftp.put(new FileInputStream(file), file.getName());
        } finally {
            if (!ObjectUtils.isEmpty(in)) {
                in.close();
            }


        }
    }


    /**
     * 创建指定文件夹
     *
     * @param dirName dirName
     */
    public static void mkDir(String dirName, ChannelSftp sftp) throws Exception {
        String[] dirs = dirName.split("/");
        for (int i = 0; i < dirs.length; i++) {
            if (StringUtils.isNotEmpty(dirs[i])) {
                boolean dirExists = openDir(dirs[i], sftp);
                if (!dirExists) {
                    sftp.mkdir(dirs[i]);
                    sftp.cd(dirs[i]);
                }
            }
        }
    }


    /**
     * 打开指定目录
     *
     * @param directory directory
     * @return 是否打开目录
     */
    public static boolean openDir(String directory, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            return true;
        } catch (SftpException e) {
            return false;
        }
    }




    public static void delete(String path, boolean isDirectory, ChannelSftp sftp)
            throws SftpException {
        if (isDirectory) {
            sftp.rmdir(path);
        } else {
            sftp.rm(path);
        }
    }


    /**
     * sftp下载文件
     * @param directory 下载文件目录
     * @param fileName  文件名
     * @param destination   下载路径
     * @param sftp
     * @throws Exception
     */
    public static void download(String directory, String fileName, String destination,
                                ChannelSftp sftp) throws Exception {
        InputStream in = null;
        sftp.cd(directory);
        in = sftp.get(fileName);
        FileUtils.createDirectory(destination);
        File file = new File(FileUtils.getFileName(destination, fileName));
        FileUtils.inputstreamToFile(in, file);
    }

}

