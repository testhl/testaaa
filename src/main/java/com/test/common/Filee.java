package com.test.common;

import java.io.File;

public class Filee {
	// 文件常用类封装
	// 判断文件是否存在
	public static boolean fileExists(String filepath) {
		File file = new File(filepath);
		// 文件是否存在
		boolean b = file.exists();
		System.out.println(b);
		// 返回是否
		return b;
	}

	// 判断文件是否存在，不存在就新建
	public static void createFile(String filepath) {
		if (!Filee.fileExists(filepath)) {
			File file = new File(filepath);
			file.mkdir();
		}
	}

	// 删除文件夹
	public static void deleteDir(String dirpath) {
		File file = new File(dirpath);
		// 如果文件是文件夹
		if (file.isDirectory()) {
			File f1 = null;
			// 获取改文件下的子文件或是文件夹
			String[] childsfile = file.list();
			for (String st : childsfile) {
				// 检查fold是否已分隔符结尾
				if (dirpath.endsWith(File.separator)) {
					f1 = new File(dirpath + st);
				} else {
					f1 = new File(dirpath + File.separator + st);
				}
				// 判断是否为文件夹
				if (f1 != null && f1.isFile()) {
					// 是文件
					f1.delete();
					f1.getAbsolutePath();
				} else if (f1 != null && f1.isDirectory()) {
					// 是文件夹,调用删除文件方法进入循环
					deleteDir(f1.getAbsolutePath());
				}
			}
			// 跳出for循环，删除
			file.delete();
		} else {
			// 文件直接删除
			file.delete();
		}
	}

	

}
