package com.oliver.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

/**
 * Created by ning on 6/15/16.
 */
public class HadoopTest {
        public static void main(String[] args) throws Exception {
            String uri = "hdfs://localhost:9000/";
            Configuration config = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(uri), config);

            // 列出hdfs上/user/ning/目录下的所有文件和目录
            FileStatus[] statuses = fs.listStatus(new Path("/user/ning/"));
            for (FileStatus status : statuses) {
                System.out.println(status);
            }

            // 在hdfs的/test/目录下创建一个文件，并写入一行文本
            FSDataOutputStream os = fs.create(new Path("/test/hadoop.log"));
            os.write("开启我的Hadoop之旅".getBytes());
            os.flush();
            os.close();

            // 显示在hdfs的指定文件的内容
            InputStream is = fs.open(new Path("/test/hadoop.log"));
            IOUtils.copyBytes(is, System.out, 1024, true);
        }


}
