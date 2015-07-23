package com.vae.wuyunxing.vae_repositories.utils;

import java.io.File;

public class FileUtils {

	public static final String PATH_SEPARATOR = "/";

	public static String getParentPath(String remotePath) {
		String parentPath = new File(remotePath).getParent();
		parentPath = parentPath.endsWith(PATH_SEPARATOR) ? parentPath : parentPath + PATH_SEPARATOR;
		return parentPath;
	}

	/**
	 * Validate the fileName to detect if contains any forbidden character: / , \ , < , > , : , " , | , ? , *
	 */
	public static boolean isValidName(String fileName) {
		boolean result = true;

		if (fileName.contains(PATH_SEPARATOR) ||
			fileName.contains("\\") || fileName.contains("<") || fileName.contains(">") ||
			fileName.contains(":") || fileName.contains("\"") || fileName.contains("|") ||
			fileName.contains("?") || fileName.contains("*")) {
			result = false;
		}
		return result;
	}

	/**
	 * Validate the path to detect if contains any forbidden character: \ , < , > , : , " , | , ? , *
	 */
	public static boolean isValidPath(String path) {
		boolean result = true;

		if (path.contains("\\") || path.contains("<") || path.contains(">") ||
			path.contains(":") || path.contains("\"") || path.contains("|") ||
			path.contains("?") || path.contains("*")) {
			result = false;
		}
		return result;
	}
}
