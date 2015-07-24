package com.vae.wuyunxing.vae_repositories.file.utils;


import com.vae.wuyunxing.vae_repositories.file.FileInfo;
import com.vae.wuyunxing.vae_repositories.file.FileCategory;
import com.vae.wuyunxing.vae_repositories.file.filter.FileFilter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FileUtil {

	/**
	 * file time (create time, modify time to string)
	 */
	public static String fileTimeToString(Calendar calendar, String pattern) {
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(calendar.getTime());
	}

	/**
	 * get file suffix
	 *
	 * @param fileName: file name
	 */
	public static String getSuffix(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index > -1) {
			return fileName.substring(index + 1);
		}
		return "";
	}

	/**
	 * get file category
	 *
	 * @param fileName: file name
	 */
	public static FileCategory filterFileCategory(String fileName) {
		if (fileName == null) {
			throw new NullPointerException("Parameter cannot be null!");
		}

		String filename = fileName.toLowerCase();
		for (FileCategory category : FileCategory.values()) {
			for (String suffix : category.getSuffixes()) {
				if (filename.endsWith('.' + suffix.toLowerCase())) {
					return category;
				}
			}
		}
		return FileCategory.OTHERS;
	}

	/**
	 * Filter file
	 * @param list: file list info
	 * @param filter: filter
	 * @return
	 */
	public static List<FileInfo> filter(List<FileInfo> list, FileFilter filter) {
		List<FileInfo> newList = new ArrayList<FileInfo>();
		for (FileInfo file : list) {
			if (filter.accept(file)) {
				newList.add(file);
			}
		}
		return newList;
	}

}
