package com.relax.www.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;

/**
 * @ClassName: FileSystemTest
 * @Description: TODO(hadoop hdfs 文件操作类)
 * @author no_relax
 * @date 2016年9月23日 下午2:44:16
 * 
 */
public class FileSystemTest {
	private static FileSystem fileSystem;
	static {
		// 加载配置文件
		Configuration config = new Configuration();
		// 配置副本数量为1
		config.set("dfs.replication", "1");
		// 配置hdfs的节点地址
		config.set("fs.defaultFS", "hdfs://hadoop01:9000");
		try {
			fileSystem = FileSystem.get(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test // 上传文件
	public void uploadFile() throws IllegalArgumentException, IOException {
		FileInputStream in = new FileInputStream(new File("C:/Users/wusong/Desktop/工作图.png"));
		FSDataOutputStream out = fileSystem.create(new Path("/工作图.png"));
		IOUtils.copy(in, out);
	}

	@Test // 另外一种文件上传方法
	public void uploadFileSimple() throws IllegalArgumentException, IOException {
		fileSystem.copyFromLocalFile(new Path("C:/Users/wusong/Desktop/SQL语句.sql"), new Path("/backup/SQL语句.png"));
	}

	@Test // 下载文件
	public void downloadFile() throws IllegalArgumentException, IOException {
		// HDFS file
		FSDataInputStream is = fileSystem.open(new Path("/工作图.png"));
		// local file
		OutputStream os = new FileOutputStream(new File("C:/Users/wusong/Desktop/hadoop1.png"));
		IOUtils.copy(is, os);
	}

	@Test // 另外一种文件上传方法
	public void downloadFileSimple() throws IllegalArgumentException, IOException {
		fileSystem.copyToLocalFile(new Path("/工作图.png"), new Path("/home/hadoop/hadoop1.png"));
	}

	@Test//罗列所有的文件
	public void listFiles() throws Exception {
		RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/"), true);
		while (files.hasNext()) {
			LocatedFileStatus file = files.next();
			// file path
			String path = file.getPath().getName();
			// file blocks
			BlockLocation[] blocks = file.getBlockLocations();
			// print info
			System.out.println(path + " has " + blocks.length + " blocks");
		}
	}

}
