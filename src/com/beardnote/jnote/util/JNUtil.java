package com.beardnote.jnote.util;

import java.io.IOException;

import jodd.io.FileUtil;
import jodd.util.SystemUtil;

import com.beardnote.jnote.gui.common.JNConstans;

public class JNUtil {
	/**
	 * 判断数据文件是否存在，不存在则创建
	 */
	public static void checkDataDir() {
		try {
			String dataDir = SystemUtil.getWorkingFolder() + JNConstans.DATA_FILE_DIR;
			FileUtil.mkdirs(dataDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		checkDataDir();
	}
}
